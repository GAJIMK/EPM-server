package com.dartmedia.dmss.controller;

import java.util.List;

import javax.validation.Valid;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.SubmitDay;
import com.dartmedia.dmss.mapper.SubmitDayMapper;
import com.dartmedia.dmss.service.SubmitDayService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@Api(tags = { "13. SubmitDay" }) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/submitDay") // 최상단 API 경로 설정
public class SubmitDayController {
  private final ResponseService resService;
  private final SubmitDayService service;

  @ApiOperation(value = "SubmitDay 등록", notes = "SubmitDay 등록")
  @PutMapping("/") // PUT HTTP 메서드
  public ResponseEntity<SubmitDay> create(@Valid @RequestBody SubmitDay SubmitDay) {

    // PUT, POST, DELETE HTTP 메서드는 데이터 응답이 아닌 결과만 알려주면 되므로 CommonResult로 리턴
    CommonResult result = null;

    try {
      service.create(SubmitDay);
    } catch (Exception e) {
      e.printStackTrace();
    }
    result = resService.getSuccessResult();
    return new ResponseEntity<>( SubmitDay, HttpStatus.OK);
  }


  @ApiOperation(value = "전체 조회", notes = "전체 조회")
  @GetMapping("/findAll")
  public ResponseEntity<?> findAll() {

    MultiResult<SubmitDayMapper> result = null;

    try {

      List<SubmitDayMapper> findSubmitDay = service.findAll();

      if (service.findAll() != null) {

        if (findSubmitDay.size() > 0)
          result = resService.getMultiResult(findSubmitDay);
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
