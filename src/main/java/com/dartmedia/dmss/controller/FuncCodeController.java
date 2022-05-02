package com.dartmedia.dmss.controller;

import java.util.List;

import javax.validation.Valid;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.FuncCode;
import com.dartmedia.dmss.service.FuncCodeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j  
@Api(tags = {"5. FuncCode"})
@RequiredArgsConstructor
@RestController 
@RequestMapping("/funcCode") 
public class FuncCodeController {
  private final ResponseService responseService;
  private final FuncCodeService funcCodeService;

  @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        MultiResult<FuncCode> result = null;

        try {
            List<FuncCode> findFunc = funcCodeService.findAll();

            if(findFunc.size()>0)
                result = responseService.getMultiResult(findFunc);
            else
                result = responseService.getMultiFailType(CommonResponse.NODATA);

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "FuncCode 개별 등록", notes = "FuncCode 개별 등록")
    @PutMapping("/")  
    public ResponseEntity<?> create(@Valid @RequestBody FuncCode funcCode) {

      
        int result = 0;

        try {
            
            // 기능 이름이 비어있는지 확인 
            if(funcCode.getFuncNm()!= null && funcCode.getFuncNm().length()!=0)
            {
                funcCodeService.create(funcCode);

                result = funcCode.getFuncId();
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
    

    @ApiOperation(value = "FuncCode 개별 수정", notes = "FuncCode 개별 수정")
    @PostMapping("/")
    public ResponseEntity<?> update(@Valid @RequestBody FuncCode funcCode) {

        CommonResult result = null;

        try {
            
            if(funcCode.getFuncId()>=0)
            {
                FuncCode readFunc = funcCodeService.readByFuncId(funcCode.getFuncId());

                if(readFunc!=null)
                {
                    funcCodeService.update(funcCode);

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
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }



    @ApiOperation(value = "FuncCode 개별 삭제", notes = "FuncCode 개별 삭제")
    @DeleteMapping("/{funcId}")  // DELETE HTTP 메서드
    public ResponseEntity<?> delete(@ApiParam(value = "특수기능 번호", required = true) @PathVariable("funcId") short funcId) {
        CommonResult result = null;
        try {

            // 기능코드가 존재하는지 확인 
            FuncCode funcCode = funcCodeService.readByFuncId(funcId);

            if(funcCode!=null)
            {
                // 기능코드가  존재하는 경우 삭제
                funcCodeService.deleteByFuncId(funcId);

                result = responseService.getSingleResult(CommonResponse.SUCCESS);   
            } 
            else
            {
                result = responseService.getSingleFailType(CommonResponse.NODATA);
            }

        }catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            result = responseService.getSingleFailType(CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(result);
    }
}
