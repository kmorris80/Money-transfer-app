package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class TransferForMenu {
    private String usernameFrom;
    private String usernameTo;
    private BigDecimal amount;
    private int senderId;
    private int receiverId;

    public TransferForMenu(String usernameFrom, String usernameTo, BigDecimal amount, int senderId, int receiverId) {
        this.usernameFrom = usernameFrom;
        this.usernameTo = usernameTo;
        this.amount = amount;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public String getUsernameFrom() {
        return usernameFrom;
    }

    public void setUsernameFrom(String usernameFrom) {
        this.usernameFrom = usernameFrom;
    }

    public String getUsernameTo() {
        return usernameTo;
    }

    public void setUsernameTo(String usernameTo) {
        this.usernameTo = usernameTo;
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
        return "TransferForMenu{" +
                "usernameFrom='" + usernameFrom + '\'' +
                ", usernameTo='" + usernameTo + '\'' +
                ", amount=" + amount +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                '}';
    }
}
