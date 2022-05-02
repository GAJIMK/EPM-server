package com.dartmedia.dmss.controller;

import java.util.List;

import javax.validation.constraints.Null;

import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.common.SingleResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.ManagerInfo;
import com.dartmedia.dmss.service.ManagerInfoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Slf4j
@Api(tags = { "8. ManagerInfo" })
@RequiredArgsConstructor
@RestController
@RequestMapping("/managerinfo")
public class ManagerInfoController {
  private final ResponseService responseService;
  private final ManagerInfoService managerInfoService;

  @ApiOperation(value="담당자 전체 출력 ", notes = "담당자 전체 리스트")
  @GetMapping(value="/{master}")
  public ResponseEntity<?> findManager(@ApiParam(value="마스터여부",required = true) @PathVariable("master") String master) {

    MultiResult<ManagerInfo> result = null;

    try {
      List<ManagerInfo> findManager = managerInfoService.findManager(master);

      if (findManager.size() > 0)
        result = responseService.getMultiResult(findManager);
      else 
        result = responseService.getMultiFailType(CommonResponse.NODATA); 

    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = responseService.getMultiFailType(ResponseService.CommonResponse.ERR); 
    }

    return ResponseEntity.ok().body(result);
  }
  
  @ApiOperation(value="해당 기능 담당자 출력 ", notes = "funcId 담당자 출력")
  @GetMapping(value="/{master}/{funcId}")
  public ResponseEntity<?> findManagerByFuncId(@ApiParam(value="마스터여부",required = true) 
                                              @PathVariable String master,
                                              @PathVariable String funcId) {

    SingleResult<ManagerInfo> result = null;

    try {
      ManagerInfo findManager = managerInfoService.findManagerByFuncId(master,funcId);

      if (findManager.getAccountNm()!=null)
        result = responseService.getSingleResult(findManager);
      else 
        result = responseService.getSingleFailType(CommonResponse.NODATA); 

    } catch (Exception e) {
      log.error("처리중 예외 : " + e.getMessage());
      result = responseService.getSingleFailType(ResponseService.CommonResponse.ERR); 
    }

    return ResponseEntity.ok().body(result);
  }

}
