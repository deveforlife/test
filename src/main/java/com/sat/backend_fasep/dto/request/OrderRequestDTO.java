package com.sat.backend_fasep.dto.request;

import java.io.Serializable;

public class OrderRequestDTO implements Serializable {

    // API for merchant
    private String merchantId;
    private String merchantKey;
    private String transactionId;
    private Double moneyRequest;
    private String customerIp;
    private String callbackUrl;
    private String type;
}
