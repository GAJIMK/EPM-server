package com.dartmedia.dmss.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.PositionFeeMapper;
import com.dartmedia.dmss.service.PositionFeeMapperService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그기능 활성화
@Api(tags = { "41. PositionFeeMapper" }) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/positionFee") // 최상단 API 경로 설정
public class PositionFeeMapperController {
  private final ResponseService resService;
  private final PositionFeeMapperService service;

  @ApiOperation(value = "직급별 경비 조회", notes = "직급별 경비 조회")
  @GetMapping("/findAll")
  public ResponseEntity<?> findAll() {
    MultiResult<PositionFeeMapper> result = null;

    try {
      List<PositionFeeMapper> list = service.findAll();
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
