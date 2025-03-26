package com.sat.backend_fasep.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Columns;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "withdraw_bank")
public class WithdrawBank extends BaseEntity {

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "holder_account")
    private String holderAccount;

    @Column(name = "number_account")
    private String numberAccount;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "merchant_id")
//    private MerchantEntity merchantId;
    @Column(name = "merchant_id")
    private Long merchantId;

}
