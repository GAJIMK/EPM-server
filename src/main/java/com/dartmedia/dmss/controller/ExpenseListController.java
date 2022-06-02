package com.dartmedia.dmss.controller;

import java.util.List;

import javax.validation.Valid;

import com.dartmedia.dmss.common.CommonResult;
import com.dartmedia.dmss.common.MultiResult;
import com.dartmedia.dmss.core.ResponseService;
import com.dartmedia.dmss.core.ResponseService.CommonResponse;
import com.dartmedia.dmss.dto.ExpenseList;
import com.dartmedia.dmss.service.ExpenseListService;

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
@Api(tags = { "5. Expense-list" })
@RequiredArgsConstructor
@RestController
@RequestMapping("/expense-list")
public class ExpenseListController {
    private final ResponseService resService;
    private final ExpenseListService service;

    @ApiOperation(value = "경비 가능 항목 조회", notes = "경비 가능 항목 조회")
    @GetMapping("/")
    public ResponseEntity<?> findAll() {

        MultiResult<ExpenseList> rs = null;

        try {
            List<ExpenseList> list = service.findAll();

            if (list.size() > 0)
                rs = resService.getMultiResult(list);
            else
                rs = resService.getMultiFailType(CommonResponse.NODATA);

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            rs = resService.getMultiFailType(ResponseService.CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(rs);
    }

    @ApiOperation(value = "ExpenseList 개별 등록", notes = "ExpenseList 개별 등록")
    @PutMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody ExpenseList expenseList) {

        CommonResult rs;

        try {

            // 기능 이름이 비어있는지 확인

            service.create(expenseList);

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
        }
        rs = resService.getSuccessResult();
        return ResponseEntity.ok().body(rs);
    }

    // @ApiOperation(value = "ExpenseList 개별 수정", notes = "ExpenseList 개별 수정")
    // @PostMapping("/")
    // public ResponseEntity<?> update(@Valid @RequestBody ExpenseList expenseList)
    // {

    // CommonResult rs = null;

    // try {

    // if (expenseList.getList().length() != 0) {
    // ExpenseList readFunc = service.read(expenseList.getList());

    // if (readFunc != null) {
    // service.update(expenseList);

    // rs = resService.getSuccessResult();
    // } else {
    // rs = resService.getSingleFailType(CommonResponse.NODATA);
    // }
    // } else {
    // rs = resService.getSingleFailType(CommonResponse.EMPTY_ID);
    // }

    // } catch (Exception e) {
    // log.error("처리중 예외 : " + e.getMessage());
    // rs = resService.getSingleFailType(CommonResponse.ERR);
    // }

    // return ResponseEntity.ok().body(rs);
    // }

    @ApiOperation(value = "ExpenseList 개별 삭제", notes = "ExpenseList 개별 삭제")
    @DeleteMapping("/{list}") // DELETE HTTP 메서드
    public ResponseEntity<?> delete(@ApiParam(value = "경비명", required = true) @PathVariable("list") String id) {
        CommonResult rs = null;
        try {

            // 기능코드가 존재하는지 확인
            ExpenseList expenseList = service.read(id);

            if (expenseList != null) {
                // 기능코드가 존재하는 경우 삭제
                service.delete(id);

                rs = resService.getSingleResult(CommonResponse.SUCCESS);
            } else {
                rs = resService.getSingleFailType(CommonResponse.NODATA);
            }

        } catch (Exception e) {
            log.error("처리중 예외 : " + e.getMessage());
            rs = resService.getSingleFailType(CommonResponse.ERR);
        }

        return ResponseEntity.ok().body(rs);
    }
}
