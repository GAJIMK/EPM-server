package com.dartmedia.dmss.controller;

import java.util.List;

import javax.validation.Valid;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.Board;
import com.dartmedia.dmss.service.BoardService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

@Slf4j // 로그기능 활성화
@Api(tags = { "12. Board" }) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/Board") // 최상단 API 경로 설정
public class BoardController {
  private final ResponseService resService;
  private final BoardService service;

  @ApiOperation(value = "게시글 조회", notes = "게시글조회")
  @GetMapping("/findByAccountId")
  public ResponseEntity<?> findByAccountId(String accountId, String wrote_date) {
    MultiResult<Board> result = null;

    try {
      List<Board> list = service.findByAccountId(accountId, wrote_date);
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

  @ApiOperation(value = "Board 개별 등록", notes = "Board 개별 등록")
  @PutMapping("/") // PUT HTTP 메서드
  public ResponseEntity<?> create(@Valid @RequestBody Board userFeeList) {

    // PUT, POST, DELETE HTTP 메서드는 데이터 응답이 아닌 결과만 알려주면 되므로 CommonResult로 리턴
    CommonResult result = null;

    try {
      service.create(userFeeList);
    } catch (Exception e) {
      e.printStackTrace();
    }
    result = resService.getSuccessResult();
    return ResponseEntity.ok().body(result);
  }

  @ApiOperation(value = "Board 개별 수정", notes = "Board 개별 수정")
  @PostMapping("/") // POST HTTP 메서드
  public ResponseEntity<?> update(@Valid @RequestBody Board Board) {

    CommonResult result = null;

    try {

      if (Board.getAccountId() != null) {
        Board readAccount = service.readById(Board.getId());

        if (readAccount != null) {
          service.update(Board);

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


}
