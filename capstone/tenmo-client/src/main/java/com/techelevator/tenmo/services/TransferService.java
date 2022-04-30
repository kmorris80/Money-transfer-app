package com.techelevator.tenmo.services;


//import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class TransferService {
    //        Transfer transfer = new Transfer();
    public static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public boolean sendMoney(Transfer transfer) {
//
        boolean success = false;
        try {
            restTemplate.exchange(API_BASE_URL + "transfers/", HttpMethod.PUT, makeTransferEntity(transfer), Void.class);
            success = true;
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());

        }
        System.out.println(success);
        return success;
    }
    public Transfer[] getTransferList(){
        Transfer[] transfers = null;
        try {
            //   return restTemplate.exchange(API_BASE_URL + "users", HttpMethod.GET, makeAuthEntity(), List<User>.class);
            ResponseEntity<Transfer[]> response = restTemplate.exchange(API_BASE_URL + "transfers/", HttpMethod.GET, makeAuthEntity(), Transfer[].class);
            transfers = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return transfers;
    }


    //
//
    private HttpEntity<Transfer> makeTransferEntity(Transfer transfer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(transfer, headers);
        }


        private HttpEntity<Void> makeAuthEntity () {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(authToken);
            return new HttpEntity<>(headers);
        }
    }

