package com.dartmedia.dmss.controller;

import java.util.List;

import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.UserFeeState;
import com.dartmedia.dmss.service.UserFeeStateService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그기능 활성화
@Api(tags = { "12. UserFeeState" }) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/userFeeList") // 최상단 API 경로 설정
public class UserFeeStateController {
  private final ResponseService resService;
  private final UserFeeStateService service;

  @ApiOperation(value = "사용자별 경비 승인상태 조회", notes = "사용자별 경비 승인상태 조회")
  @GetMapping("/findAllByUser")
  public ResponseEntity<?> findAllByUser(String accountId) {
    MultiResult<UserFeeState> result = null;

    try {
      List<UserFeeState> list = service.findAllByUser(accountId);
      if (list.size() > 0)
        result = resService.getMultiResult(list);
      else
        result = resService.getMultiFailType(CommonResponse.NODATA);
    } catch (Exception e) {
      log.error("예외:" + e.getMessage());
      result = resService.getMultiFailType(ResponseService.CommonResponse.ERR);
    }
    return ResponseEntity.ok().body(result);
  }

  @ApiOperation(value = "달별 경비 승인상태 조회", notes = "달별 경비 승인상태 조회")
  @GetMapping("/findAllByDate")
  public ResponseEntity<?> findAllByDate(String date) {
    MultiResult<UserFeeState> result = null;

    try {
      List<UserFeeState> list = service.findAllByDate(date);
      if (list.size() > 0)
        result = resService.getMultiResult(list);
      else
        result = resService.getMultiFailType(CommonResponse.NODATA);
    } catch (Exception e) {
      log.error("예외:" + e.getMessage());
      result = resService.getMultiFailType(ResponseService.CommonResponse.ERR);
    }
    return ResponseEntity.ok().body(result);
  }
}
