package com.sat.backend_fasep.service.impl;

import com.sat.backend_fasep.common.GeneratePasswordWithRegex;
import com.sat.backend_fasep.common.enumpackage.OrderStatus;
import com.sat.backend_fasep.controller.dto.request.MerchantRequestDTO;
import com.sat.backend_fasep.controller.dto.request.OrderRequestDTO;
import com.sat.backend_fasep.controller.dto.response.OrderDetailsResponse;
import com.sat.backend_fasep.exception.ResourceNotFoundException;
import com.sat.backend_fasep.model.MerchantEntity;
import com.sat.backend_fasep.model.OrderEntity;
import com.sat.backend_fasep.repository.MerchantRepository;
import com.sat.backend_fasep.repository.OrderRepository;
import com.sat.backend_fasep.service.IOrderService;
import lombok.RequiredArgsConstructor;
import lombok.With;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService{
    private final OrderRepository orderRepository;

    @Override
    public String saveOrder(OrderRequestDTO orderRequestDTO) {
        OrderEntity order = OrderEntity.builder()
                .orderId(orderRequestDTO.getOrderId())
                .merchantId(orderRequestDTO.getMerchantId()) // Check for duplicates in code and set unique values in Database
                .merchantKey(orderRequestDTO.getMerchantKey()) //Check for duplicates in code and set unique values in Database
                .transactionId(orderRequestDTO.getTransactionId())
                .moneyRequest(orderRequestDTO.getMoneyRequest())
                .contentRequest(orderRequestDTO.getContentRequest())
                .customerIp(orderRequestDTO.getCustomerIp()) // Check for duplicates in code and set unique values in Database
                .callbackUrl(orderRequestDTO.getCallbackUrl())
                .type(orderRequestDTO.getType()) // Check for duplicates in code and set unique values in Database
                .signature(orderRequestDTO.getSignature())
                .order_status("Pending")
                .build();

        orderRepository.save(order);
        log.info("Order saved");

        return order.getOrderId();
    }

}
