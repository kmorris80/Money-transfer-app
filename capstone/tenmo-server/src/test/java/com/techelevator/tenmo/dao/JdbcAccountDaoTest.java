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
public class JdbcAccountDaoTest {
    private static SingleConnectionDataSource dataSource;
    private Account testAccount;
    private JdbcAccountDao sut;

    @BeforeClass
    public static void setupData(){
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/test_tenmo");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);
    }

    @Before
    public void setup(){
        String sql = "INSERT account (account_id, user_id, balance) VALUES (2001, 1001, 1000)" ;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
        sut = new JdbcAccountDao(jdbcTemplate);
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
    public void getAccount_returns_correct_account() {
        Account account = sut.getAccount(1001);
        Assert.assertEquals(2001, account.getBalance());

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
