package com.dartmedia.dmss.controller;

import java.util.List;

import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.AccountPoint;
import com.dartmedia.dmss.service.AccountPointService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = { "12. AccountPoint" })
@RequiredArgsConstructor
@RestController
@RequestMapping("/accountpoint")
public class AccountPointController {
  private final ResponseService responseService;
  private final AccountPointService accountPointService;

  @ApiOperation(value = "사원번호,이름,직책,부서 리스트 전체 조회", notes = "AccountPoint 리스트 전체 조회") // SWAGGER 문서 설정
  @GetMapping("/findAll") // GET HTTP 메서드, API 경로 설정

  public ResponseEntity<?> findAll() {

    // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
    MultiResult<AccountPoint> result = null;

    try {
      // 서비스를 통해 전체 조회
      List<AccountPoint> findAccount = accountPointService.findAll();

      // 조회한 결과값이 1개 이상인 경우 결과출력
      if (findAccount.size() > 0)
        result = responseService.getMultiResult(findAccount);
      else // 없는 경우 NODATA로 응답
        result = responseService.getMultiFailType(CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이
                                                                          // 있음

    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR); // 예외 발생시 에러로 응답
    }

    // 해당 결과값을 API 응답으로 리턴
    return ResponseEntity.ok().body(result);
  }
}
