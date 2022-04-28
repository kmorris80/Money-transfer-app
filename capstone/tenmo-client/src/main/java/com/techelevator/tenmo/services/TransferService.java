package com.techelevator.tenmo.services;

//import com.techelevator.tenmo.model.Transfer;
//import com.techelevator.tenmo.model.Transfer;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class TransferService {

    public static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

        public void sendMoney(BigDecimal amount, int id){
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity< Transfer > entity = new HttpEntity<>(amount, id,  headers);
        try{
            restTemplate.exchange(API_BASE_URL + "transfers?amount=" + amount + "&id=" + id, HttpMethod.POST, makeAuthEntity(), Void.class);
        } catch (RestClientResponseException  | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            }
        }





//        private HttpEntity<Transfer> makeTansferEntity(Transfer transfer) {
//
//        headers.setBearerAuth(authToken);
//        return new HttpEntity<>(transfer, headers);
//        }



        private HttpEntity<Void> makeAuthEntity() {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(authToken);
            return new HttpEntity<>(headers);
        }
}
