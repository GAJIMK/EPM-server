# Expense-management-server
경비 관리 프로젝트 

## 개요
기업의 경비로 지출이 되는 영업비, 복지비를 관리하기 위한 서비스 

## 서비스 방식
### 👤구성원 
기업의 구성원들의 달별 경비 지출을 작성하고, 실시간으로 작성한 내용을 저장할 수 있다. 
구성원들은 자신의 지난 제출 내역과, 제출한 내역에 대한 진행 상황을 확인할 수 있다. 


### 🕵️‍♀️관리자
경영지원실에서 최대 사용금액의 항목을 관리하거나, 직급별 지원 금액 등을 설정할 수 있다. 


### 기타 
점심 메뉴 랜덤 추천, 게시판 (공감하기/작성하기) ,핫 게시글



  
## 개발환경 정리
1. java 11
2. Spring boot 2.2.1
3. Build : Maven
4. DB : MS-SQL
4. MyBatis
5. Git : 2.23.0
6. WAS : Embedded Tomcat 9.0.27
7. Test : JUnit
8. Log : SLF4J(Log4j2)

### 설치 프로그램
1. VSCODE : https://code.visualstudio.com/
2. GIT-SCM : https://git-scm.com/download


### VSCODE 설치 플러그인
1. 한글팩
   1. Korean Language Pack for Visual Studio Code
2. 깃 연동
   1. Git History
   2. Git History Diff
3. 기타 지원기능
   1. Auto Close Tag
   2. Beautify
   3. ESLint
   4. Getter/Setter Generator
4. 웹사이트 즉시 로딩
   1. Open int browser
5. 스프링/JAVA 연동
   1. Spring Boot Tools
   2. Spring Initializer Java Support
   3. Spirng Boot Dashboard
   4. Spring Boot Extention Pack
   5. Java Dependency Viewer
   6. Java Extension Pack
   7. Java Test Runner
   8. Maven for Java
   9. Debugger for java
6.  소스 자동 완성
    1.  Visaul Studio IntelliCode 
7.  검은색 테마
    1.  Night Owl


## API Request

|번호|URL|메소드|설명|
|---|---|---|---| 
|1|http://localhost:8009/auth/login|GET|로그인|
|2|http://localhost:8009/account/|GET|사용자 리스트 전체 조회
|3|http://localhost:8009/account/|PUT|사용자 등록
|4|http://localhost:8009/account/|POST|사용자 정보 수정 
|5|http://localhost:8009/account/{accountId}|DELETE|특정 사용자 삭제
|6|http://localhost:8009/account/{accountId}|GET|특정 사용자 정보 조회
|7|http://localhost:8009/appoint/findTeamNo?accountId={accountId}|GET|특정 사용자의 내부 팀아이디 조회
|8|http://localhost:8009/userFeeList/findAll?accountId={accountId}|GET|특정 사용자의 작성한 전체 경비항목 조회|
|9|http://localhost:8009/userFeeList/findByAccountId?accountId={accountId}&date={date}|GET|특정 사용자의 월별 경비항목 조회|
|10|http://localhost:8009/userFeeList/findByPartId?accountId={accountId}&date={date}&part={partNo}|GET|특정 사용자의 월별, 그리고 특정 경비항목 조회
|11|http://localhost:8009/userFeeList/|POST|경비항목 수정
|12|http://localhost:8009/auth/login|---|
|13|http://localhost:8009/auth/login|---|
|14|http://localhost:8009/board/findAll|GET|게시판 전체 글 불러오기|
|15|http://localhost:8009/board/findBypage?page=${page}|GET|페이지별 게시판 글 불러오기 |
|16|http://localhost:8009/board/findById?id=${id}|GET|게시글 클릭시 해당 게시글 불러오기|
|17|http://localhost:8009/board/{id}|PUT|게시판 글 등록|
|18|http://localhost:8009/thumbs/countById?id=${id}|GET|게시글 별 좋아요 개수 불러오기|
|19|http://localhost:8009/thumbs/selectTop5|GET|좋아요 탑 5 조회하기|
|20|http://localhost:8009/thumbs/{id}|PUT|좋아요 누르기|





