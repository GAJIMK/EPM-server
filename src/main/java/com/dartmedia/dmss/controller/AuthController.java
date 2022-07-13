package com.dartmedia.dmss.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.Auth;
import com.dartmedia.dmss.service.AuthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그기능 활성화
@Api(tags = { "00. Auth" }) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/auth") // 최상단 API 경로 설정
public class AuthController {
  private final ResponseService responseService;
  private final AuthService service;

  @ApiOperation(value = "로그인", notes = "로그인")
  @PostMapping("/login")
  public ResponseEntity<?> login(@Valid @RequestBody Auth user) {
    CommonResult rs = null;
    try {
      Auth auth = service.login(user.getAccountId(), user.getPassword());
      if (auth != null) {
        auth.setRole("USER");
        rs = responseService.getSingleResult(auth);
      } else
        rs = responseService.getSingleFailType(CommonResponse.NODATA);
    } catch (Exception e) {
      e.printStackTrace();
      rs = responseService.getSingleFailType(CommonResponse.ERR);
    }

    return ResponseEntity.ok().body(rs);
  }
}
