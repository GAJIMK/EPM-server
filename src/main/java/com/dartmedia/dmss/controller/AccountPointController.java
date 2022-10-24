package com.dartmedia.dmss.controller;

import java.util.List;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.common.SingleResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.AccountPoint;
import com.dartmedia.dmss.service.AccountPointService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = { "12. AccountPoint" })
@RequiredArgsConstructor
@RestController
@RequestMapping("/appoint")
public class AccountPointController {
  private final ResponseService responseService;
  private final AccountPointService accountPointService;

  @ApiOperation(value = "아이디를 통한 회원 팀번호 출력", notes = "아이디를 통한 회원 팀번호 출력") // SWAGGER 문서 설정
  @GetMapping("/findTeamNo") // GET HTTP 메서드, API 경로 설정
  public ResponseEntity<?> findTeamNo(String accountId) {

    CommonResult result = null;
    try {
      if (accountId != null) {
        AccountPoint no = accountPointService.findTeamNo(accountId);
        result = responseService.getSingleSuccessType(ResponseService.CommonResponse.SUCCESS);
        result = responseService.getSingleResult(no);
      } else
        result = responseService.getSingleFailType(ResponseService.CommonResponse.NO_PARAM);
    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = responseService.getSingleFailType(ResponseService.CommonResponse.ERR);
    }

    // 해당 결과값을 API 응답으로 리턴
    return ResponseEntity.ok().body(result);
  }

  @ApiOperation(value = "아이디를 통한 회원 팀이름 출력", notes = "아이디를 통한 회원 팀이름 출력") // SWAGGER 문서 설정
  @GetMapping("/findTeamNm") // GET HTTP 메서드, API 경로 설정
  public ResponseEntity<?> findTeamNm(String accountId) {

    CommonResult result = null;
    try {
      if (accountId != null) {
        AccountPoint no = accountPointService.findTeamNm(accountId);
        result = responseService.getSingleSuccessType(ResponseService.CommonResponse.SUCCESS);
        result = responseService.getSingleResult(no);
      } else
        result = responseService.getSingleFailType(ResponseService.CommonResponse.NO_PARAM);
    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = responseService.getSingleFailType(ResponseService.CommonResponse.ERR);
    }

    // 해당 결과값을 API 응답으로 리턴
    return ResponseEntity.ok().body(result);
  }
}
