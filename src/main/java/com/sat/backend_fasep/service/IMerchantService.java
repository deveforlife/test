package com.sat.backend_fasep.service;

import com.sat.backend_fasep.common.enumpackage.UserStatus;
import com.sat.backend_fasep.controller.dto.request.MerchantRequestDTO;
import com.sat.backend_fasep.controller.dto.response.MerchantDetailResponse;
import com.sat.backend_fasep.controller.dto.response.ResetPasswordMerchantForAdminResponse;

import java.util.List;

public interface IMerchantService {

    long saveMerchant(MerchantRequestDTO request);

    void updateMerchant(long merchantId, MerchantRequestDTO request);

    void changeStatus(long merchantId, UserStatus status);

    // add Balance
    void addMerchantBalance(long merchantId, Double amount);

    // deduct Balance
    void deductMerchantBalance(long merchantId, Double amount);

    // Administrator, Manager permission only
    void changeAliasName(long merchantId, String newAliasName);

    // Administrator permission only
    ResetPasswordMerchantForAdminResponse resetPassword(long merchantId);

    void deleteMerchant(long merchantId);

    MerchantDetailResponse getMerchant(long merchantId);

    List<MerchantDetailResponse> getAllMerchant(int pageNo, int pageSize);
}
