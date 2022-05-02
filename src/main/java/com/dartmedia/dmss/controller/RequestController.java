package com.dartmedia.dmss.controller;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.dto.Request;
import com.dartmedia.dmss.dto.TAccount;
import com.dartmedia.dmss.service.RequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

@Slf4j  // 로그기능 활성화
@Api(tags = {"8. request"}) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/request") // 최상단 API 경로 설정
public class RequestController {

    private final ResponseService responseService;
    private final RequestService requestService;

    @ApiOperation(value = "request 리스트 전체 조회", notes = "request 리스트 전체 조회")   // SWAGGER 문서 설정
    @GetMapping("findAll")
    public ResponseEntity<?> findAll() {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<Request> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<Request> findRequest = requestService.findAll();

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findRequest.size()>0)
                result = responseService.getMultiResult(findRequest);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(ResponseService.CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value="request 개별 등록", notes="request 개별 등록")
    @PutMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody Request request) {

      
        int result = 0;

        try {
            
            // 기능 이름이 비어있는지 확인 
            if(request.getTitle()!= null && request.getTitle().length()!=0)
            {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String sendTime = sdf.format(timestamp);


                request.setSendTime(sendTime);
                requestService.create(request);
                result = request.getRequestId();
            }
            else
            {
                result = -1;
            }

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = -1;
        }

        return ResponseEntity.ok().body(result);
    }
    @ApiOperation(value = "request 개별 삭제", notes = "request 개별 삭제")
    @DeleteMapping("/{requestId}")  // DELETE HTTP 메서드
    public ResponseEntity<?> delete(@ApiParam(value = "requestId", required = true) @PathVariable("requestId") int requestId) {
        CommonResult result = null;
        try {

            // 요청이 존재하는지 확인
            Request request = requestService.readByRequestId(requestId);

            if(request!=null)
            {
                // 요청이 존재하는 경우 삭제
                requestService.deleteByRequestId(requestId);

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
