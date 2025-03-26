package com.sat.backend_fasep.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class ResetPasswordMerchantForAdminResponse implements Serializable {
    private Long merchantId;
    private String newPassword;
}
