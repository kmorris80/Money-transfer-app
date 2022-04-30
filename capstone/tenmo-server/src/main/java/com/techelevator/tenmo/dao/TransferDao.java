package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public interface TransferDao {

   String getTransferType(int transferId);

   void addToReceiverBalance(int userId, BigDecimal amount);

   void  subtractFromSenderBalance(int userId, BigDecimal amount);



   //Transfer createTransfer(int senderId, int receiverId, BigDecimal amount ) throws Exception;
   Transfer createTransfer(Transfer transfer, int senderId, int receiverId, BigDecimal amount ) throws Exception;

   boolean checkBalanceBeforeTransfer(BigDecimal balance, BigDecimal amount);

   boolean notZeroOrNegative();

   List<Transfer> transfersList();

   Transfer getTransferById(int transferId);
   BigDecimal getBalance(int userId);
}
