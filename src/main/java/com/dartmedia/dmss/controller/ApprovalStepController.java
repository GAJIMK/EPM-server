package com.dartmedia.dmss.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.MutableAttributeSet;
import javax.validation.Valid;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.common.SingleResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.Account;
import com.dartmedia.dmss.dto.ApprovalStep;
import com.dartmedia.dmss.service.AccountService;
import com.dartmedia.dmss.service.ApprovalStepService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@Api(tags = { "70. Approval" }) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/approval") // 최상단 API 경로 설정
public class ApprovalStepController {
  private final ResponseService responseService;
  private final ApprovalStepService service;

  @ApiOperation(value = "Approval 단계 조회")
  @GetMapping("/{teamNo}")
  public ResponseEntity<?> findStep(@PathVariable("teamNo") short teamNo) {
    List<ApprovalStep> list = new ArrayList<ApprovalStep>();
    MultiResult<ApprovalStep> result = null;

    try {
      if (teamNo != 0) {
        ApprovalStep data = service.readByTeamNo(teamNo);
        if (data != null) {
          while (true) {
            short no = teamNo;
            ApprovalStep item = service.readByTeamNo(no);
            if (item.getTeamNo() == 1)
              break;
            teamNo = item.getUpperTeamNo();
            list.add(item);
          }
          result = responseService.getMultiResult(list);
        } else
          result = responseService.getMultiFailType(CommonResponse.NODATA);
      }
    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR); // 예외 발생시 에러로 응답
    }
    return ResponseEntity.ok().body(result);
  }
}
