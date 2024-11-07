package com.sat.backend_fasep.controller.dto.request;

import com.sat.backend_fasep.common.util.*;
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

    @NotBlank(message = "username must be not blank") // không cho phép null, empty, khoảng trắng
    @Size(min = 3, max = 25, message = "username must contain at least 3 characters and maximum 25 characters.")
    private String username;

    @Password
    private String password;

    // Declare merchant's private information
    private String alias;
    private String gaKey;
    private Double balance;

    // Declare API Integration Information
    private String merchantCode;
    private String secretKey;
    private String ipApiRegistration;

    // Declare information for management
    private Integer user_id_created;
    private Integer user_id_updated;

    @EnumPattern(name = "userStatus", regexp = "ACTIVE|SUSPENDED|CLOSED")
    private UserStatus userStatus;

    public MerchantRequestDTO(String merchantName, String email, String username, String password) {
        this.merchantName = merchantName;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
