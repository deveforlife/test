package com.sat.backend_fasep.controller;

import com.sat.backend_fasep.dto.request.MerchantRequestDTO;
import com.sat.backend_fasep.dto.response.ResponseData;
import com.sat.backend_fasep.dto.response.ResponseError;
import com.sat.backend_fasep.service.IMerchantService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/merchant")
@Validated
@Slf4j
@RequiredArgsConstructor // initialize constructor at compile time
public class MerchantController {

//    @Autowired
//    private IMerchantService merchantService;

    private final IMerchantService merchantService;

    /**
     * add, create merchant
     */

    @PostMapping(value = "/") // headers = "apiKey=v1.0") for mobile
    public ResponseData<Integer> addMerchant(@Valid @RequestBody MerchantRequestDTO merchantDTO){
        log.info("Request create merchant = { " + merchantDTO.getMerchantName()+ " }");
        try {
            merchantService.addMerchant(merchantDTO);
            return new ResponseData<>(HttpStatus.CREATED.value(), "Merchant added successfully", 1);
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Save merchant fail");
        }
    }

    /**
     * 2
     */

    @PutMapping("/{id}")
    public ResponseData<?> updateMerchantAll(@PathVariable @Min(value = 1, message = "userId must be greater than 0") int id,
                                             @Valid @RequestBody MerchantRequestDTO merchantDTO){
        log.info("Request update merchant ID = {}" + id);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "Merchant updated successfully");
    }

    /**
     * 3
     * ? method patch có cần chỉ định rõ field cần cập nhật hay không
     *
     */
    @PatchMapping("/{id}")
    public ResponseData<?> updateMerchantStatus(@PathVariable @Min(value = 1, message = "userId must be greater than 0") int id , @RequestParam int status){
        log.info("Request update merchant status, merchant ID = {}" + id);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "Merchant status changed ");
    }

    /**
     * 4
     *
     */
    @DeleteMapping("/{id}")
    public ResponseData<?> deleteMerchant(@PathVariable @Min(value = 1, message = "userId must be greater than 0") int id){
        log.info("Request delete merchant, merchant ID = {}" + id);
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Merchant deleted ");
    }

    /**
     * 5
     *
     */
    @GetMapping("/{id}")
    public ResponseData<MerchantRequestDTO> getMerchant(@PathVariable @Min(value = 1, message = "userId must be greater than 0") int id){
        log.info("Request get detail merchant by ID = {}" + id);
        return new ResponseData<>(HttpStatus.OK.value(), "Merchant",
                new MerchantRequestDTO("username1",
                        "password1",
                        "merchantName1",
                        "email1"));
    }

    /**
     * 6
     *
     */
    @GetMapping("/list")
    public ResponseData<List<MerchantRequestDTO>> getAllMerchant(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize){
        log.info("Request get all merchant");
        return new ResponseData<>(HttpStatus.OK.value(), "Merchant list",
                List.of(
                        new MerchantRequestDTO("username1","password1", "merchantName1", "email1"),
                new MerchantRequestDTO("username2","password2", "merchantName2", "email2")));
    }


}
