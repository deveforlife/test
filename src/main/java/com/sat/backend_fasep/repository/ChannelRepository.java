package com.sat.backend_fasep.repository;

import com.sat.backend_fasep.model.Channel;
import com.sat.backend_fasep.model.WithdrawBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    List<Channel> findByMerchantId(Long id);
}
