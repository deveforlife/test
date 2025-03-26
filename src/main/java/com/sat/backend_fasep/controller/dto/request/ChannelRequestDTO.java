package com.sat.backend_fasep.controller.dto.request;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class ChannelRequestDTO implements Serializable {

    private String channelName;
    private String type;
    private String description;
    private Float rate;

    public ChannelRequestDTO(String channelName, String type, String description, Float rate) {
        this.channelName = channelName;
        this.type = type;
        this.description = description;
        this.rate = rate;
    }
}
