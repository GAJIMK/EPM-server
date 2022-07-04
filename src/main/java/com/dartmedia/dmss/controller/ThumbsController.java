package com.dartmedia.dmss.controller;

import java.util.List;

import javax.validation.Valid;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.Thumbs;
import com.dartmedia.dmss.service.ThumbsService;

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
@Api(tags = { "52. Thumbs" }) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/thumbs") // 최상단 API 경로 설정
public class ThumbsController {
  private final ResponseService resService;
  private final ThumbsService service;

  @ApiOperation(value = "Thumbs 등록", notes = "Thumbs 등록")
  @PutMapping("/") // PUT HTTP 메서드
  public ResponseEntity<Thumbs> create(@Valid @RequestBody Thumbs thumbs) {

    // PUT, POST, DELETE HTTP 메서드는 데이터 응답이 아닌 결과만 알려주면 되므로 CommonResult로 리턴
    CommonResult result = null;

    try {
      service.create(thumbs);
    } catch (Exception e) {
      e.printStackTrace();
    }
    result = resService.getSuccessResult();
    return new ResponseEntity<>(thumbs, HttpStatus.OK);
  }

  @ApiOperation(value = "게시글 별 count 수 ", notes = "게시글 별 count 수 ")
  @GetMapping("/countById")
  public ResponseEntity<?> findById(int id) {
    MultiResult<Thumbs> result = null;

    try {
      List<Thumbs> list = service.countById(id);
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

  @ApiOperation(value = "Thumbs 수정", notes = "Thumbs 수정")
  @PostMapping("/") // POST HTTP 메서드
  public ResponseEntity<?> update(@Valid @RequestBody Thumbs thumbs) {

    CommonResult result = null;

    try {

      if (thumbs
          .getId() > 0) {
        Thumbs readAccount = service.readById((short) thumbs
            .getId());

        if (readAccount != null) {
          service.update(thumbs);

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

  @ApiOperation(value = "좋아요 탑5조회", notes = "좋아요 탑5조회")
  @GetMapping("/selectTop5")
  public ResponseEntity<?> selectTop5() {

    MultiResult<Thumbs> result = null;

    try {

      List<Thumbs> findThumbs = service.selectTop5();

      if (service.selectTop5() != null) {

        if (findThumbs.size() > 0)
          result = resService.getMultiResult(findThumbs);
        else
          result = resService.getMultiFailType(CommonResponse.NODATA);

      }

      // JSONArray jsonArray = JSONArray.fromObject(findTeam);

      // JSONObject jsonObj = new JSONObject();

    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = resService.getMultiFailType(ResponseService.CommonResponse.ERR);
    }

    return ResponseEntity.ok().body(result);
  }

}
