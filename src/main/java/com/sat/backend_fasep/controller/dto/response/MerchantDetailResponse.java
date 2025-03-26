package com.sat.backend_fasep.controller.dto.response;

import com.sat.backend_fasep.common.enumpackage.UserStatus;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Builder
public class MerchantDetailResponse implements Serializable {

    private String merchantId;
    private String aliasName;
    private String merchantName;
    private String email;
    private Double balance;
    private UserStatus status;
    private Date createdAt;
}
