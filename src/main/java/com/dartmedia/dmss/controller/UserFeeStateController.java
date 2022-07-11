package com.dartmedia.dmss.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.UserFeeState;
import com.dartmedia.dmss.service.UserFeeStateService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그기능 활성화
@Api(tags = { "32. UserFeeState" }) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/userFeeState") // 최상단 API 경로 설정
public class UserFeeStateController {
  private final ResponseService resService;
  private final UserFeeStateService service;

  @ApiOperation(value = "Account 개별 등록", notes = "Account 개별 등록")
  @PutMapping("/") // PUT HTTP 메서드
  public ResponseEntity<?> create(@Valid @RequestBody UserFeeState userFeeState) {

    // PUT, POST, DELETE HTTP 메서드는 데이터 응답이 아닌 결과만 알려주면 되므로 CommonResult로 리턴
    CommonResult result = null;

    try {

      // 계정이 비어있는지 확인
      if (userFeeState.getAccountId() != null && userFeeState.getDate() != null) {
        // 추가하는 계정이 존재하는지 확인하기 위해 조회
        UserFeeState readState = service.readByDate(userFeeState.getAccountId(), userFeeState.getDate());

        if (readState != null) {
          // 계정이 존재하는 경우
          result = resService.getSingleFailType(CommonResponse.EXIST); // 기존에 등록된 정보가 있음으로 응답
        } else {
          service.create(userFeeState);

          result = resService.getSuccessResult();
        }
      } else {
        // 계정이 비어있는경우
        result = resService.getSingleFailType(CommonResponse.EMPTY_ID); // 빈계정 알림
      }

    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = resService.getSingleFailType(CommonResponse.ERR);
    }

    return ResponseEntity.ok().body(result);
  }

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

  @ApiOperation(value = "달별 경비 승인상태 조회", notes = "yyyy-mm")
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

  @ApiOperation(value = "state를 반려 상태로 변경", notes = "state를 반려 상태로 변경")
  @PostMapping("/reject/{accountId}/date/{date}") // PATCH HTTP 메서드
  public ResponseEntity<?> updateReject(
      @ApiParam(value = "사용자 id와 date", required = true) @PathVariable("accountId") String accountId,
      @PathVariable("date") Date date) {

    CommonResult result = null;

    try {
      UserFeeState list = service.readByDate(accountId, date);
      if (list != null) {
        service.rejectState(accountId, date);
        result = resService.getSingleResult(CommonResponse.SUCCESS);
      } else {
        result = resService.getSingleFailType(CommonResponse.EMPTY_ID);
      }

    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = resService.getSingleFailType(CommonResponse.ERR);
    }

    return ResponseEntity.ok().body(result);
  }

  @ApiOperation(value = "state를 승인 상태로 변경", notes = "state를 승인 상태로 변경")
  @PostMapping("/approve/{accountId}/date/{date}") // PATCH HTTP 메서드
  public ResponseEntity<?> updateApprove(
      @ApiParam(value = "사용자 id와 date", required = true) @PathVariable("accountId") String accountId,
      @PathVariable("date") Date date) {

    CommonResult result = null;

    try {
      UserFeeState list = service.readByDate(accountId, date);
      if (list != null) {
        service.approveState(accountId, date);
        result = resService.getSingleResult(CommonResponse.SUCCESS);
      } else {
        result = resService.getSingleFailType(CommonResponse.EMPTY_ID);
      }

    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = resService.getSingleFailType(CommonResponse.ERR);
    }

    return ResponseEntity.ok().body(result);
  }
}
