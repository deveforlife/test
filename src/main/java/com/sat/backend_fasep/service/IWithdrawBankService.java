package com.sat.backend_fasep.service;

import com.sat.backend_fasep.controller.dto.request.WithdrawBankRequestDTO;
import com.sat.backend_fasep.controller.dto.response.WithdrawBankDetailResponse;

import java.util.List;

public interface IWithdrawBankService {

    long saveWithdrawBank(long merchantId, WithdrawBankRequestDTO request);

    void updateWithdrawBank(long merchantId,long withdrawBankId, WithdrawBankRequestDTO request);

    // void changeStatus(long merchantId, UserStatus status);

    void deleteWithdrawBank(long merchantId, long withdrawBankId);

    WithdrawBankDetailResponse getWithdrawBank(long merchantId, int pageNo, int pageSize);

    //List<WithdrawBankDetailResponse> getAllWithdrawBank(int pageNo, int pageSize);
}
