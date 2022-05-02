package com.dartmedia.dmss.controller;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.dto.TAccount;
import com.dartmedia.dmss.dto.TAppoint;
import com.dartmedia.dmss.service.MailService;
import com.dartmedia.dmss.service.TAccountService;
import com.dartmedia.dmss.service.TAppointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Slf4j  // 로그기능 활성화
@Api(tags = {"3. tAppoint"}) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/tappoint") // 최상단 API 경로 설정
public class TAppointController {

    private final ResponseService responseService;
    private final TAppointService tAppointService;
    private final TAccountService tAccountService;
    private final MailService mailService;

    @ApiOperation(value = "tAppoint 리스트 전체 조회", notes = "tAppoint 리스트 전체 조회")   // SWAGGER 문서 설정
    @GetMapping("/findAll") // GET HTTP 메서드, API 경로 설정
    public ResponseEntity<?> findAll() {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<TAppoint> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<TAppoint> findAppoint = tAppointService.findAll();

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findAppoint.size()>0)
                result = responseService.getMultiResult(findAppoint);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(ResponseService.CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "tAppoint 리스트 idNo 조회", notes = "tAppoint 리스트 idNo 조회")   // SWAGGER 문서 설정
    @GetMapping("/findAll/{idNo}") // GET HTTP 메서드, API 경로 설정
    public ResponseEntity<?> findById(@PathVariable("idNo") String idNo) {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<TAppoint> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<TAppoint> findAppoint = tAppointService.findById(idNo);

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findAppoint.size()>0)
                result = responseService.getMultiResult(findAppoint);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(ResponseService.CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "tAppoint 리스트 publishDay 조회", notes = "tAppoint 리스트 publishDay 조회")   // SWAGGER 문서 설정
    @GetMapping("/findByDate/{publishDay}") // GET HTTP 메서드, API 경로 설정
    public ResponseEntity<?> findByPublishDay(@PathVariable("publishDay") Date date) {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<TAppoint> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<TAppoint> findAppoint = tAppointService.findByPublishDay(date);

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findAppoint.size()>0)
                result = responseService.getMultiResult(findAppoint);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(ResponseService.CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "tAppoint 리스트 teamNo 조회", notes = "tAppoint 리스트 teamNo 조회")   // SWAGGER 문서 설정
    @GetMapping("/findByTeam/{teamNo}") // GET HTTP 메서드, API 경로 설정
    public ResponseEntity<?> findByTeamNo(@PathVariable("teamNo") short TeamNo) {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<TAppoint> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<TAppoint> findAppoint = tAppointService.findByTeamNo(TeamNo);

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findAppoint.size()>0)
                result = responseService.getMultiResult(findAppoint);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(ResponseService.CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "tAppoint 리스트 tpPosition 조회", notes = "tAppoint 리스트 tpPosition 조회")   // SWAGGER 문서 설정
    @GetMapping("/findByPosition/{tpPosition}") // GET HTTP 메서드, API 경로 설정
    public ResponseEntity<?> findByTpPosition(@PathVariable("tpPosition") short tpPosition) {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<TAppoint> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<TAppoint> findAppoint = tAppointService.findByTpPosition(tpPosition);

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findAppoint.size()>0)
                result = responseService.getMultiResult(findAppoint);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(ResponseService.CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "tAppoint 리스트 authority 조회", notes = "tAppoint 리스트 authority 조회")   // SWAGGER 문서 설정
    @GetMapping("/findAll/authority") // GET HTTP 메서드, API 경로 설정
    public ResponseEntity<?> findByAuthority() {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<TAppoint> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<TAppoint> findAppoint = tAppointService.findByAuthority();

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findAppoint.size()>0)
                result = responseService.getMultiResult(findAppoint);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(ResponseService.CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "tAppoint 개별 등록", notes = "tAppoint 개별 등록")
    @PutMapping("/")    // PUT HTTP 메서드
    public ResponseEntity<?> create(@Valid @RequestBody TAppoint tAppoint) {

        // PUT, POST, DELETE HTTP 메서드는 데이터 응답이 아닌 결과만 알려주면 되므로 CommonResult로 리턴
        CommonResult result = null;
        try {
            tAppoint.setPublishDay(java.sql.Date.valueOf(LocalDate.now()));
            tAppointService.create(tAppoint);

            result = responseService.getSuccessResult();

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(ResponseService.CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result); 
    }
    @ApiOperation(value = "tAppoint 단체 등록", notes = "tAppoint 단체 등록")
    @PutMapping("/list")    // PUT HTTP 메서드
    public ResponseEntity<?> createByList(@Valid @RequestBody List<TAppoint> tAppointList) {

        final String APPOINT_CODE = "100";

        // PUT, POST, DELETE HTTP 메서드는 데이터 응답이 아닌 결과만 알려주면 되므로 CommonResult로 리턴
        CommonResult result = null;
        try {
            for (int i = 0; i< tAppointList.size(); i++) {
                TAppoint tAppoint = tAppointList.get(i);
                tAppoint.setPublishDay(java.sql.Date.valueOf(LocalDate.now()));

                // tAccount Update
                TAccount tAccount = tAccountService.read(tAppoint.getIDNo());
                tAccount.setTpAccount(tAppoint.getTpAccount());
                tAccount.setTeamNo(tAppoint.getTeamNo());
                tAccount.setTpPublish(tAppoint.getTpPublish());
                tAccount.setTpPosition(tAppoint.getTpPosition());

                tAccountService.update(tAccount);
                tAppointService.create(tAppoint);

                mailService.sendAppointMail(APPOINT_CODE);
                // 인턴에서 정규직 전환시 명함담당자에게 알람
                if (tAppoint.isIntern() == true) {
                    final String FUNC_ID = "30";
                    mailService.sendAppointMail(FUNC_ID);
                }
            }
            result = responseService.getSuccessResult();

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(ResponseService.CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }

}
