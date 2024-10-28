package com.sat.backend_fasep.service;

import com.sat.backend_fasep.dto.request.MerchantRequestDTO;

public interface IMerchantService {

    int addMerchant(MerchantRequestDTO merchantRequestDTO);

}
