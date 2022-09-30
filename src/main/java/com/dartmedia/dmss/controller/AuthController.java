package com.dartmedia.dmss.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.Account;
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
      Auth account = service.login(user.getAccountId(), user.getPassword());
      if (account != null) {
        String auth = service.isExist(user.getAccountId());
        if (auth.equals("true"))
          account.setRole("ADMIN");
        else
          account.setRole("USER");
        rs = responseService.getSingleResult(account);
      } else
        rs = responseService.getSingleFailType(CommonResponse.NODATA);
    } catch (Exception e) {
      e.printStackTrace();
      rs = responseService.getSingleFailType(CommonResponse.ERR);
    }

    return ResponseEntity.ok().body(rs);
  }
  @ApiOperation(value = "게시글 개별 조회", notes = "게시글 개별 조회 ")
  @GetMapping("/findById")
  public ResponseEntity<?> findById(String accountId) {
    MultiResult<Account> result = null;

    try {
      List<Account> list = service.findById(accountId);
      if (list.size() > 0)
        result = responseService.getMultiResult(list);
      else
        result = responseService.getMultiFailType(CommonResponse.NODATA);
    } catch (Exception e) {
      log.error("예외:" + e.getMessage());
      result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);
    }
    return ResponseEntity.ok().body(result);
  }

}
