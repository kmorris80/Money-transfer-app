package com.techelevator.tenmo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Transfer {
    private int transferId;
    private BigDecimal amount;
    private int senderId;
    private int receiverId;
    private String transferType;
    private int transferTypeId;
    private int accountFrom;
    private int accountTo;
    private int transferStatusId;
    private String username;
    private String transferTypeDesc;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public Transfer(){}

    public Transfer( BigDecimal amount, int senderId, int receiverId, int transferTypeId, int accountFromId, int accountToId, int transferStatusId, String username) {
//        this.transferId = transferId;
        this.amount = amount;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.transferTypeId = transferTypeId;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.transferStatusId = transferStatusId;
        this.username = username;
//        this.transferType = transferType;
    }
    //new model with usernameFrom, usernameTo, userIdFrom, userIdTo, transaction Id, amount

    @Override
    public String toString() {
        return "Transfer{" +
                "transferId=" + transferId +
                ", amount=" + amount +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", transferType='" + transferType + '\'' +
                ", transferTypeId=" + transferTypeId +
                ", accountFromId=" + accountFrom +
                ", accountToId=" + accountTo +
                '}';
    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public void setTransferStatus(int transferStatusId){ this.transferStatusId = transferStatusId;}
    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public void getTransferTypeId(int transferTypeId){
        this.transferTypeId = transferTypeId;
    }


    public void setTransferTypeId(int transfer_type_id) {
    }
public int getaccountFrom() {
    return accountFrom;
}

    public void setAccountFrom(int accountFromId) {
        this.accountFrom = accountFromId;
    }
    public int getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(int accountToId) {
        this.accountTo = accountToId;
    }

}
