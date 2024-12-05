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
    @PostMapping("/{id}")
    public ResponseData<Long> addWithdrawBank(@PathVariable @Min(value = 1, message = "merchantId must be greater than 0") int id,
                                              @Valid @RequestBody WithdrawBankRequestDTO withdrawBankDTO){
        log.info("Request to register a merchant withdrawal account, merchantId={}", id);

        try {
            long withdrawBankId = withdrawBankService.saveWithdrawBank(id, withdrawBankDTO);
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
    public ResponseData<?> updateWithdrawBank(@RequestParam @Min(value = 1, message = "merchantId must be greater than 0") int merchantId,
                                              @RequestParam @Min(value = 1, message = "withdrawBankId must be greater than 0") int withdrawBankId,
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
