package com.sat.backend_fasep.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "channel")
public class Channel extends BaseEntity {

    @Column(name = "channel_name")
    private String channelName;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "merchant_id")
    private Long merchantId;

}
