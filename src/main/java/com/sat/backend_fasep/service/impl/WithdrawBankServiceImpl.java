package com.sat.backend_fasep.service.impl;

//import com.sat.backend_fasep.controller.dto.request.WithdrawBankRequestDTO;
//import com.sat.backend_fasep.controller.dto.response.WithdrawBankDetailResponse;
//import com.sat.backend_fasep.model.MerchantEntity;
//import com.sat.backend_fasep.model.WithdrawBank;
//import com.sat.backend_fasep.repository.WithdrawBankRepository;
//import com.sat.backend_fasep.service.IWithdrawBankService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;

//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class WithdrawBankServiceImpl implements IWithdrawBankService {
//
//    private final WithdrawBankRepository withdrawBankRepository;
//    private final MerchantServiceImpl merchantService;
//
//    @Override
//    public long saveWithdrawBank(long merchantId, WithdrawBankRequestDTO request) {
//
//        WithdrawBank withdrawBank = WithdrawBank.builder()
//                .merchantEntity(merchantService.getMerchantId(merchantId))
//                .bankName(request.getBankName())
//                .numberAccount(request.getNumberAccount())
//                .holderAccount(request.getHolderAccount())
//                .build();
//
//        withdrawBankRepository.save(withdrawBank);
//        return withdrawBank.getId();
//    }
//
//    @Override
//    public void updateWithdrawBank(long merchantId, long withdrawBankId, WithdrawBankRequestDTO request) {
//
//        for (WithdrawBank withdrawBank : withdrawBankRepository.findAll()) {
//            if (withdrawBank.getMerchantEntity().getId() == merchantId && withdrawBank.getId() == withdrawBankId) {
//                withdrawBank.setBankName(request.getBankName());
//                withdrawBank.setHolderAccount(request.getHolderAccount());
//                withdrawBank.setNumberAccount(request.getNumberAccount());
//
//                withdrawBankRepository.save(withdrawBank);
//                log.info("update success");
//            }
//        }
//
//    }
//
//    @Override
//    public void deleteWithdrawBank(long merchantId, long withdrawBankId) {
////        withdrawBankRepository.findAll().forEach(withdrawBank -> {
////
////        });
//        log.info("delete success");
//    }
//
////    @Override
////    public List<WithdrawBankDetailResponse> getWithdrawBank(long merchantId) {
////        Map<> bankList = new ArrayList<>();
////
////        withdrawBankRepository.findBy
////
////        for (WithdrawBank withdrawBank : withdrawBankRepository.findAll()) {
////            if (withdrawBank.getMerchantEntity().getId() == merchantId) {
////
////            }
////        }
////
////        Map<>
////
////
////        return ;
////    }
//
//    @Override
//    public List<WithdrawBankDetailResponse> getAllWithdrawBank(int pageNo, int pageSize) {
//        return List.of();
//    }
//}
