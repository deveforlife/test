package com.sat.backend_fasep.controller;

import com.sat.backend_fasep.controller.dto.request.WithdrawBankRequestDTO;
import com.sat.backend_fasep.controller.dto.response.ResponseData;
import com.sat.backend_fasep.service.IWithdrawBankService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/withdraw-bank")
@Validated
@Slf4j
@RequiredArgsConstructor
public class WithdrawBankController {

    private final IWithdrawBankService withdrawBankService;

    /*
     * create withdrawal bank for merchant
     *
     */
    @PostMapping("/{id}")
    public ResponseData<Long> addWithdrawBank(@PathVariable @Min(value = 1, message = "merchantId must be greater than 0") int id,
                                              @Valid @RequestBody WithdrawBankRequestDTO withdrawBankRequestDTO){






        return new ResponseData<>(1,"save bank success");
    }

    /*
     * Edit merchant withdrawal bank information
     *
     */
    @PatchMapping("/{id}")
    public ResponseData<?> updateWithdrawBank(@PathVariable @Min(value = 1, message = "merchantId must be greater than 0") int id,
                                              @Valid @RequestBody WithdrawBankRequestDTO withdrawBankRequestDTO){






        return new ResponseData<>(1,"update bank success");
    }

    /**
     * get merchant bank
     *
     */
    @DeleteMapping("/{id}")
    public ResponseData<?> deleteWithdrawBank(@PathVariable @Min(value = 1, message = "merchantId must be greater than 0") int id){
        log.info("Request get detail merchant by ID = {}" + id);

        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Withdrawal account has been deleted successfully");
    }

    /**
     * get merchant bank
     *
     */
    @GetMapping("/{id}")
    public ResponseData<WithdrawBankRequestDTO> getWithdrawBank(@PathVariable @Min(value = 1, message = "merchantId must be greater than 0") int id){
        log.info("Request get detail merchant by ID = {}" + id);

        return new ResponseData<>(1,"bank", new WithdrawBankRequestDTO("ACB","123","AAA"));
    }

    /*
     * Get list of merchant banks
     *
     */
    @GetMapping("/list")
    public ResponseData<?> getAllWithdrawBank(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize){






        return new ResponseData<>(1,"");
    }

}
