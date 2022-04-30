package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {
    private int transferId;
    private BigDecimal amount;
    private int senderId;
    private int receiverId;
    private String transferType;

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public Transfer(){}

    public Transfer(BigDecimal amount, int senderId, int receiverId) {
        this.amount = amount;
        this.senderId = senderId;
        this.receiverId = receiverId;

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


    @Override
    public String toString() {
        return "Transfer{" +
                "transferId=" + transferId +
                ", amount=" + amount +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", transferType='" + transferType + '\'' +
                '}';
    }
}
