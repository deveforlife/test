package com.sat.backend_fasep.controller.dto.response;

import com.sat.backend_fasep.common.enumpackage.UserStatus;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Builder
public class WithdrawBankDetailResponse implements Serializable {

    private Long merchantId;
    private String bankName;
    private String holderAccount;
    private String numberAccount;
    private Date createdAt;
}
