package com.sat.backend_fasep.controller;

import com.sat.backend_fasep.controller.dto.request.MerchantRequestDTO;
import com.sat.backend_fasep.controller.dto.request.OrderRequestDTO;
import com.sat.backend_fasep.controller.dto.response.OrderDetailsResponse;
import com.sat.backend_fasep.controller.dto.response.ResponseData;
import com.sat.backend_fasep.controller.dto.response.ResponseError;
import com.sat.backend_fasep.service.IOrderService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
@Validated
@Slf4j
@RequiredArgsConstructor // initialize constructor at compile time
public class OrderController {

   private final IOrderService orderService;

    /**
     * Create new order
     */

    @Operation(method = "POST", summary = "Create new order", description = "Send a reqest via this API to create new order")
    @PostMapping(value = "/") // headers = "apiKey=v1.0") for mobile
    public ResponseData<String> createOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO){
        log.info("Request create new order, {}", orderRequestDTO.getTransactionId());
        try {
            String orderId = orderService.saveOrder(orderRequestDTO);
            return new ResponseData<>(HttpStatus.CREATED.value(), "order.add.success", orderId);
        } catch (Exception e) {
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Create order fail");
        }
    }

    /**
     *
     */

}
