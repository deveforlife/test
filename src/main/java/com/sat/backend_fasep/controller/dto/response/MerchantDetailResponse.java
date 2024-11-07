package com.sat.backend_fasep.controller.dto.response;

import com.sat.backend_fasep.common.util.UserStatus;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Builder
public class MerchantDetailResponse implements Serializable {

    private String aliasName;
    private String merchantName;
    private String email;
    private UserStatus status;
    private Date createdAt;
}
