package com.sat.backend_fasep.model;

import com.sat.backend_fasep.common.enumpackage.UserStatus;
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
@Entity
@Table(name = "merchant")
public class MerchantEntity extends BaseEntity {

    @Column(name = "alias_name")
    private String aliasName;

    // only show for Administrator
    @Column(name = "merchant_name")
    private String merchantName;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "status")
    private UserStatus status;

    // API integration information
    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "secret_key")
    private String secretKey;

    @Column(name = "ip_address")
    private String ipAddress;

    //
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "merchantId")
//    private Set<WithdrawBank> withdrawBank = new HashSet<>();
}

