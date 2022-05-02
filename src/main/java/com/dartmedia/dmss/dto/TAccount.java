package com.dartmedia.dmss.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Mybatis 에 사용
 * DB에 저장된 테이블과 매칭됨
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
public class TAccount {

	// 파라미터 검증, NULL이면 오류 발생
	@NotNull(message = "id는 필수 값입니다.")
	private String IDNo;
    private String AccountId;
	private short tpAccount;
	private String AccountNm;
	private short TeamNo;
	private short tpPosition;
	private String Password;
	private String PhoneNo;
	private String ExchangeNo;
	private String MobileNo;

	// 파라미터 검증, @가 들어간 이메일 형식이어야함
	@Email
	@ApiModelProperty(name = "이메일", value = "test@test.com")
	private String eMail;
	private short tpPublish;
	private String PostNo;
	private String Addr1;
	private String Addr2;

	// 파라미터 검증, 현재보다 과거여야함
	// 이밖에 다양한 검증이 있음
	@Past
	private Date BirthDay;

	private char DirectorYn;
	private char ManagerYn;
}
