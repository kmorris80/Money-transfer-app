package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;

@RestController
public class AccountController {

    UserDao userDao;

    @Autowired
    public AccountController(UserDao userDao) {  //when we create an account controller, i need a user dao
        this.userDao = userDao;
    }
    @RequestMapping(path ="/accounts", method = RequestMethod.GET)
    public BigDecimal  getAccountBalance(Principal principal){

        String username = principal.getName(); //if logged in, we can get their name
        int userId = userDao.findIdByUsername(username);

        return BigDecimal.TEN;

        //now go and find the balance for the userId
        //create an accountsDao
        //create an accounts jdbc class
        //use dependency injection to inject accountsDao
    }



}
