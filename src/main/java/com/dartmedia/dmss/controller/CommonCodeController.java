package com.dartmedia.dmss.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.CommonCode;
import com.dartmedia.dmss.service.CommonCodeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그기능 활성화
@Api(tags = { "92. CommonCode" }) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/common") // 최상단 API 경로 설정
public class CommonCodeController {
  private final ResponseService resService;
  private final CommonCodeService service;

  @ApiOperation(value = "직급 조회", notes = "직급 조회")
  @GetMapping("/position")
  public ResponseEntity<?> findPosition() {

    MultiResult<CommonCode> result = null;

    try {

      List<CommonCode> data = service.findPosition();

      if (service.findPosition() != null) {

        if (data.size() > 0)
          result = resService.getMultiResult(data);
        else
          result = resService.getMultiFailType(CommonResponse.NODATA);
      }
    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = resService.getMultiFailType(ResponseService.CommonResponse.ERR);
    }

    return ResponseEntity.ok().body(result);
  }

}