package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.User;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TenmoService {

    public static final String API_BASE_URL = "http://localhost:8080/accounts/" ;
    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public BigDecimal getBalance(){
        BigDecimal balance = null;
        try{
            ResponseEntity< BigDecimal > response = restTemplate.exchange(API_BASE_URL , HttpMethod.GET, makeAuthEntity(), BigDecimal.class );
            balance = response.getBody();
        }
        catch (RestClientResponseException | ResourceAccessException e ) {
            BasicLogger.log(e.getMessage());
        }
        return balance;
    }
//    public User[] getAll(){
//        User[] users = null;
    public User[] getAll(){
            User[] users = null;
        try {
         //   return restTemplate.exchange(API_BASE_URL + "users", HttpMethod.GET, makeAuthEntity(), List<User>.class);
            ResponseEntity<User[]> response = restTemplate.exchange(API_BASE_URL + "users", HttpMethod.GET, makeAuthEntity(), User[].class);
            users = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return users;
    }



    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }
}
