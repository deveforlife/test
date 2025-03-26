package com.sat.backend_fasep.repository;

import com.sat.backend_fasep.model.MerchantEntity;
import com.sat.backend_fasep.model.WithdrawBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, Long> {
}
