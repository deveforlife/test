package com.sat.backend_fasep.service.impl;

import com.sat.backend_fasep.controller.dto.request.WithdrawBankRequestDTO;
import com.sat.backend_fasep.controller.dto.response.WithdrawBankDetailResponse;
import com.sat.backend_fasep.model.WithdrawBank;
import com.sat.backend_fasep.repository.WithdrawBankRepository;
import com.sat.backend_fasep.service.IWithdrawBankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WithdrawBankServiceImpl implements IWithdrawBankService {

    private final WithdrawBankRepository withdrawBankRepository;
    private final MerchantServiceImpl merchantService;

    @Override
    public long saveWithdrawBank(long merchantId, WithdrawBankRequestDTO request) {
        WithdrawBank withdrawBank = WithdrawBank.builder()
                .merchantId(merchantService.getMerchantId(merchantId).getId())
                .bankName(request.getBankName())
                .numberAccount(request.getNumberAccount())
                .holderAccount(request.getHolderAccount())
                .build();

        withdrawBankRepository.save(withdrawBank);
        log.info("Create withdraw bank successfully");

        return withdrawBank.getId();
    }

    @Override
    public void updateWithdrawBank(long merchantId, long withdrawBankId, WithdrawBankRequestDTO request) {
        // duyet phan tu withdrawbank co merchantid
        for (WithdrawBank withdrawBank : withdrawBankRepository.findByMerchantId(merchantId)){
            if (withdrawBank.getId() == withdrawBankId) {
                withdrawBank.setBankName(request.getBankName());
                withdrawBank.setHolderAccount(request.getHolderAccount());
                withdrawBank.setNumberAccount(request.getNumberAccount());

                withdrawBankRepository.save(withdrawBank);
            }
        }
        log.info("update success");
    }

    @Override
    public void deleteWithdrawBank(long merchantId, long withdrawBankId) {
        for (WithdrawBank withdrawBank : withdrawBankRepository.findByMerchantId(merchantId)){
            if (withdrawBank.getId() == withdrawBankId) {
                withdrawBankRepository.deleteById(withdrawBankId);
            }
        }
        log.info("Delete withdraw bank success");
    }

    @Override
    public WithdrawBankDetailResponse getWithdrawBank(long merchantId, int pageNo, int pageSize) {
        List<WithdrawBank> withdrawList = withdrawBankRepository.findByMerchantId(merchantId);

        return WithdrawBankDetailResponse.builder()
                    .merchantId(merchantId)
                    .withdrawBankList(withdrawList.stream().toList())
                .build();
    }

    /*
    @Override
    public List<WithdrawBankDetailResponse> getAllWithdrawBank(int pageNo, int pageSize) {
        return List.of();
    }*/

}
