package com.sat.backend_fasep.controller.dto.request;

import java.io.Serializable;

public class OrderRequestDTO implements Serializable {

    // API for merchant
    private String orderId;
    private String merchantId;
    private String merchantKey;
    private String transactionId;
    private Long moneyRequest;
    private String contentRequest;
    private String customerIp;
    private String callbackUrl;
    private String type;
    private String signature;

    public String getOrderId() {
        return orderId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getMerchantKey() {
        return merchantKey;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Long getMoneyRequest() {
        return moneyRequest;
    }

    public String getContentRequest() {
        return contentRequest;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public String getType() {
        return type;
    }

    public String getSignature() {
        return signature;
    }
}
