package com.sat.backend_fasep.controller;

import com.sat.backend_fasep.dto.request.MerchantRequestDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/merchant")
public class MerchantController {

    /**
     * 1
     */

    @PostMapping(value = "/") // headers = "apiKey=v1.0") for mobile
    public String addMerchant(@Valid @RequestBody MerchantRequestDTO merchantDTO){
        return "Merchant added";
    }

    /**
     * 2
     */
    @PutMapping("/{id}")
    public String updateMerchantAll(@PathVariable int id, @RequestBody MerchantRequestDTO merchantDTO){
        System.out.println("Request update merchant ID = " + id);
        return "Merchant updated";
    }

    /**
     * 3
     * ? method patch có cần chỉ định rõ field cần cập nhật hay không
     *
     */
    @PatchMapping("/{id}")
    public String updateMerchantStatus(@PathVariable int id, @RequestParam int status){
        System.out.println("Request update merchant status, merchant ID = " + id);
        return "Merchant status updated";
    }

    /**
     * 4
     *
     */
    @DeleteMapping("/{id}")
    public String deleteMerchant(@PathVariable int id){
        System.out.println("Request delete merchant, merchant ID = " + id);
        return "Merchant deleted";
    }

    /**
     * 5
     *
     */
    @GetMapping("/{id}")
    public MerchantRequestDTO getMerchant(@PathVariable int id){
        System.out.println("Request get detail merchant by ID = " + id);
        return new MerchantRequestDTO("username","password", "merchantName",
                "email", "phoneNumber", "otherContactInfo");
    }

    /**
     * 6
     *
     */
    @GetMapping("/")
    public List<MerchantRequestDTO> getAllMerchant(

            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize){
        System.out.println("Request get all merchant");
        return List.of(new MerchantRequestDTO("username1","password1", "merchantName1", "email1", "phoneNumber1", "otherContactInfo1"),
                new MerchantRequestDTO("username2","password2", "merchantName2", "email2", "phoneNumber2", "otherContactInfo2"));
    }


}
