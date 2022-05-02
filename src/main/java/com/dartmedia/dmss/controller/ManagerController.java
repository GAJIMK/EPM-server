package com.dartmedia.dmss.controller;

import javax.validation.Valid;
import java.util.List;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.Manager;
import com.dartmedia.dmss.service.ManagerService;
import com.dartmedia.dmss.common.MultiResult;

import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그기능 활성화
@Api(tags = { "4. Manager" }) // SWAGGER 설정

@RequiredArgsConstructor
@RestController // REST컨트롤러 설정
@RequestMapping("/manager") // 최상단 API 경로 설정
public class ManagerController {
    private final ResponseService responseService;
    private final ManagerService managerService;

    @ApiOperation(value = "Manager 리스트 전체 조회", notes = "Manager 리스트 전체 조회")
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        // GET HTTP 메서드인 경우 결과값을 리턴해주기때문에 MultiResult or SingleResult로 담아서 리턴
        MultiResult<Manager> result = null;

        try {
            // 서비스를 통해 전체 조회
            List<Manager> findManager = managerService.findAll();

            // 조회한 결과값이 1개 이상인 경우 결과출력
            if (findManager.size() > 0)
                result = responseService.getMultiResult(findManager);
            else // 없는 경우 NODATA로 응답
                result = responseService.getMultiFailType(ResponseService.CommonResponse.NODATA); // 데이터 없음으로 응답,
                                                                                                  // CommonResponse에 사전에
                                                                                                  // 선언된 결과값이 있음

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR); // 예외 발생시 에러로 응답
        }

        // 해당 결과값을 API 응답으로 리턴
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "Manager 개별 등록", notes = "Manager 개별 등록")
    @PutMapping("/") // PUT HTTP 메서드
    public ResponseEntity<?> create(@Valid @RequestBody Manager manager) {

        // PUT, POST, DELETE HTTP 메서드는 데이터 응답이 아닌 결과만 알려주면 되므로 CommonResult로 리턴
        CommonResult result = null;

        try {
            // 계정이 비어있는지 확인
            if (manager.getManagerId() != null) {

                managerService.create(manager);
                result = responseService.getSuccessResult();
            } else {
                // 계정이 비어있는경우
                result = responseService.getSingleFailType(CommonResponse.EMPTY_ID); // 빈계정 알림
            }

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "Manager 개별 수정", notes = "Manager 개별 수정")
    @PostMapping("/") // POST HTTP 메서드
    public ResponseEntity<?> update(@Valid @RequestBody Manager manager) {

        CommonResult result = null;

        try {

            if (manager.getManagerId() != null) {

                    managerService.update(manager);


            } else {
                result = responseService.getSingleFailType(CommonResponse.EMPTY_ID);
            }

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "Manager 개별 삭제", notes = "Manager 개별 삭제")
    @DeleteMapping("/{managerId}") // DELETE HTTP 메서드
    public ResponseEntity<?> delete(
            @ApiParam(value = "managerId", required = true) @PathVariable("managerId") String managerId) {
        CommonResult result = null;
        try {

            // 매니저가 존재하는지 확인
            Manager readManager = managerService.read(managerId);

            if (readManager != null) {
                // 매니저가 존재하는 경우 삭제
                managerService.delete(managerId);

                result = responseService.getSingleResult(ResponseService.CommonResponse.SUCCESS);
            } else {
                result = responseService.getSingleFailType(ResponseService.CommonResponse.NODATA);
            }

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(ResponseService.CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }

}
