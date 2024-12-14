package com.sat.backend_fasep.controller.dto.response;

import com.sat.backend_fasep.model.Channel;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ChannelDetailResponse {

    private Long merchantId;

    private List<Channel> listChannel;

}
