package com.sat.backend_fasep.controller;

import com.sat.backend_fasep.controller.dto.request.WithdrawBankRequestDTO;
import com.sat.backend_fasep.controller.dto.response.ResponseData;
import com.sat.backend_fasep.controller.dto.response.ResponseError;
import com.sat.backend_fasep.service.IWithdrawBankService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(method = "POST", summary = "Add bank account withdraw", description = "Merchant register bank account withdraw money")
    @PostMapping("/{merchantId}")
    public ResponseData<Long> addWithdrawBank(@PathVariable @Min(value = 1, message = "merchantId must be greater than 0") long merchantId,
                                              @Valid @RequestBody WithdrawBankRequestDTO withdrawBankDTO){
        log.info("Request to register a merchant withdrawal account, merchantId={}", merchantId);

        try {
            long withdrawBankId = withdrawBankService.saveWithdrawBank(merchantId, withdrawBankDTO);
            return new ResponseData<>(HttpStatus.CREATED.value(), "withdrawBank.add.success", withdrawBankId);
        } catch (Exception e) {
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Create withdraw bank fail");
        }
    }

    /*
     * Edit withdrawal bank information
     *
     */
    @Operation(method = "PUT", summary = "Edit bank account withdraw", description = "Merchant edit bank account withdraw money")
    @PutMapping("/update")
    public ResponseData<?> updateWithdrawBank(@RequestParam @Min(value = 1, message = "merchantId must be greater than 0") long merchantId,
                                              @RequestParam @Min(value = 1, message = "withdrawBankId must be greater than 0") long withdrawBankId,
                                              @Valid @RequestBody WithdrawBankRequestDTO withdrawBankDTO){

        log.info("Request to edit withdrawal bank account, merchantId={}", merchantId);

        try {
            withdrawBankService.updateWithdrawBank(merchantId, withdrawBankId, withdrawBankDTO);
            return new ResponseData<>(HttpStatus.CREATED.value(), "withdrawBank.update.success");
        } catch (Exception e) {
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Update withdraw bank fail");
        }

    }

    /**
     * get merchant bank
     *
     */
    @DeleteMapping("/{withdrawBankId}")
    public ResponseData<?> deleteWithdrawBank(@RequestParam @Min(value = 1, message = "merchantId must be greater than 0") long merchantId,
                                              @PathVariable @Min(value = 1, message = "withdrawBankId must be greater than 0") long withdrawBankId){
        log.info("Request delete withdraw bank id = {}", withdrawBankId, " of merchant by ID = {}" + merchantId);
        withdrawBankService.deleteWithdrawBank(merchantId,withdrawBankId);
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Withdrawal account has been deleted successfully");
    }

    /**
     * get merchant bank
     *
     */
    @GetMapping("/list/{merchantId}")
    public ResponseData<?> getWithdrawBankOfMerchantId(@PathVariable @Min(value = 1, message = "merchantId must be greater than 0") long merchantId,
                                           @RequestParam(defaultValue = "0") int pageNo,
                                           @RequestParam(defaultValue = "10") int pageSize){
        log.info("Request get all withdraw bank of merchant ID = {}" + merchantId);

        try {
            return new ResponseData<>(HttpStatus.OK.value(),"Withdraw bank list", withdrawBankService.getWithdrawBank(merchantId, pageNo, pageSize));
        }catch (Exception e){
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
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
