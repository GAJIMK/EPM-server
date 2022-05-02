package com.dartmedia.dmss.controller;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.common.SingleResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.Mail;
import com.dartmedia.dmss.dto.TAccount;
import com.dartmedia.dmss.service.MailService;
import com.dartmedia.dmss.service.TAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * 컨트롤러 설정
 * API 호출시 사용되는 최상단 접근부분
 * 실제로 필터, 인터셉터가 더 있으나 현재는 교육중으로 무시
 */
@Slf4j  // 로그기능 활성화
@Api(tags = {"1. tAccount"}) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/taccount") // 최상단 API 경로 설정
public class TAccountController {

    private final ResponseService responseService;
    private final TAccountService accountService;
    private final MailService mailService;

    @ApiOperation(value = "tAccount 리스트 전체 조회", notes = "tAccount 리스트 전체 조회")   // SWAGGER 문서 설정
    @GetMapping("/findAll") // GET HTTP 메서드, API 경로 설정
    public ResponseEntity<?> findAll() {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<TAccount> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<TAccount> findAccount = accountService.findAll();

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findAccount.size()>0)
                result = responseService.getMultiResult(findAccount);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            TAccountController.log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "tAccount 리스트 전체 조회", notes = "tAccount 리스트 전체 조회")   // SWAGGER 문서 설정
    @GetMapping("/findAll/{idNo}") // GET HTTP 메서드, API 경로 설정
    public ResponseEntity<?> findAccountsByIdNo(@PathVariable("idNo") String idNo) {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<TAccount> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<TAccount> findAccount = accountService.findAccountsByIdNo(idNo);

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findAccount.size()>0)
                result = responseService.getMultiResult(findAccount);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            TAccountController.log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "tAccount 리스트 검색 조회", notes = "tAccount 리스트 검색 조회")   // SWAGGER 문서 설정
    @GetMapping("/{accountInfo}") // GET HTTP 메서드, API 경로 설정
    public ResponseEntity<?> findAccountByIdNoAndAccountNm(@PathVariable String accountInfo) {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<TAccount> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<TAccount> findAccount = accountService.findAccountByIdNoAndAccountNm(accountInfo);

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findAccount.size()>0)
                result = responseService.getMultiResult(findAccount);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            TAccountController.log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }
    @ApiOperation(value = "tAccount 리스트 검색 조회", notes = "tAccount 리스트 검색 조회")   // SWAGGER 문서 설정
    @GetMapping("/findAccount/{accountInfo}") // GET HTTP 메서드, API 경로 설정
    public ResponseEntity<?> findAccountByIdNoAndAccountNmWithAppoint(@PathVariable String accountInfo) {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<TAccount> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<TAccount> findAccount = accountService.findAccountByIdNoAndAccountNmWithAppoint(accountInfo);

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findAccount.size()>0)
                result = responseService.getMultiResult(findAccount);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            TAccountController.log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }



    @ApiOperation(value = "tAccount 리스트 전체 조회", notes = "tAccount 리스트 전체 조회")   // SWAGGER 문서 설정
    @GetMapping("/findEmail/{email}") // GET HTTP 메서드, API 경로 설정
    public ResponseEntity<?> findAccountByEmail(@PathVariable("email") String email) {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        SingleResult<TAccount> result = null;

        try {
            // 서비스를 통해 전체 조회
            TAccount findAccount = accountService.findAccountByEmail(email);

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findAccount != null)
                result = responseService.getSingleResult(findAccount);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getSingleFailType(CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            TAccountController.log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "tAccount 개별 등록", notes = "tAccount 개별 등록")
    @PutMapping("/")    // PUT HTTP 메서드
    public ResponseEntity<?> create(@Valid @RequestBody TAccount taccount) {

        // PUT, POST, DELETE HTTP 메서드는 데이터 응답이 아닌 결과만 알려주면 되므로 CommonResult로 리턴
        CommonResult result = null;
        try {

            // 계정이 비어있는지 확인
            if(taccount.getIDNo()!=null)
            {
                // 추가하는 계정이 존재하는지 확인하기 위해 조회
                TAccount readTAccount = accountService.read(taccount.getIDNo());

                if(readTAccount!=null)
                {
                    // 계정이 존재하는 경우
                    result = responseService.getSingleFailType(CommonResponse.EXIST);   // 기존에 등록된 정보가 있음으로 응답
                }
                else
                {
                    accountService.create(taccount);
                    mailService.sendAddAccountMail();
                    result = responseService.getSuccessResult();                    
                }
            }
            else
            {
                // 계정이 비어있는경우
                result = responseService.getSingleFailType(CommonResponse.EMPTY_ID);    // 빈계정 알림
            }

        } catch (Exception e) {
            TAccountController.log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }
    

    @ApiOperation(value = "Account 개별 수정", notes = "Account 개별 수정")
    @PostMapping("/")   // POST HTTP 메서드
    public ResponseEntity<?> update(@Valid @RequestBody TAccount taccount) { 
        CommonResult result = null;
        try {
            if(taccount.getIDNo()!=null)
            {
                TAccount readAccount = accountService.read(taccount.getIDNo());
                if(readAccount!=null)
                {
                    accountService.update(taccount);
                    result = responseService.getSuccessResult();
                }else
                {
                    result = responseService.getSingleFailType(CommonResponse.NODATA);
                }
            }
            else
            {
                result = responseService.getSingleFailType(CommonResponse.EMPTY_ID);
            }
        } catch (Exception e) {
            TAccountController.log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(CommonResponse.ERR);
        }
        return ResponseEntity.ok().body(result); 
    }

    @ApiOperation(value = "AccountNm 개별 수정", notes = "AccountNm 개별 수정")
    @PostMapping("/accountNm")   // POST HTTP 메서드
    public ResponseEntity<?> updateAccountNm(@RequestBody TAccount taccount) { 
        CommonResult result = null;
        try {
            if(taccount.getIDNo()!=null)
            {
                TAccount readAccount = accountService.read(taccount.getIDNo());
                if(readAccount!=null)
                {
                    accountService.updateAccountNm(taccount);
                    result = responseService.getSuccessResult();
                }else
                {
                    result = responseService.getSingleFailType(CommonResponse.NODATA);
                }
            }
            else
            {
                result = responseService.getSingleFailType(CommonResponse.EMPTY_ID);
            }
        } catch (Exception e) {
            TAccountController.log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(CommonResponse.ERR);
        }
        return ResponseEntity.ok().body(result); 
    }

    @ApiOperation(value = "AccountId 개별 수정", notes = "AccountId 개별 수정")
    @PostMapping("/accountId")   // POST HTTP 메서드
    public ResponseEntity<?> updateAccountId(@RequestBody TAccount taccount) { 
        CommonResult result = null;
        try {
            if(taccount.getIDNo()!=null)
            {
                TAccount readAccount = accountService.read(taccount.getIDNo());
                if(readAccount!=null)
                {
                    accountService.updateAccountId(taccount);
                    result = responseService.getSuccessResult();
                }else
                {
                    result = responseService.getSingleFailType(CommonResponse.NODATA);
                }
            }
            else
            {
                result = responseService.getSingleFailType(CommonResponse.EMPTY_ID);
            }
        } catch (Exception e) {
            TAccountController.log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(CommonResponse.ERR);
        }
        return ResponseEntity.ok().body(result); 
    }

    @ApiOperation(value = "AccountId 개별 수정", notes = "AccountId 개별 수정")
    @PostMapping("/email")   // POST HTTP 메서드
    public ResponseEntity<?> updateEmail(@RequestBody TAccount taccount) { 
        CommonResult result = null;
        try {
            if(taccount.getIDNo()!=null)
            {
                TAccount readAccount = accountService.read(taccount.getIDNo());
                if(readAccount!=null)
                {
                    accountService.updateEmail(taccount);
                    result = responseService.getSuccessResult();
                }else
                {
                    result = responseService.getSingleFailType(CommonResponse.NODATA);
                }
            }
            else
            {
                result = responseService.getSingleFailType(CommonResponse.EMPTY_ID);
            }
        } catch (Exception e) {
            TAccountController.log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(CommonResponse.ERR);
        }
        return ResponseEntity.ok().body(result); 
    }

    @ApiOperation(value = "AccountPassword 개별 수정", notes = "AccountPassword 개별 수정")
    @PostMapping("/password")   // POST HTTP 메서드
    public ResponseEntity<?> updatePassword(@RequestBody TAccount taccount) { 
        CommonResult result = null;
        try {
            if(taccount.getIDNo()!=null)
            {
                TAccount readAccount = accountService.read(taccount.getIDNo());
                if(readAccount!=null)
                {
                    accountService.updatePassword(taccount);
                    result = responseService.getSuccessResult();
                }else
                {
                    result = responseService.getSingleFailType(CommonResponse.NODATA);
                }
            }
            else
            {
                result = responseService.getSingleFailType(CommonResponse.EMPTY_ID);
            }
        } catch (Exception e) {
            TAccountController.log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(CommonResponse.ERR);
        }
        return ResponseEntity.ok().body(result); 
    }

    @ApiOperation(value = "tAccount 개별 삭제", notes = "tAccount 개별 삭제")
    @DeleteMapping("/{IDNo}")  // DELETE HTTP 메서드
    public ResponseEntity<?> delete(@ApiParam(value = "계정 ID", required = true) @PathVariable("IDNo") String IDNo) {
        CommonResult result = null;
        try {

            // 계정이 존재하는지 확인
            TAccount taccount = accountService.read(IDNo);

            if(taccount!=null)
            {
                // 계정이 존재하는 경우 삭제
                accountService.delete(IDNo);

                result = responseService.getSingleResult(CommonResponse.SUCCESS);   
            } 
            else
            {
                result = responseService.getSingleFailType(CommonResponse.NODATA);
            }

        }catch (Exception e) {
            TAccountController.log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }

}
