package com.sat.backend_fasep.dto.request;

import com.sat.backend_fasep.util.*;
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
    @NotBlank(message = "firstName must be not blank") // do not allow null, empty, whitespace
    @Size(min = 3, max = 15, message = "firstName must contain at least 3 characters and maximum 15 characters.")
    private String firstName;

    @NotBlank(message = "lastName must be not blank") // do not allow null, empty, whitespace
    @Size(min = 3, max = 15, message = "lastName must contain at least 3 characters and maximum 15 characters.")
    private String lastName;

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
    @NotNull(message = "type must be not null")
    @EnumValue(name = "type", enumClass = MerchantType.class)
    private String type;
    private Integer user_id_created = 1;
    private Integer user_id_updated = 1;

    @EnumPattern(name = "userStatus", regexp = "ACTIVE|INACTIVE")
    private UserStatus userStatus;


    public MerchantRequestDTO(String username, String password, String firstName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.email = email;
    }
}
