package com.dartmedia.dmss.wrapper;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.common.SingleResult;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("ResponseWrapper")
public class ResponseWrapper {

  // 응답(코드, 메세지)
  public enum ResponseMessage {
    SUCCESS(0, "성공"), ERR(-1, "아오");

    int code;
    String msg;

    ResponseMessage(int code, String msg) {
      this.code = code;
      this.msg = msg;
    }

    public int getCode() {
      return code;
    }

    public String getMsg() {
      return msg;
    }
  }

  String token;

  @Nullable
  // T body;

  // public String getToken() {
  // return token;
  // }

  // public T getBody() {
  // return body;
  // }

  // return 값이 responseEntity인 메소드를 만들어야 함.
  // public ResponseEntity<?> getSingleSuccessResult(SingleResult result) {
  // ResponseEntity response = null;

  // return response;
  // }

  // 실패하는 경우
  public ResponseEntity<CommonResult> getFailResult(ResponseMessage error) {
    CommonResult result = new CommonResult();
    result.setSuccess(false);
    result.setCode(error.getCode());
    result.setMsg(error.getMsg());

    log.error(result.getMsg());
    return ResponseEntity.ok().body(result);

  }

}
