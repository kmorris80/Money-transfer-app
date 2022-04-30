package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;

@RestController
@RequestMapping(path = "/transfers")
public class TransferController {
    TransferDao transferDao;
    UserDao userDao;
    AccountDao accountDao;

    @Autowired
    public TransferController(TransferDao transferDao, UserDao userDao, AccountDao accountDao) {
        this.transferDao = transferDao;
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    public void depositMoney(BigDecimal amount, int id){
        accountDao.getAccount(id);


    }

 @RequestMapping(method = RequestMethod.PUT)
public void withdrawlFromSender(@RequestBody Transfer transfer, Principal principal){
      int senderId =  userDao.findIdByUsername(principal.getName());
      transfer.setSenderId(userDao.findIdByUsername(principal.getName()));
//        transferDao.createTransfer();

      transferDao.subtractFromSenderBalance(senderId, transfer.getAmount() );
        transferDao.addToReceiverBalance(transfer.getReceiverId(), transfer.getAmount());


        //transfer dao to write to transfer table
 }


}
