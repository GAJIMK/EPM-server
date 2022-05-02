package com.dartmedia.dmss.controller;

import java.util.List;

import javax.validation.Valid;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.Request;
import com.dartmedia.dmss.dto.RequestConfirm;
import com.dartmedia.dmss.service.RequestConfirmService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = { "6. RequestConfirm" })
@RequiredArgsConstructor
@RestController
@RequestMapping("/requestConfirm")
public class RequestConfirmController {
  private final ResponseService responseService;
  private final RequestConfirmService requestConfirmService;

  @ApiOperation(value = "RequestConfirm 개별 등록", notes = "RequestConfirm 개별 등록")
  @PutMapping("/")
  public ResponseEntity<?> create(@Valid @RequestBody RequestConfirm requestConfirm) {

    CommonResult result = null;

    try {

      // 요청ID가 비어있는지 확인
      if (requestConfirm.getRequestId() != 0) {
        requestConfirmService.create(requestConfirm);

        result = responseService.getSuccessResult();
      } else {

        result = responseService.getSingleFailType(CommonResponse.EMPTY_ID);
      }

    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = responseService.getSingleFailType(CommonResponse.ERR);
    }

    return ResponseEntity.ok().body(result);
  }

  @ApiOperation(value = "RequestConfirm 개별 수정", notes = "RequestConfirm 개별 수정")
  @PostMapping("/") // POST HTTP 메서드
  public ResponseEntity<?> update(@Valid @RequestBody RequestConfirm requestConfirm) {

    CommonResult result = null;

    try {

      if (requestConfirm.getReceiverId() != null) {
        RequestConfirm readConfirm = requestConfirmService.readRequestConfirm(requestConfirm.getReceiverId(),
            requestConfirm.getRequestId());

        if (readConfirm != null) {
          requestConfirmService.update(requestConfirm);

          result = responseService.getSuccessResult();
        } else {
          result = responseService.getSingleFailType(CommonResponse.NODATA);
        }
      } else {
        result = responseService.getSingleFailType(CommonResponse.EMPTY_ID);
      }

    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = responseService.getSingleFailType(CommonResponse.ERR);
    }

    return ResponseEntity.ok().body(result);
  }

  @ApiOperation(value = "requestConfirm 의 requestId", notes = "사용자의 처리안된 요청서 코드")
  @GetMapping("/findAll/{idNo}")
  public ResponseEntity<?> findRequestConfirmByIdNo(@PathVariable("idNo") String idNo) {

    MultiResult<RequestConfirm> result = null;
    try{
      List<RequestConfirm> findConfirm = requestConfirmService.findRequestConfirmByIdNo(idNo);
      result = responseService.getMultiResult(findConfirm);
    } catch(Exception e){
      log.error("처리 중 예외:", e.getMessage());
      result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);
    }
  
    return ResponseEntity.ok().body(result);

  }

}
