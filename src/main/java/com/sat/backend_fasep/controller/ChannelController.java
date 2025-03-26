package com.sat.backend_fasep.controller;

import com.sat.backend_fasep.controller.dto.request.ChannelRequestDTO;
import com.sat.backend_fasep.controller.dto.request.WithdrawBankRequestDTO;
import com.sat.backend_fasep.controller.dto.response.ResponseData;
import com.sat.backend_fasep.controller.dto.response.ResponseError;
import com.sat.backend_fasep.service.IChannelService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channel")
@Validated
@Slf4j
@RequiredArgsConstructor
public class ChannelController {

    private final IChannelService channelService;

    /*
     * add channel to merchant
     *
     */
    @Operation(method = "POST", summary = "Add rate for channel off merchant", description = "Service fee when using payment channel")
    @PostMapping("/{merchantId}")
    public ResponseData<Long> addChannel(@PathVariable @Min(value = 1, message = "merchantId must be greater than 0") long merchantId,
                                              @Valid @RequestBody ChannelRequestDTO request){
        log.info("Request additional payment channels for merchant, merchantId={}", merchantId);

        try {
            long channelId = channelService.saveChannel(merchantId, request);
            return new ResponseData<>(HttpStatus.CREATED.value(), "channel.add.success", channelId);
        } catch (Exception e) {
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Add channel fail");
        }
    }

    /*
     * Edit rate channel
     *
     */
    @Operation(method = "PATCH", summary = "Edit rate of channel", description = "Change payment channel service fees")
    @PatchMapping("/update-rate")
    public ResponseData<?> updateWithdrawBank(@RequestParam @Min(value = 1, message = "merchantId must be greater than 0") long merchantId,
                                              @RequestParam @Min(value = 1, message = "channelId must be greater than 0") long channelId,
                                              @Valid @RequestParam float newRate){

        log.info("Request to change payment channel service fee={}",channelId, " merchant id={}", merchantId);

        try {
            channelService.updateChannel(merchantId, channelId, newRate);
            return new ResponseData<>(HttpStatus.CREATED.value(), "channel-rate.update.success");
        } catch (Exception e) {
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Update channel fail");
        }

    }

    /**
     * get merchant bank
     *
     */
    @DeleteMapping("/{channelId}")
    public ResponseData<?> deleteWithdrawBank(@RequestParam @Min(value = 1, message = "merchantId must be greater than 0") long merchantId,
                                              @PathVariable @Min(value = 1, message = "withdrawBankId must be greater than 0") long channelId){
        log.info("Request delete channel id = {}", channelId, " of merchant by ID = {}" + merchantId);
        channelService.deleteChannel(merchantId, channelId);
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Channel has been deleted successfully");
    }

    /**
     * get merchant bank
     *
     */
    @GetMapping("/{merchantId}")
    public ResponseData<?> getWithdrawBankOfMerchantId(@PathVariable @Min(value = 1, message = "merchantId must be greater than 0") long merchantId,
                                           @RequestParam(defaultValue = "0") int pageNo,
                                           @RequestParam(defaultValue = "10") int pageSize){
        log.info("Request get all channel of merchant ID = {}", merchantId);

        try {
            return new ResponseData<>(HttpStatus.OK.value(),"Channel list", channelService.getChannelOfMerchantId(merchantId, pageNo, pageSize));
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
