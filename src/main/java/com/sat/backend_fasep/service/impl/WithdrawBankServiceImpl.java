package com.sat.backend_fasep.service.impl;

import com.sat.backend_fasep.controller.dto.request.WithdrawBankRequestDTO;
import com.sat.backend_fasep.controller.dto.response.WithdrawBankDetailResponse;
import com.sat.backend_fasep.service.IWithdrawBankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WithdrawBankServiceImpl implements IWithdrawBankService {

    //private final WithdrawBankRepository withdrawBankRepository;

    @Override
    public long saveWithdrawBank(long merchantId, WithdrawBankRequestDTO request) {
        return 0;
    }

    @Override
    public void updateWithdrawBank(long merchantId, WithdrawBankRequestDTO request) {

    }

    @Override
    public void deleteWithdrawBank(long merchantId) {

    }

    @Override
    public WithdrawBankDetailResponse getWithdrawBank(long merchantId) {
        return null;
    }

    @Override
    public List<WithdrawBankDetailResponse> getAllWithdrawBank(int pageNo, int pageSize) {
        return List.of();
    }
}
