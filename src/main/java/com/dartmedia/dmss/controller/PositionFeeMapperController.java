package com.dartmedia.dmss.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dartmedia.dmss.common.CommonResult;
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

  @ApiOperation(value = "전체/ 경비 전체 조회", notes = "전체/ 경비 조회")
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

  @ApiOperation(value = "직급/ 경비 전체 조회", notes = "positionCode 입력")
  @GetMapping("/findByPosition")
  public ResponseEntity<?> findByPosition(short positionCode) {
    MultiResult<PositionFeeMapper> result = null;
    try {
      List<PositionFeeMapper> list = service.readByPosition(positionCode);
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

  @ApiOperation(value = "직급별 비용 개별 수정", notes = "feeCode, positionCode, fee 입력")
  @PostMapping("/") // POST HTTP 메서드
  public ResponseEntity<?> update(@Valid @RequestBody PositionFeeMapper data) {

    CommonResult result = null;

    try {
      short feeCode = data.getFeeCode();
      short positionCode = data.getPositionCode();
      if (feeCode > 0 && positionCode > 0) {
        PositionFeeMapper getData = service.readByCode(positionCode, feeCode);

        if (getData != null) {
          service.update(data);

          result = resService.getSuccessResult();
        } else {
          result = resService.getSingleFailType(CommonResponse.NODATA);
        }
      } else {
        result = resService.getSingleFailType(CommonResponse.EMPTY_ID);
      }

    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = resService.getSingleFailType(CommonResponse.ERR);
    }

    return ResponseEntity.ok().body(result);
  }

  @ApiOperation(value = "UserFeeList 개별 등록", notes = "UserFeeList 개별 등록")
  @PutMapping("/") // PUT HTTP 메서드
  public ResponseEntity<?> create(@Valid @RequestBody PositionFeeMapper data) {

    // PUT, POST, DELETE HTTP 메서드는 데이터 응답이 아닌 결과만 알려주면 되므로 CommonResult로 리턴
    CommonResult result = null;

    try {
      if (data.getFeeCode() != 0 && data.getPositionCode() != 0) {
        PositionFeeMapper item = service.readByCode(data.getPositionCode(), data.getFeeCode());

        if (item != null) {

          result = resService.getSingleFailType(CommonResponse.EXIST);
        } else {

          service.create(data);
          result = resService.getSingleResult(data);
        }

      }

    } catch (Exception e) {
      e.printStackTrace();
      result = resService.getSuccessResult();
    }
    return ResponseEntity.ok().body(result);
  }
}
