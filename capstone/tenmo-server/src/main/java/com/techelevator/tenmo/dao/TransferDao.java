package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface TransferDao {

   String getTransferType(int transferId);

   Transfer addToReceiverBalance(int userId, BigDecimal amount);

   Transfer subtractFromSenderBalance(int userId, BigDecimal amount);

   Transfer createTransfer(Transfer transfer, int senderId, int receiverId, BigDecimal amount );

   boolean checkBalanceBeforeTransfer();

   boolean notZeroOrNegative();

   List<Transfer> transfersList();

   Transfer getTransferById(int transferId);

}
