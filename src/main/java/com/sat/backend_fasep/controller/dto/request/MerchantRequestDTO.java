package com.sat.backend_fasep.controller.dto.request;

import com.sat.backend_fasep.common.enumpackage.EnumPattern;
import com.sat.backend_fasep.common.enumpackage.UserStatus;
import com.sat.backend_fasep.common.annocustom.*;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.io.Serializable;

// @Data = @Getter + @Setter + @EqualsAndHashCode + @ToString
// @Builder
// @EqualAndHashCode = so sánh các đối tượng (object)
// @ToString (Include - Exclude)

@Getter
public class MerchantRequestDTO implements Serializable {

    // Declare the components needed for the register page
    @NotBlank(message = "merchantName must be not blank") // do not allow null, empty, whitespace
    @Size(min = 3, max = 15, message = "merchantName must contain at least 3 characters and maximum 15 characters.")
    private String merchantName;

    @Email
    private String email;

    @Username
    private String username;

    @Password
    private String password;

    @EnumPattern(name = "userStatus", regexp = "ACTIVE|SUSPENDED|CLOSED")
    private UserStatus userStatus;

    public MerchantRequestDTO(String merchantName, String email, String username, String password) {
        this.merchantName = merchantName;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
