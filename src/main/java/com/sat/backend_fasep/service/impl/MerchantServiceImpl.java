package com.sat.backend_fasep.service.impl;

import com.sat.backend_fasep.common.GeneratePasswordWithRegex;
import com.sat.backend_fasep.common.enumpackage.UserStatus;
import com.sat.backend_fasep.controller.dto.request.MerchantRequestDTO;
import com.sat.backend_fasep.controller.dto.request.WithdrawBankRequestDTO;
import com.sat.backend_fasep.controller.dto.response.MerchantDetailResponse;
import com.sat.backend_fasep.controller.dto.response.ResetPasswordMerchantForAdminResponse;
import com.sat.backend_fasep.exception.ResourceNotFoundException;
import com.sat.backend_fasep.model.MerchantEntity;
import com.sat.backend_fasep.model.WithdrawBank;
import com.sat.backend_fasep.repository.MerchantRepository;
import com.sat.backend_fasep.service.IMerchantService;
import lombok.RequiredArgsConstructor;
import lombok.With;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class MerchantServiceImpl implements IMerchantService {

    private final MerchantRepository merchantRepository;

    @Override
    public long saveMerchant(MerchantRequestDTO request) {
        MerchantEntity merchant = MerchantEntity.builder()
                    .merchantName(request.getMerchantName())
                    .email(request.getEmail()) // Check for duplicates in code and set unique values in Database
                    .username(request.getUsername()) //C heck for duplicates in code and set unique values in Database
                    .password(request.getPassword())
                    .aliasName("New Merchant")
                    .status(request.getUserStatus())
                    .merchantId(GenerateUserId()) // Check for duplicates in code and set unique values in Database
                    .balance(0d)
                    .secretKey(GenerateSecretKey()) // Check for duplicates in code and set unique values in Database
                .build();

        merchantRepository.save(merchant);
        log.info("Merchant saved");

        return merchant.getId();
    }

    @Override
    public void updateMerchant(long merchantId, MerchantRequestDTO request) {
        MerchantEntity merchant = getMerchantId(merchantId);
        log.info("Merchant update successfully");
    }

    @Override
    public void changeStatus(long merchantId, UserStatus status) {
        MerchantEntity merchant = getMerchantId(merchantId);
        merchant.setStatus(status);
        merchantRepository.save(merchant);

        log.info("Merchant status changed successfully");
    }

    // add merchant balance
    @Override
    public void addMerchantBalance(long merchantId, Double amount){
        MerchantEntity merchant = getMerchantId(merchantId);

        // Check if amount is a positive integer or decimal or not
        if (amount <= 0 || amount % 1 != 0) {
            log.error("amount={} ", amount);

            throw new ResourceNotFoundException("Incorrect input");
        }
        // add amount to balance of merchant
        else {
            merchant.setBalance(merchant.getBalance()+amount);
            merchantRepository.save(merchant);
        }

        log.info("Balance changed successfully");
    }

    // deduct merchant balance
    @Override
    public void deductMerchantBalance(long merchantId, Double amount){
        MerchantEntity merchant = getMerchantId(merchantId);

        // Check if amount is a positive integer or decimal or not, compare amount with current balance
        if (amount <= 0 || amount % 1 != 0 || amount > merchant.getBalance()) {
            log.error("amount={} ", amount);

            throw new ResourceNotFoundException("Incorrect input");
        }
        // deduct amount to balance of merchant
        else {
            log.info("------> Amount before deduct={}", merchant.getBalance());

            merchant.setBalance(merchant.getBalance()-amount);
            merchantRepository.save(merchant);

            log.info("------> Amount after deduct={}", merchant.getBalance());
        }

        log.info("Balance changed successfully");
    }

    // Administrator, Manager permission only - change merchant alias name
    @Override
    public void changeAliasName(long merchantId, String newAliasName){
        MerchantEntity merchant = getMerchantId(merchantId);
        merchant.setAliasName(newAliasName);
        merchantRepository.save(merchant);

        log.info("Merchant alias name changed successfully");
    }


    // Administrator permission only
    @Override
    public ResetPasswordMerchantForAdminResponse resetPassword(long merchantId){
        MerchantEntity merchant = getMerchantId(merchantId);

        // generate random password
        GeneratePasswordWithRegex newResetPassword = new GeneratePasswordWithRegex();
        String newPassword = newResetPassword.generatePassword();

        // encrypt password after reset
        String encryptPassword = newPassword;

        // save encrypt password to DB
        merchant.setPassword(encryptPassword);
        merchantRepository.save(merchant);

        return ResetPasswordMerchantForAdminResponse.builder()
                .merchantId(merchant.getId())
                .newPassword(newPassword)
                .build();
    }

    @Override
    public void deleteMerchant(long merchantId) {
        merchantRepository.deleteById(merchantId);

        log.info("Merchant deleted successfully, merchantId={}", merchantId);
    }

    @Override
    public MerchantDetailResponse getMerchant(long merchantId) {
        MerchantEntity merchant = getMerchantId(merchantId);
        return MerchantDetailResponse.builder()
                .merchantId(merchant.getMerchantId())
                .merchantName(merchant.getMerchantName())
                .aliasName(merchant.getAliasName())
                .email(merchant.getEmail())
                .balance(merchant.getBalance())
                .status(merchant.getStatus())
                .createdAt(merchant.getCreatedAt())
                .build();
    }

    @Override
    public List<MerchantDetailResponse> getAllMerchant(int pageNo, int pageSize) {
        // ???
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<MerchantEntity> merchants = merchantRepository.findAll(pageable);

        if (merchants.getTotalElements() == 0) {
            log.info("------> merchant list = {}", merchants.getTotalElements());

            throw new ResourceNotFoundException("No data");
        }
        else {
            // Get each element added to the list and return the result
            return merchants.stream().map(merchant -> MerchantDetailResponse.builder()
                            .merchantName(merchant.getMerchantName())
                            .aliasName(merchant.getAliasName())
                            .email(merchant.getEmail())
                            .status(merchant.getStatus())
                            .createdAt(merchant.getCreatedAt())
                            .build())
                    .toList();
        }
    }

    // other methods to handle business
    private MerchantEntity getMerchantId(long merchantId){
        return merchantRepository.findById(merchantId).orElseThrow(() -> new ResourceNotFoundException("Merchant not found"));
    }

    //
    private String GenerateSecretKey() {
        String characters = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz123456789";
        return RandomStringUtils.random( 30, characters );
    }

    //
    private String GenerateUserId() {
        String characters = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz123456789";
        return RandomStringUtils.random( 20, characters );
    }

    /**
     * Convert Set<AddressDTO> to Set<Address>
     *
     * @param
     * @return
     */
    private Set<WithdrawBank> convertToWithdrawBank(Set<WithdrawBankRequestDTO> withdrawBanks) {
        Set<WithdrawBank> result = new HashSet<>();
        withdrawBanks.forEach(a ->
                result.add(WithdrawBank.builder()
                            .bankName(a.getBankName())
                            .holderAccount(a.getHolderAccount())
                            .numberAccount(a.getNumberAccount())
                        .build())
        );
        return result;
    }
}
