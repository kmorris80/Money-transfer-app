package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao{

    private JdbcTemplate jdbcTemplate;
    private AccountDao accountDao;

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
    public Transfer createTransfer(Transfer transfer, int senderId, int receiverId, BigDecimal amount) throws Exception{
        String sql = "INSERT INTO transfer(transfer_type_id, transfer_status_id, account_from, account_to, amount)\n" +
                "VALUES (?, ?, ?, ?, ?) RETURNING transfer_id";
        if (  amount.compareTo(accountDao.getBalance(senderId)) <= 0 && amount.compareTo(BigDecimal.ZERO) > 0 ){
           return jdbcTemplate.queryForObject(sql, Transfer.class, transfer.getTransferType(), transfer.getReceiverId(), transfer.getAmount(),
                    transfer.getSenderId(), transfer.getTransferId());
        }
        else
            throw new Exception("WHOOOPS not enough money.");
    }

    @Override
    public boolean checkBalanceBeforeTransfer(BigDecimal balance, BigDecimal amount) {


        return false;
    }

    @Override
    public List<Transfer> transfersList() {
        return null;
    }

    @Override
    public Transfer getTransferById(int transferId) {
        return null;
    }

    @Override
    public BigDecimal getBalance(int userId) {
        return null;
    }


    @Override
    public boolean notZeroOrNegative() {
        return false;
    }

}
