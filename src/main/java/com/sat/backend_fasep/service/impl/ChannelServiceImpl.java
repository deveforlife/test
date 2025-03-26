package com.sat.backend_fasep.service.impl;

import com.sat.backend_fasep.controller.dto.request.ChannelRequestDTO;
import com.sat.backend_fasep.controller.dto.response.ChannelDetailResponse;
import com.sat.backend_fasep.model.Channel;
import com.sat.backend_fasep.repository.ChannelRepository;
import com.sat.backend_fasep.service.IChannelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChannelServiceImpl implements IChannelService {

    private final ChannelRepository channelRepository;
    private final MerchantServiceImpl merchantService;

    @Override
    public long saveChannel(long merchantId, ChannelRequestDTO request) {
        Channel channel = Channel.builder()
                .merchantId(merchantService.getMerchantId(merchantId).getId())
                .channelName(request.getChannelName())
                .description(request.getDescription())
                .rate(request.getRate())
                .type(request.getType())
                .build();

        channelRepository.save(channel);
        log.info("Add channel successfully");

        return channel.getId();
    }

    @Override
    public void updateChannel(long merchantId, long channelId, float newRate) {
        for (Channel channel : channelRepository.findByMerchantId(merchantId)){
            if (channel.getId() == channelId) {
                channel.setRate(newRate);
                channelRepository.save(channel);
            }
        }

        log.info("Update channel successfully");
    }

    @Override
    public void deleteChannel(long merchantId, long channelId) {
        for (Channel channel : channelRepository.findByMerchantId(merchantId)){
            if (channel.getId() == channelId) {
                channelRepository.delete(channel);
            }
        }

        log.info("Delete channel successfully");
    }

    @Override
    public ChannelDetailResponse getChannelOfMerchantId(long merchantId, int pageNo, int pageSize) {
        List<Channel> channelList = channelRepository.findByMerchantId(merchantId);

        return ChannelDetailResponse.builder()
                .merchantId(merchantId)
                .listChannel(channelList.stream().toList())
                .build();
    }
}
