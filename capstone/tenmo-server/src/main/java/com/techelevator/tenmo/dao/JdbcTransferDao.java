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
        return null;
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
        return null;
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
