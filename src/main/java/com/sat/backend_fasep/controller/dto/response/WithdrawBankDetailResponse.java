package com.sat.backend_fasep.controller.dto.response;

import com.sat.backend_fasep.common.enumpackage.UserStatus;
import com.sat.backend_fasep.model.WithdrawBank;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Builder
public class WithdrawBankDetailResponse implements Serializable {

    private Long merchantId;
    private List<WithdrawBank> withdrawBankList;
}
