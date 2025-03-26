package com.sat.backend_fasep.controller.dto.request;

import com.sat.backend_fasep.common.annocustom.Password;
import com.sat.backend_fasep.common.annocustom.Username;
import com.sat.backend_fasep.common.enumpackage.EnumPattern;
import com.sat.backend_fasep.common.enumpackage.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.io.Serializable;

// @Data = @Getter + @Setter + @EqualsAndHashCode + @ToString
// @Builder
// @EqualAndHashCode = so sánh các đối tượng (object)
// @ToString (Include - Exclude)

@Getter
public class WithdrawBankRequestDTO implements Serializable {

    @NotBlank
    private String bankName;

    @NotBlank
    private String holderAccount;

    @NotBlank
    private String numberAccount;

    public WithdrawBankRequestDTO(String bankName, String holderAccount, String numberAccount) {
        this.bankName = bankName;
        this.holderAccount = holderAccount;
        this.numberAccount = numberAccount;
    }
}
