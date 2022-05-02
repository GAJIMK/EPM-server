package com.dartmedia.dmss.controller;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.dto.Alarm;
import com.dartmedia.dmss.dto.CommonCode;
import com.dartmedia.dmss.service.AlarmService;
import com.dartmedia.dmss.service.CommonCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j  // 로그기능 활성화
@Api(tags = {"9. Alarm"}) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/alarm") // 최상단 API 경로 설정
public class AlarmController {

    private final ResponseService responseService;
    private final AlarmService alarmService;

    @ApiOperation(value = "Alarm 리스트 전체 조회", notes = "Alarm 리스트 전체 조회")
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<Alarm> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<Alarm> findAlarms = alarmService.findAll();

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findAlarms.size()>0)
                result = responseService.getMultiResult(findAlarms);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(ResponseService.CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "Alarm 개별 등록", notes = "Alarm 개별 등록")
    @PutMapping("/")    // PUT HTTP 메서드
    public ResponseEntity<?> create(@Valid @RequestBody Alarm alarm) {

        // PUT, POST, DELETE HTTP 메서드는 데이터 응답이 아닌 결과만 알려주면 되므로 CommonResult로 리턴
        CommonResult result = null;

        try {

            alarmService.create(alarm);

            result = responseService.getSuccessResult();


        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(ResponseService.CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }


    @ApiOperation(value = "Alarm 개별 수정", notes = "Alarm 개별 수정")
    @PostMapping("/")   // POST HTTP 메서드
    public ResponseEntity<?> update(@Valid @RequestBody Alarm alarm) {

        CommonResult result = null;

        try {

            if(alarm.getFuncId() % 10 == 0)
            {
                Alarm findAlarm = alarmService.readByFuncId(alarm.getFuncId());

                if(findAlarm!=null)
                {
                    alarmService.update(alarm);

                    result = responseService.getSuccessResult();
                }else
                {
                    result = responseService.getSingleFailType(ResponseService.CommonResponse.NODATA);
                }
            }
            else
            {
                result = responseService.getSingleFailType(ResponseService.CommonResponse.ERR);
            }

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(ResponseService.CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }



    @ApiOperation(value = "Alarm 개별 삭제", notes = "Alarm 개별 삭제")
    @DeleteMapping("/{funcId}")  // DELETE HTTP 메서드
    public ResponseEntity<?> delete(@ApiParam(value = "funcId", required = true) @PathVariable("funcId") int funcId) {
        CommonResult result = null;
        try {

            // 알림이 존재하는지 확인
            Alarm findAlarm = alarmService.readByFuncId(funcId);

            if(findAlarm!=null)
            {
                // 알림이 존재하는 경우 삭제
                alarmService.delete(funcId);

                result = responseService.getSingleResult(ResponseService.CommonResponse.SUCCESS);
            }
            else
            {
                result = responseService.getSingleFailType(ResponseService.CommonResponse.NODATA);
            }

        }catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(ResponseService.CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }
}
