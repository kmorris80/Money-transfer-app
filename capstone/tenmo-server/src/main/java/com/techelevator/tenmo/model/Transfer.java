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
    private int accountFromId;
//    @JsonProperty("account_to")
    private int accountToId;
    private int transferStatusId;


    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public Transfer(){}

    public Transfer( BigDecimal amount, int senderId, int receiverId, int transferTypeId, int accountFromId, int accountToId, int transferStatusId) {
//        this.transferId = transferId;
        this.amount = amount;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.transferTypeId = transferTypeId;
        this.accountFromId = accountFromId;
        this.accountToId = accountToId;
        this.transferStatusId = transferStatusId;
//        this.transferType = transferType;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transferId=" + transferId +
                ", amount=" + amount +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", transferType='" + transferType + '\'' +
                ", transferTypeId=" + transferTypeId +
                ", accountFromId=" + accountFromId +
                ", accountToId=" + accountToId +
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
public int getaccountFromId() {
    return accountFromId;
}

    public void setAccountFromId(int accountFromId) {
        this.accountFromId = accountFromId;
    }
    public int getAccountToId() {
        return accountToId;
    }

    public void setAccountToId(int accountToId) {
        this.accountToId = accountToId;
    }

}
