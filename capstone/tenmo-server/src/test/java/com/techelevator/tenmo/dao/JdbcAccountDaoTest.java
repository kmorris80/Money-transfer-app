package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.*;
public class JdbcAccountDaoTest{
//    private static SingleConnectionDataSource dataSource;
    private Account testAccount;
    private JdbcAccountDao sut;

    private static final Account ACCOUNT_1 = new Account(2002, 1002, new BigDecimal("1000,00"));
    private static final Account ACCOUNT_2 = new Account(2003, 1003, new BigDecimal("1000,00"));
    private static final Account ACCOUNT_3 = new Account(2004, 1004, new BigDecimal("1000,00"));



//    @BeforeClass
//    public static void setupData(){
//        dataSource = new SingleConnectionDataSource();
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/test_tenmo");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("postgres1");
//        dataSource.setAutoCommit(false);
//    }

    @Before
    public void setup(){
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        sut = new JdbcAccountDao(jdbcTemplate);
          sut = new JdbcAccountDao(dataSource);
    }

    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

    @AfterClass
    public static void closeDataSource(){
        dataSource.destroy();
    }

    @Test
    public void getAccountById_returns_correct_account() {
        Account account = sut.getAccount(1001);
        Assert.assertEquals(2001, );

    }

    @Test
    public void subtractMoneyFromAccount() {
    }

    @Test
    public void getBalance() {
    }

    @Test
    public void findAccountIdByUserId() {

    }

    @Test
    public void addMoneyToAccount() {
    }

    @Test
    public void list() {
    }

    @Test
    public void create() {
    }
}
