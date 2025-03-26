package com.sat.backend_fasep.repository;

import com.sat.backend_fasep.model.WithdrawBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// @query -> native SQL & hibanate SQL
//

@Repository
public interface WithdrawBankRepository extends JpaRepository<WithdrawBank, Long> {

    List<WithdrawBank> findByMerchantId(Long id);
}
