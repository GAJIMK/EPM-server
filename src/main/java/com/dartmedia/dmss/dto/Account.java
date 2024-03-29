package com.dartmedia.dmss.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Mybatis 에 사용
 * DB에 저장된 테이블과 매칭됨
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Account {

	// 파라미터 검증, NULL이면 오류 발생
	@NotNull(message = "id는 필수 값입니다.")
	private String AccountId;
	
	private String tpAccount;
	private String AccountNm;

	private String tpPosition;

	private String Password;
	private String PhoneNo;
	private String ExchangeNo;
	private String MobileNo;

	// 파라미터 검증, @가 들어간 이메일 형식이어야함
	
	private String eMail;

	private String tpPublish;

	private String PostNo;
	private String Addr1;

	// 파라미터 검증, 현재보다 과거여야함
	// 이밖에 다양한 검증이 있음
	
	private Date BirthDay;
}
