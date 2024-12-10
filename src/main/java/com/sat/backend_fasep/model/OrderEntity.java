package com.sat.backend_fasep.model;

import com.sat.backend_fasep.common.enumpackage.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tbl_order")

public class OrderEntity extends BaseEntity {
    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "merchant_id", nullable = false)
    private String merchantId;

    @Column(name = "merchant_key", nullable = false)
    private String merchantKey;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "money_request", nullable = false)
    private Long moneyRequest;

    @Column(name = "content_request", nullable = false)
    private String contentRequest;

    @Column(name = "customer_ip", nullable = false)
    private String customerIp;

    @Column(name = "callback_url", nullable = false)
    private String callbackUrl;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "signature", nullable = false)
    private String signature;

    @Column(name = "status", nullable = false)
    private String order_status;
}
