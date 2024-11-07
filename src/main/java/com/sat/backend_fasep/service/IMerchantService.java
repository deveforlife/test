package com.sat.backend_fasep.service;

import com.sat.backend_fasep.common.util.UserStatus;
import com.sat.backend_fasep.controller.dto.request.MerchantRequestDTO;
import com.sat.backend_fasep.controller.dto.response.MerchantDetailResponse;

import java.util.List;

public interface IMerchantService {

    long saveMerchant(MerchantRequestDTO request);

    void updateMerchant(long merchantId, MerchantRequestDTO request);

    void changeStatus(long merchantId, UserStatus status);

    void deleteMerchant(long merchantId);

    MerchantDetailResponse getMerchant(long merchantId);

    List<MerchantDetailResponse> getAllMerchant(int pageNo, int pageSize);
}
