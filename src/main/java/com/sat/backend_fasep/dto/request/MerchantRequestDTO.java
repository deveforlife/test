package com.sat.backend_fasep.dto.request;

import com.sat.backend_fasep.util.Password;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.Date;

public class MerchantRequestDTO implements Serializable {

    // Declare the components needed for the login page
    @NotBlank(message = "username must be not blank") // không cho phép null, empty, khoảng trắng
    @Size(min = 3, max = 25, message = "username must contain at least 3 characters and maximum 25 characters.")
    private String username;

    @Password
    private String password;
    private String gaKey;

    // Declare merchant's private information
    @NotBlank(message = "merchantName must be not blank") // không cho phép null, empty, khoảng trắng
    @Size(min = 3, max = 25, message = "merchantName must contain at least 3 characters and maximum 25 characters.")
    private String merchantName;

    @NotBlank(message = "merchantName must be not blank") // không cho phép null, empty, khoảng trắng
    @Size(min = 3, max = 25, message = "merchantName must contain at least 3 characters and maximum 25 characters.")
    private String displayName;

    @Email
    private String email;

    @NotBlank
    private String otherContactInfo;
    private double balance;

    // Declare API Integration Information
    private String merchantCode;
    private String secretKey;
    private String ipApiRegistration;

    // Declare information for management
//    private String type;
    private Integer user_id_created;
    private Integer user_id_updated;
    private Integer status;

    /**
     *  contructor, getter, setter
     *
     */

    public MerchantRequestDTO(String username, String password, String merchantName, String email, String phoneNumber, String otherContactInfo) {
        this.username = username;
        this.password = password;
        this.merchantName = merchantName;
        this.email = email;
//        this.phoneNumber = phoneNumber;
        this.otherContactInfo = otherContactInfo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGaKey() {
        return gaKey;
    }

    public void setGaKey(String gaKey) {
        this.gaKey = gaKey;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

/*    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }*/

    public String getOtherContactInfo() {
        return otherContactInfo;
    }

    public void setOtherContactInfo(String otherContactInfo) {
        this.otherContactInfo = otherContactInfo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getIpApiRegistration() {
        return ipApiRegistration;
    }

    public void setIpApiRegistration(String ipApiRegistration) {
        this.ipApiRegistration = ipApiRegistration;
    }

/*    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }*/

    public int getUser_id_created() {
        return user_id_created;
    }

    public void setUser_id_created(int user_id_created) {
        this.user_id_created = user_id_created;
    }

    public int getUser_id_updated() {
        return user_id_updated;
    }

    public void setUser_id_updated(int user_id_updated) {
        this.user_id_updated = user_id_updated;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
