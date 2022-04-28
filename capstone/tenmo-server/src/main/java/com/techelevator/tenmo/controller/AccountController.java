package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
public class AccountController {  //gets the request from client on port 8080

    AccountDao accountDao; //controller talks through the dao
    UserDao userDao;

    @Autowired
    public AccountController(UserDao userDao, AccountDao accountDao) {  //when we create an account controller, i need a user dao
        this.userDao = userDao;
        this.accountDao = accountDao;
    }

    @RequestMapping(path = "/accounts", method = RequestMethod.GET)
//someone is requesting information, and i'm goign to run method
    public BigDecimal getAccountBalance(Principal principal) {

        String username = principal.getName(); //if logged in, we can get their name
        int userId = userDao.findIdByUsername(username); //can get their userId because principal gave us the name (principal is already coded)

        Account account = accountDao.getAccount(userId);
        return account.getBalance();

        //now go and find the balance for the userId
        //create an accountsDao
        //create an accounts jdbc class
        //use dependency injection to inject accountsDao
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getUsersToSendMoney() {
        return userDao.findAllForSendingMoney();

    }
//
//    @RequestMapping(path = "/users", method = RequestMethod.GET)
//    public List<User> getAll() {
//        return userDao.findAll();
//    }

}


