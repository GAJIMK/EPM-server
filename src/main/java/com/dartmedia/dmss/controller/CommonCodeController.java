package com.dartmedia.dmss.controller;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.dto.CommonCode;
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
@Api(tags = {"11. CommonCode"}) // SWAGGER 설정
@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/commonCode") // 최상단 API 경로 설정
public class CommonCodeController {

    private final ResponseService responseService;
    private final CommonCodeService commonCodeService;

    @ApiOperation(value = "CommonCode 클래스 별 리스트 조회", notes = "CommonCode 클래스 리스트 조회")
    @GetMapping("/findAll/{classCode}")
    public ResponseEntity<?> findByClassCode(@PathVariable("classCode") String classCode) {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<CommonCode> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<CommonCode> findCommonCode = commonCodeService.readByClassCode(classCode);

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findCommonCode.size()>0)
                result = responseService.getMultiResult(findCommonCode);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(ResponseService.CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "CommomCode에서 옵션에 필요한 리스트 전체 조회", notes = "CommomCode에서 옵션에 필요한 리스트 전체 조회")
    @GetMapping("/findAll/options")
    public ResponseEntity<?> findOptionList() {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<CommonCode> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<CommonCode> findCommonCode = commonCodeService.readOptionData();

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findCommonCode.size()>0)
                result = responseService.getMultiResult(findCommonCode);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(ResponseService.CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "CommomCode 리스트 전체 조회", notes = "CommomCode 리스트 전체 조회")
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<CommonCode> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<CommonCode> findCommonCode = commonCodeService.findAll();

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if(findCommonCode.size()>0)
                result = responseService.getMultiResult(findCommonCode);
            else    // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(ResponseService.CommonResponse.NODATA); // 데이터 없음으로 응답, CommonResponse에 사전에 선언된 결과값이 있음

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);  // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "CommonCode 개별 등록", notes = "CommonCode 개별 등록")
    @PutMapping("/")    // PUT HTTP 메서드
    public ResponseEntity<?> create(@Valid @RequestBody CommonCode commonCode) {

        // PUT, POST, DELETE HTTP 메서드는 데이터 응답이 아닌 결과만 알려주면 되므로 CommonResult로 리턴
        CommonResult result = null;

        try {

            // 계정이 비어있는지 확인
            if(commonCode.getCommonName()!=null)
            {
                // 추가하는 계정이 존재하는지 확인하기 위해 조회
                CommonCode readCommonCode = commonCodeService.read(commonCode.getCommonName());

                if(readCommonCode!=null)
                {
                    // 계정이 존재하는 경우
                    result = responseService.getSingleFailType(ResponseService.CommonResponse.EXIST);   // 기존에 등록된 정보가 있음으로 응답
                }
                else
                {
                    commonCodeService.create(commonCode);

                    result = responseService.getSuccessResult();
                }
            }
            else
            {
                // 계정이 비어있는경우
                result = responseService.getSingleFailType(ResponseService.CommonResponse.EMPTY_ID);    // 빈계정 알림
            }

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(ResponseService.CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }


    @ApiOperation(value = "CommonCode 개별 수정", notes = "CommonCode 개별 수정")
    @PostMapping("/")   // POST HTTP 메서드
    public ResponseEntity<?> update(@Valid @RequestBody CommonCode commonCode) {

        CommonResult result = null;

        try {

            if(commonCode.getCommonName()!=null)
            {
                CommonCode readAccount = commonCodeService.read(commonCode.getCommonName());

                if(readAccount!=null)
                {
                    commonCodeService.update(commonCode);

                    result = responseService.getSuccessResult();
                }else
                {
                    result = responseService.getSingleFailType(ResponseService.CommonResponse.NODATA);
                }
            }
            else
            {
                result = responseService.getSingleFailType(ResponseService.CommonResponse.EMPTY_ID);
            }

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(ResponseService.CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }



    @ApiOperation(value = "CommonCode 개별 삭제", notes = "CommonCode 개별 삭제")
    @DeleteMapping("/{CommonName}")  // DELETE HTTP 메서드
    public ResponseEntity<?> delete(@ApiParam(value = "CommonName", required = true) @PathVariable("CommonName") String CommonName) {
        CommonResult result = null;
        try {

            // 계정이 존재하는지 확인
            CommonCode commonCode = commonCodeService.read(CommonName);

            if(commonCode!=null)
            {
                // 계정이 존재하는 경우 삭제
                commonCodeService.delete(CommonName);

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
