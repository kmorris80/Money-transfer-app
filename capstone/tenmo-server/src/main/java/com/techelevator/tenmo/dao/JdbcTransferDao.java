package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao{

    private JdbcTemplate jdbcTemplate;
    private AccountDao accountDao;
    private Account account;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate, AccountDao accountDao){  //Spring needs to run the sql request
        this.jdbcTemplate = jdbcTemplate;
        this.accountDao = accountDao;
    }


    @Override
    public String getTransferType(int transferId) {
        String sql = "SELECT transfer_type_desc \n" +
                "FROM transfer_type \n" +
                "JOIN transfer ON transfer_type.transfer_type_id = transfer.transfer_type_id \n" +
                "WHERE transfer_id = ?";

        return jdbcTemplate.queryForObject(sql , String.class , transferId);
    }

    @Override
//    public void addToReceiverBalance( Transfer transfer, int userId) {
    public void addToReceiverBalance(int userId, BigDecimal amount) {
        String sql= "UPDATE account SET balance = balance + ? WHERE user_id = ?";


        jdbcTemplate.update(sql, amount, userId); //correlate to ?
        }

    @Override
    public void subtractFromSenderBalance(int userId, BigDecimal amount) {
        String sql = "UPDATE account SET balance = balance - ? WHERE user_id = ?";
        jdbcTemplate.update(sql, amount, userId );
    }

    @Override
//    public Transfer createTransfer(Transfer transfer, int senderId, int receiverId, int accountFrom, int accountTo, BigDecimal amount) throws Exception{
    public boolean createTransfer(Transfer transfer) throws Exception{
        System.out.println(transfer.toString());
        String sql = "INSERT INTO transfer(transfer_type_id, transfer_status_id, account_from, account_to, amount)\n" +
                "VALUES (?, ?, (SELECT account_id FROM account WHERE user_id = ?), (SELECT account_id FROM account WHERE user_id = ?), ?) RETURNING transfer_id";
        BigDecimal amount = transfer.getAmount();
        boolean success = false;
        if (amount.compareTo(accountDao.getBalance(transfer.getSenderId())) <= 0 && amount.compareTo(BigDecimal.ZERO) > 0 ){
           int id =  jdbcTemplate.queryForObject(sql, int.class,2, 2,transfer.getSenderId(), transfer.getReceiverId(), transfer.getAmount());
           sql = "SELECT * FROM transfer WHERE transfer_id = ?";
           SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
           success = true;
           if (results.next()){
                mapRowToTransfer(results);
           }

        }else
            throw new Exception("Transfer not logged.");
        return success;
    }
//        else
//            throw new Exception("WHOOOPS not enough money.");
private Transfer mapRowToTransfer(SqlRowSet results) throws Exception {
        Transfer transfer = new Transfer();
        transfer.setTransferId(results.getInt("transfer_id"));
        transfer.setTransferTypeId(results.getInt("transfer_type_id"));
        transfer.setAccountFromId(results.getInt("account_from"));
        transfer.setAccountToId(results.getInt("account_to"));
        transfer.setAmount(BigDecimal.valueOf(Double.valueOf(results.getString("amount"))));
        transfer.setTransferStatus(results.getInt("transfer_status_id"));
        transfer.setTransferType(getTransferTypeDescByTransferId(results.getInt("transfer_type_id")));
        return transfer;
}

    @Override
    public boolean checkBalanceBeforeTransfer(BigDecimal balance, BigDecimal amount) {
        return false;
    }

    @Override
    public List<Transfer> getTransfersList(int id) throws Exception {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT transfer_id, amount, account_from, account_to, transfer_type_id, transfer_status_id " +
        " FROM transfer JOIN account ON transfer.account_from = account.account_id" +
        " WHERE account.user_id = ?";

        SqlRowSet transferList = jdbcTemplate.queryForRowSet(sql, id);
        while(transferList.next()){
            Transfer transfer = mapRowToTransfer(transferList);
            transfers.add(transfer);
        }
        return transfers;
    }

    @Override
    public Transfer getTransferById(int transferId) throws Exception{
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount " +
                " FROM transfer WHERE transfer_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId);
        if (results.next()){
            return mapRowToTransfer(results);
        }
        throw new Exception("Transfer ID" + transferId + "was not found.");
    }

    public String getTransferTypeDescByTransferId(int transferId) throws Exception{
        String sql = "SELECT transfer_type_desc FROM transfer_type WHERE transfer_type_id =?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId);
        if(results.next()){
            return results.getString("transfer_type_desc");

        }
        throw new Exception("Transfer desc not found.");
    }

    @Override
    public BigDecimal getBalance(int userId) {
        return null;
    }

    @Override
    public int getSetAccountFromId(int accountFromId) {
        return 0;
    }


    @Override
    public boolean notZeroOrNegative() {
        return false;
    }

}
