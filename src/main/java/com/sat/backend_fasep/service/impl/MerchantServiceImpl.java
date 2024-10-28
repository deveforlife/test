package com.sat.backend_fasep.service.impl;

import com.sat.backend_fasep.dto.request.MerchantRequestDTO;
import com.sat.backend_fasep.exception.ResourceNotFoundException;
import com.sat.backend_fasep.service.IMerchantService;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements IMerchantService {
    @Override
    public int addMerchant(MerchantRequestDTO merchantRequestDTO) {
        System.out.println("Save merchant to DB");
        if (!merchantRequestDTO.getMerchantName().equals("merchantName")){
            throw new ResourceNotFoundException("Not found "+ merchantRequestDTO.getMerchantName());
        }
        return 0;
    }
}
