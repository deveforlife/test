package com.sat.backend_fasep.controller.dto.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.sat.backend_fasep.common.enumpackage.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Builder
public class OrderDetailsResponse implements Serializable{
    private String transactionId;
    private String payUrl;
    private Double moneyRequest;
    private String contentRequest;
    private JsonNode beneficiaryInfo;
    private Date createdAt;
}