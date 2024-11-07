package com.sat.backend_fasep.service.impl;

import com.sat.backend_fasep.common.util.UserStatus;
import com.sat.backend_fasep.controller.dto.request.MerchantRequestDTO;
import com.sat.backend_fasep.controller.dto.response.MerchantDetailResponse;
import com.sat.backend_fasep.exception.ResourceNotFoundException;
import com.sat.backend_fasep.model.MerchantEntity;
import com.sat.backend_fasep.repository.MerchantRepository;
import com.sat.backend_fasep.service.IMerchantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MerchantServiceImpl implements IMerchantService {

    private final MerchantRepository merchantRepository;

    @Override
    public long saveMerchant(MerchantRequestDTO request) {
        MerchantEntity merchant = MerchantEntity.builder()
                .merchantName(request.getMerchantName())
                .email(request.getEmail())
                .username(request.getUsername())
                .password(request.getPassword())
                .aliasName("New Merchant")
                .status(request.getUserStatus())
                .build();

        merchantRepository.save(merchant);
        log.info("Merchant saved");

        return merchant.getId();
    }

    @Override
    public void updateMerchant(long merchantId, MerchantRequestDTO request) {
        MerchantEntity merchant = getMerchantId(merchantId);
        merchant.setAliasName(request.getAlias());
        merchant.setPassword(request.getPassword());

        log.info("Merchant update successfully");
    }

    @Override
    public void changeStatus(long merchantId, UserStatus status) {
        MerchantEntity merchant = getMerchantId(merchantId);
        merchant.setStatus(status);
        merchantRepository.save(merchant);

        log.info("Merchant status changed successfully");
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
                .merchantName(merchant.getMerchantName())
                .aliasName(merchant.getAliasName())
                .email(merchant.getEmail())
                .status(merchant.getStatus())
                .createdAt(merchant.getCreatedAt())
                .build();
    }

    @Override
    public List<MerchantDetailResponse> getAllMerchant(int pageNo, int pageSize) {
        // ???
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<MerchantEntity> merchants = merchantRepository.findAll(pageable);

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

    // other methods to handle business
    private MerchantEntity getMerchantId(long merchantId){
        return merchantRepository.findById(merchantId).orElseThrow(() -> new ResourceNotFoundException("Merchant not found"));
    }
}
