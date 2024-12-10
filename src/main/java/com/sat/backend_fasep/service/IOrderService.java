package com.sat.backend_fasep.service;

import com.sat.backend_fasep.common.enumpackage.OrderStatus;
import com.sat.backend_fasep.controller.dto.request.OrderRequestDTO;
import com.sat.backend_fasep.controller.dto.response.OrderDetailsResponse;

import java.util.List;

public interface IOrderService {
    String saveOrder(OrderRequestDTO orderRequestDTO);
}
