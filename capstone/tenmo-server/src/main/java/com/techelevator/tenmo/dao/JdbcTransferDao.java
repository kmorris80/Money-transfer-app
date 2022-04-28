package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao{

    private JdbcTemplate jdbcTemplate;

    public Transfer transfer;




    @Override
    public String getTransferType(int transferId) {
        String sql = "SELECT transfer_type_desc \n" +
                "FROM transfer_type \n" +
                "JOIN transfer ON transfer_type.transfer_type_id = transfer.transfer_type_id \n" +
                "WHERE transfer_id = ?";

        return jdbcTemplate.queryForObject(sql , String.class , transferId);
    }

    @Override
    public Transfer addToReceiverBalance(int userId, BigDecimal amount) {
        return null;
    }

    @Override
    public Transfer subtractFromSenderBalance(int userId, BigDecimal amount) {
        return null;
    }

    @Override
    public Transfer createTransfer(Transfer transfer, int senderId, int receiverId, BigDecimal amount) {
        String sql = "INSERT INTO transfer(transfer_type_id, transfer_status_id, account_from, account_to, amount)\n" +
                "VALUES (?, ?, ?, ?, ?) RETURNING transfer_id";

        return jdbcTemplate.queryForObject(sql, Transfer.class, transfer.getTransferType(), transfer.getReceiverId(), transfer.getAmount(),
                transfer.getSenderId(), transfer.getTransferId());
    }

    @Override
    public boolean checkBalanceBeforeTransfer() {
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
    public boolean notZeroOrNegative() {
        return false;
    }

}
