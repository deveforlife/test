package com.sat.backend_fasep.service;

import com.sat.backend_fasep.controller.dto.request.ChannelRequestDTO;
import com.sat.backend_fasep.controller.dto.request.WithdrawBankRequestDTO;
import com.sat.backend_fasep.controller.dto.response.ChannelDetailResponse;

public interface IChannelService {

    long saveChannel(long merchantId, ChannelRequestDTO request);

    void updateChannel(long merchantId,long channelId, float newRate);

    // void changeStatus(long merchantId, UserStatus status);

    void deleteChannel(long merchantId, long channelId);

    ChannelDetailResponse getChannelOfMerchantId(long merchantId, int pageNo, int pageSize);

    //List<WithdrawBankDetailResponse> getAllWithdrawBank(int pageNo, int pageSize);
}
