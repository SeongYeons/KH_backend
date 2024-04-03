/*
  <DDL(Data Definition Language)>
    데이터 정의 언어로 오라클에서 제공하는 객체(OBJECT)를 생성하고(CREATE), 
    수정하고(ALTER), 삭제(DROP)하는 구문이다.
    
  <CREATE>
    오라클 데이터베이스 객체(테이블, 뷰, 인덱스 등)를 생성하는 구문이다.
    
  <테이블 생성>
    [표현법]
      CREATE TABLE 테이블명 (
        컬럼명 자료형(크기) [DEFAULT 기본값] [제약조건],
        컬럼명 자료형(크기) [DEFAULT 기본값] [제약조건],
        ...   
      );
*/
-- 회원에 대한 데이터를 담을 수 있는 MEMBER 테이블 생성
CREATE TABLE MEMBER(
    NO NUMBER,
    ID VARCHAR2(20),
    PASSWORD VARCHAR2(20),
    NAME VARCHAR2(15),
    ENROLL_DATE DATE DEFAULT SYSDATE
);

-- 테이블 삭제
DROP TABLE MEMBER;

-- 테이블의 구조를 표시해 주는 구문이다.
DESC MEMBER;

/*
  데이터 딕셔너리
    자원을 효율적으로 관리하기 위해 다양한 객체들의 정보를 저장하는
    시스템 테이블이다.
    데이터에 관한 데이터가 저장되어 있다고 해서 메타 데이터라고도 한다.
*/
-- USER_TABLES : 사용자가 가지고 있는 테이블들의 구조를 확인하는 뷰 테이블이다.
SELECT *
FROM USER_TABLES
WHERE TABLE_NAME = 'MEMBER';

-- USER_TAB_COLUMNS : 사용자가 가지고 있는 테이블, 컬럼과 관련된
--                    정보를 조회하는 뷰 테이블이다.
SELECT *
FROM USER_TAB_COLUMNS
WHERE TABLE_NAME = 'MEMBER';

/*
  <컬럼 주석>
    테이블의 컬럼에 대한 설명을 작성할 수 있는 구문이다.
*/
COMMENT ON COLUMN MEMBER.NO IS '회원 번호';
COMMENT ON COLUMN MEMBER.ID IS '회원 아이디';
COMMENT ON COLUMN MEMBER.PASSWORD IS '회원 비밀번호';
COMMENT ON COLUMN MEMBER.NAME IS '회원 이름';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS '회원 가입일';

-- 테이블에 샘플 데이터 추가(INSERT)
-- INSERT INTO 테이블명[(컬럼명, ..., 컬럼명)] VALUES (값, ..., 값);
INSERT INTO MEMBER 
VALUES (1, 'USER1', '1234', '홍길동', '2023-11-09');

INSERT INTO MEMBER
VALUES (2, 'USER2', '1234', '이몽룡', SYSDATE);

INSERT INTO MEMBER(NO, ID, PASSWORD, NAME, ENROLL_DATE)
VALUES (3, 'USER3', '1234', '성춘향', DEFAULT);

INSERT INTO MEMBER(ID, PASSWORD) VALUES ('USER4', '1234');

INSERT INTO MEMBER(ID, PASSWORD) 
VALUES ('USER4USER4USER4USER4USER4USER4', '1234');

-- 메모리 버퍼에 임시 저장된 데이터를 실제 테이블에 반영한다.
COMMIT;
ROLLBACK;

SELECT * FROM MEMBER;

SHOW AUTOCOMMIT;
--SET AUTOCOMMIT OFF;
--SET AUTOCOMMIT ON;

/*
  <제약조건>
    테이블 작성 시 각 컬럼에 대해 저장될 데이터에 대한 제약조건을 설정할 수 있다.
    제약조건은 데이터 무결성 보장을 목적으로 한다.
    (데이터의 정확성과 일관성을 유지시키는 것)
    
    * 종류 : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY
    
    [표현법]
      -- 1) 컬럼 레벨
           CREATE TABLE 테이블명 (
             컬럼명 자료형(크기) [CONSTRAINT 제약조건명] 제약조건,
             ...
           );
    
      -- 2) 테이블 레벨
           CREATE TABLE 테이블명 (
             컬럼명 자료형(크기),
             ...
             [CONSTRAINT 제약조건명] 제약조건 (컬럼명)
           );
*/
/*
    1. NOT NULL 제약 조건
       해당 컬럼에 반드시 값이 있어야만 하는 경우에 사용한다.
       NOT NULL 제약조건은 컬럼 레벨에서만 설정이 가능하다.
*/
-- 기존 MEMBER 테이블은 값에 NULL이 있어도 행의 삽입이 가능하다.
INSERT INTO MEMBER VALUES (NULL, NULL, NULL, NULL, NULL);

-- NOT NULL 제약조건을 설정한 테이블 생성
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    NO NUMBER NOT NULL,
    ID VARCHAR2(20) NOT NULL,
    PASSWORD VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(15) NOT NULL,
    ENROLL_DATE DATE DEFAULT SYSDATE
);

-- NOT NULL 제약조건에 위배되어 오류 발생
INSERT INTO MEMBER VALUES (NULL, NULL, NULL, NULL, NULL);

-- NOT NULL 제약조건이 걸려있는 컬럼에는 반드시 값이 있어야 한다.
INSERT INTO MEMBER VALUES(1, 'USER1', '1234', '홍길동', NULL);
INSERT INTO MEMBER VALUES(2, 'USER2', '1234', '이몽룡', DEFAULT);
INSERT INTO MEMBER(NO, ID, PASSWORD, NAME) 
VALUES(3, 'USER3', '5678', '성춘향');

-- 테이블의 데이터를 수정하는 구문
UPDATE MEMBER
SET ID = NULL
WHERE NAME = '홍길동';

-- 사용자가 작성한 제약조건을 확인하는 뷰 테이블이다.
SELECT *
FROM USER_CONSTRAINTS;

-- 사용자가 작성한 제약조건이 걸려있는 컬럼을 확인하는 뷰 테이블이다.
SELECT *
FROM USER_CONS_COLUMNS;

/*
    2. UNIQUE 제약조건
       컬럼에 중복된 값을 저장하거나 중복된 값으로 수정할 수 없도록 한다.
       UNIQUE 제약조건은 컬럼 레벨, 테이블 레벨 방식 모두 사용 가능하다.
*/
-- 아이디가 중복되어도 성공적으로 데이터가 삽입된다.
INSERT INTO MEMBER VALUES (1, 'USER1', '1234', '임꺽정', DEFAULT);
INSERT INTO MEMBER VALUES (1, 'USER1', '1234', '임꺽정', DEFAULT);

-- UNIQUE 제약조건을 설정한 테이블 생성 (컬럼 레벨 방식)
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    NO NUMBER NOT NULL UNIQUE,
    ID VARCHAR2(20) NOT NULL UNIQUE,
    PASSWORD VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(15) NOT NULL,
    ENROLL_DATE DATE DEFAULT SYSDATE
);

INSERT INTO MEMBER VALUES (1, 'USER1', '1234', '홍길동', DEFAULT);
INSERT INTO MEMBER VALUES (1, 'USER1', '5678', '임꺽정', DEFAULT); -- 에러 발생
INSERT INTO MEMBER VALUES (2, 'USER2', '5678', '임꺽정', DEFAULT);

-- UNIQUE 제약조건을 설정한 테이블 생성 (테이블 레벨 방식)
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    NO NUMBER CONSTRAINT MEMBER_NO_NN NOT NULL,
    ID VARCHAR2(20) CONSTRAINT MEMBER_ID_NN NOT NULL,
    PASSWORD VARCHAR2(20) CONSTRAINT MEMBER_PASSWORD_NN NOT NULL,
    NAME VARCHAR2(15) CONSTRAINT MEMBER_NAME_NN NOT NULL,
    ENROLL_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_NO_UQ UNIQUE(NO),
    CONSTRAINT MEMBER_ID_UQ UNIQUE(ID)
);

INSERT INTO MEMBER VALUES (1, 'USER1', '1234', '홍길동', DEFAULT);
INSERT INTO MEMBER VALUES (1, 'USER1', '5678', '임꺽정', DEFAULT); -- 에러 발생
INSERT INTO MEMBER VALUES (2, 'USER2', '5678', '임꺽정', DEFAULT);

-- 여러 개의 컬럼을 묶어서 하나의 UNIQUE 제약조건을 설정한 테이블 생성
-- 단, 반드시 테이블 레벨로만 설정이 가능하다.
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    NO NUMBER CONSTRAINT MEMBER_NO_NN NOT NULL,
    ID VARCHAR2(20) CONSTRAINT MEMBER_ID_NN NOT NULL,
    PASSWORD VARCHAR2(20) CONSTRAINT MEMBER_PASSWORD_NN NOT NULL,
    NAME VARCHAR2(15) CONSTRAINT MEMBER_NAME_NN NOT NULL,
    ENROLL_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_NO_ID_UQ UNIQUE(NO, ID)
);

-- 여러 개의 컬럼을 묶어서 하나의 UNIQUE 제약조건이 설정되어 있으면
-- 제약조건이 설정되어 있는 컬럼 값이 모두 중복되는 경우에만 오류 발생한다.
INSERT INTO MEMBER VALUES (1, 'USER1', '1234', '홍길동', DEFAULT);
INSERT INTO MEMBER VALUES (2, 'USER1', '5678', '임꺽정', DEFAULT);
INSERT INTO MEMBER VALUES (2, 'USER1', '5678', '홍길동', DEFAULT); -- 에러 발생
INSERT INTO MEMBER VALUES (2, 'USER2', '5678', '홍길동', DEFAULT);

/*
    3. CHECK 제약조건
       컬럼에 기록되는 값에 조건을 설정하고 조건을 만족하는 값만 저장하거나 수정하도록 한다.
       CHECK 제약조건은 컬럼 레벨, 테이블 레벨에서 모두 설정이 가능하다.
*/
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    NO NUMBER NOT NULL,
    ID VARCHAR2(20) NOT NULL,
    PASSWORD VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(15) NOT NULL,
    GENDER CHAR(3),
    AGE NUMBER,
    ENROLL_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_NO_UQ UNIQUE(NO),
    CONSTRAINT MEMBER_ID_UQ UNIQUE(ID)
);

-- 성별, 나이에 유효한 값이 아닌 값들도 INSERT 된다.
INSERT INTO MEMBER
VALUES(1, 'USER1', '1234', '홍길동', '남', 25, DEFAULT);
INSERT INTO MEMBER
VALUES(2, 'USER2', '1234', '성춘향', '여', 20, DEFAULT);
INSERT INTO MEMBER
VALUES(3, 'USER3', '1234', '임꺽정', '강', -30, DEFAULT);

-- CHECK 제약조건을 설정한 테이블 생성
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    NO NUMBER NOT NULL,
    ID VARCHAR2(20) NOT NULL,
    PASSWORD VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(15) NOT NULL,
    GENDER CHAR(3) CONSTRAINT MEMBER_GENDER_CK CHECK(GENDER IN ('남', '여')),
    AGE NUMBER,
    ENROLL_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_NO_UQ UNIQUE(NO),
    CONSTRAINT MEMBER_ID_UQ UNIQUE(ID),
    CONSTRAINT MEMBER_AGE_CK CHECK(AGE >= 0)
);

INSERT INTO MEMBER
VALUES(1, 'USER1', '1234', '홍길동', '남', 25, DEFAULT);
INSERT INTO MEMBER
VALUES(2, 'USER2', '1234', '성춘향', '여', 20, DEFAULT);
INSERT INTO MEMBER
VALUES(3, 'USER3', '1234', '임꺽정', '강', 30, DEFAULT);
-- GENDER 컬럼에 '남' 또는 '여'만 입력 가능하도록 설정이 되었기 때문에 에러가 발생한다.
INSERT INTO MEMBER
VALUES(4, 'USER4', '1234', '이몽룡', '남', -22, DEFAULT);
-- AGE 컬럼에 0보다 크거나 같은 값만 입력 가능하도록 설정이 되었기 때문에 에러가 발생한다.

SELECT * FROM MEMBER;

COMMIT;
ROLLBACK;

UPDATE MEMBER
--SET PASSWORD = '5678'
--SET GENDER = '강'
SET AGE = -100
WHERE NO = 1;

/*
    4. PRIMARY KEY(기본 키) 제약조건
       테이블에서 한 행의 정보를 식별하기 위해 사용할 컬럼에 부여하는 제약조건이다.
       PRIMARY KEY 제약조건은 컬럼 레벨, 테이블 레벨에서 모두 설정이 가능하다.
*/
-- PRIMARY KEY 제약조건을 설정한 테이블 생성
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
--    NO NUMBER CONSTRAINT MEMBER_NO_PK PRIMARY KEY,
    NO NUMBER,
    ID VARCHAR2(20) NOT NULL,
    PASSWORD VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(15) NOT NULL,
    GENDER CHAR(3),
    AGE NUMBER,
    ENROLL_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_NO_PK PRIMARY KEY(NO),
    CONSTRAINT MEMBER_ID_UQ UNIQUE(ID),
    CONSTRAINT MEMBER_GENDER_CK CHECK(GENDER IN ('남', '여')),
    CONSTRAINT MEMBER_AGE_CK CHECK(AGE >= 0)
);

INSERT INTO MEMBER 
VALUES(1, 'USER1', '1234', '홍길동', '남', '22', DEFAULT);

INSERT INTO MEMBER 
VALUES(2, 'USER2', '5678', '성춘향', '여', '22', DEFAULT);

-- 기본 키 중복으로 에러 발생
INSERT INTO MEMBER 
VALUES(2, 'USER3', '5678', '이몽룡', '남', '26', DEFAULT);

-- 기본 키가 NULL이므로 에러 발생
INSERT INTO MEMBER 
VALUES(NULL, 'USER3', '5678', '이몽룡', '남', '26', DEFAULT);

--  여러 컬럼을 묶어서 하나의 기본 키를 생성(복합키라고 한다.)
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
--  한 테이블에 한 개의 기본 키만 설정할 수 있다.
--  NO NUMBER PRIMARY KEY,
--  ID VARCHAR2(20) PRIMARY KEY,
    NO NUMBER,
    ID VARCHAR2(20),
    PASSWORD VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(15) NOT NULL,
    GENDER CHAR(3),
    AGE NUMBER,
    ENROLL_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_NO_PK PRIMARY KEY(NO, ID),
    CONSTRAINT MEMBER_GENDER_CK CHECK(GENDER IN ('남', '여')),
    CONSTRAINT MEMBER_AGE_CK CHECK(AGE >= 0)
);

INSERT INTO MEMBER 
VALUES(1, 'USER1', '1234', '홍길동', '남', '22', DEFAULT);

INSERT INTO MEMBER 
VALUES(2, 'USER2', '5678', '성춘향', '여', '22', DEFAULT);

INSERT INTO MEMBER 
VALUES(2, 'USER3', '5678', '이몽룡', '남', '22', DEFAULT);

-- 회원번호, 아이디가 동일한 값이 이미 존재하기 때문에 에러가 발생
INSERT INTO MEMBER 
VALUES(2, 'USER3', '5678', '임꺽정', '남', '30', DEFAULT);

-- 기본 키로 설정한 컬럼에 NULL 값이 있으면 에러 발생
INSERT INTO MEMBER 
VALUES(NULL, 'USER4', '5678', '임꺽정', '남', '30', DEFAULT);

INSERT INTO MEMBER 
VALUES(4, NULL, '5678', '임꺽정', '남', '30', DEFAULT);

INSERT INTO MEMBER 
VALUES(NULL, NULL, '5678', '임꺽정', '남', '30', DEFAULT);

/*
    5. FOREIGN KEY(외래 키) 제약조건
       외래 키 역할을 하는 컬럼에 부여하는 제약조건이다.
       FOREIGN KEY 제약조건은 컬럼 레벨, 테이블 레벨에서 모두 설정이 가능하다.
       
      [표현법]
        1) 컬럼 레벨
           컬럼명 자료형(크기) [CONSTRAINT 제약조건명] REFERENCES 참조할테이블명 [(컬럼명)] [삭제룰]
        
        2) 테이블 레벨
           [CONSTRAINT 제약조건명] FOREIGN KEY(컬럼명) REFERENCES 참조할테이블명 [(컬럼명)] [삭제룰]
*/ 
-- 회원 등급에 대한 데이터를 저장하는 테이블 (부모 테이블)
CREATE TABLE MEMBER_GRADE(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(20) NOT NULL
);

INSERT INTO MEMBER_GRADE VALUES (10, '일반회원');
INSERT INTO MEMBER_GRADE VALUES (20, '우수회원');
INSERT INTO MEMBER_GRADE VALUES (30, '특별회원');

-- FOREIGN KEY 제약조건을 설정한 테이블 생성
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    NO NUMBER,
    ID VARCHAR2(20) NOT NULL,
    PASSWORD VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(15) NOT NULL,
    GENDER CHAR(3),
    AGE NUMBER,
    GRADE_ID NUMBER REFERENCES MEMBER_GRADE /*(GRADE_CODE)*/,
    ENROLL_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_NO_PK PRIMARY KEY(NO),
    CONSTRAINT MEMBER_ID_UQ UNIQUE(ID),
    CONSTRAINT MEMBER_GENDER_CK CHECK(GENDER IN ('남', '여')),
    CONSTRAINT MEMBER_AGE_CK CHECK(AGE >= 0)
);

INSERT INTO MEMBER 
VALUES(1, 'USER1', '1234', '홍길동', '남', '22', 10, DEFAULT);

-- 50이라는 값이 MEMBER_GRADE 테이블에 GRADE_CODE 컬럼에서 
-- 제공하는 값이 아니므로 외래 키 제약조건에 위배되어 에러가 발생한다.
INSERT INTO MEMBER 
VALUES(2, 'USER2', '5678', '성춘향', '여', '22', 50, DEFAULT);

-- GRADE_ID 컬럼에 NULL 사용 가능
INSERT INTO MEMBER 
VALUES(2, 'USER2', '5678', '성춘향', '여', '22', NULL, DEFAULT);

-- MEMBER 테이블과 MEMBER_GRADE 테이블을 조인하여
-- ID, NAME, GRADE_NAME 조회
-- ANSI
SELECT M.ID, M.NAME, MG.GRADE_NAME
FROM MEMBER M 
LEFT OUTER JOIN MEMBER_GRADE MG ON (M.GRADE_ID = MG.GRADE_CODE);

-- 오라클
SELECT M.ID, M.NAME, MG.GRADE_NAME
FROM MEMBER M, MEMBER_GRADE MG
WHERE M.GRADE_ID = MG.GRADE_CODE(+);

-- MEMBER_GRADE 테이블에서 GRADE_CODE가 10인 데이터를 지우기
-- 자식 테이블의 행들 중에 GRADE_ID가 10인 행이 존재하기 때문에 
-- 삭제할 수 없다.
DELETE FROM MEMBER_GRADE WHERE GRADE_CODE = 10;

-- MEMBER_GRADE 테이블에서 GRADE_CODE가 30인 데이터를 지우기
-- 자식 테이블의 행들 중에 GRADE_ID가 30인 행이 존재하지 않기 때문에
-- 삭제할 수 있다.
DELETE FROM MEMBER_GRADE WHERE GRADE_CODE = 30;

ROLLBACK;

-- ON DELETE SET NULL 옵션이 추가된 자식 테이블 생성
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    NO NUMBER,
    ID VARCHAR2(20) NOT NULL,
    PASSWORD VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(15) NOT NULL,
    GENDER CHAR(3),
    AGE NUMBER,
    GRADE_ID NUMBER,
    ENROLL_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_NO_PK PRIMARY KEY(NO),
    CONSTRAINT MEMBER_ID_UQ UNIQUE(ID),
    CONSTRAINT MEMBER_GENDER_CK CHECK(GENDER IN ('남', '여')),
    CONSTRAINT MEMBER_AGE_CK CHECK(AGE >= 0),
    CONSTRAINT MEMBER_GRADE_ID_FK FOREIGN KEY(GRADE_ID) REFERENCES MEMBER_GRADE (GRADE_CODE) ON DELETE SET NULL
);

INSERT INTO MEMBER 
VALUES(1, 'USER1', '1234', '홍길동', '남', '22', 10, DEFAULT);

INSERT INTO MEMBER 
VALUES(2, 'USER2', '1234', '성춘향', '여', '22', NULL, DEFAULT);

-- MEMBER_GRADE 테이블에서 GRADE_CODE가 10인 데이터를 지우기
DELETE FROM MEMBER_GRADE WHERE GRADE_CODE = 10;

ROLLBACK;

-- ON DELETE CASCADE 옵션이 추가된 자식 테이블 생성
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    NO NUMBER,
    ID VARCHAR2(20) NOT NULL,
    PASSWORD VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(15) NOT NULL,
    GENDER CHAR(3),
    AGE NUMBER,
    GRADE_ID NUMBER,
    ENROLL_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT MEMBER_NO_PK PRIMARY KEY(NO),
    CONSTRAINT MEMBER_ID_UQ UNIQUE(ID),
    CONSTRAINT MEMBER_GENDER_CK CHECK(GENDER IN ('남', '여')),
    CONSTRAINT MEMBER_AGE_CK CHECK(AGE >= 0),
    CONSTRAINT MEMBER_GRADE_ID_FK FOREIGN KEY(GRADE_ID) REFERENCES MEMBER_GRADE (GRADE_CODE) ON DELETE CASCADE
);

INSERT INTO MEMBER 
VALUES(1, 'USER1', '1234', '홍길동', '남', '22', 10, DEFAULT);

INSERT INTO MEMBER 
VALUES(2, 'USER2', '1234', '성춘향', '여', '22', NULL, DEFAULT);

COMMIT;

-- MEMBER_GRADE 테이블에서 GRADE_CODE가 10인 데이터를 지우기
DELETE FROM MEMBER_GRADE WHERE GRADE_CODE = 10;

SELECT * FROM MEMBER_GRADE;
SELECT * FROM MEMBER;

ROLLBACK;

SELECT UC.CONSTRAINT_NAME,
       UC.TABLE_NAME,
       UCC.COLUMN_NAME,
       UC.CONSTRAINT_TYPE,
       UC.SEARCH_CONDITION
FROM USER_CONSTRAINTS UC
INNER JOIN USER_CONS_COLUMNS UCC ON (UC.CONSTRAINT_NAME = UCC.CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'MEMBER';

/*
  <SUBQUERY를 이용한 테이블 생성>
    서브 쿼리를 이용해서 SELECT의 조회 결과로 테이블을 생성하는 구문이다.
    컬럼명과 데이터 타입, 값이 복사되고, 제약조건은 NOT NULL만 복사된다.
*/
-- EMPLOYEE 테이블을 복사한 새로운 테이블 생성
-- 컬럼, 데이터 타입, 값, NOT NULL 제약조건 복사
CREATE TABLE EMP_COPY
AS SELECT *
   FROM EMPLOYEE;

SELECT * FROM EMP_COPY;

-- MEMBER 테이블을 복사한 새로운 테이블 생성
-- 컬럼, 데이터 타입, 값, NOT NULL 제약조건 복사
CREATE TABLE MEM_COPY
AS SELECT *
   FROM MEMBER;
   
SELECT * FROM MEM_COPY;

DROP TABLE EMP_COPY;
DROP TABLE MEM_COPY;

-- EMPLOYEE 테이블을 복사한 새로운 테이블 생성
-- 컬럼, 데이터 타입, NOT NULL 제약조건 복사
CREATE TABLE EMP_COPY
AS SELECT *
   FROM EMPLOYEE
   WHERE 1 = 0;

SELECT * FROM EMP_COPY;

DROP TABLE EMP_COPY;

-- EMPLOYEE 테이블에서 사번, 직원명, 급여, 연봉을 저장하는 테이블을 생성
-- SELECT 절에 산술연산 또는 함수식이 기술된 경우에는 별칭을 지정해야 한다.
CREATE TABLE EMP_COPY
AS SELECT EMP_ID AS "사번",
          EMP_NAME AS "직원명",
          SALARY AS "급여",
          SALARY * 12 AS "연봉"
   FROM EMPLOYEE;
   
SELECT * FROM EMP_COPY;

DROP TABLE EMP_COPY;

---------------------------------------------------------------------
-- 실습 문제
-- 도서관리 프로그램을 만들기 위한 테이블 만들기
-- 이때, 제약조건에 이름을 부여하고, 각 컬럼에 주석 달기

-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블(TB_PUBLISHER) 
--  1) 컬럼 : PUB_NO(출판사 번호) -- 기본 키
--           PUB_NAME(출판사명) -- NOT NULL
--           PHONE(출판사 전화번호)
CREATE TABLE TB_PUBLISHER(
    PUB_NO NUMBER CONSTRAINT TP_PUB_NO_PK PRIMARY KEY,
    PUB_NAME VARCHAR2(20) CONSTRAINT TP_PUB_NAME_NN NOT NULL,
    PHONE VARCHAR2(20)
);
COMMENT ON COLUMN TB_PUBLISHER.PUB_NO IS '출판사 번호';
COMMENT ON COLUMN TB_PUBLISHER.PUB_NAME IS '출판사명';
COMMENT ON COLUMN TB_PUBLISHER.PHONE IS '출판사 전화번호';

--  2) 3개 정도의 샘플 데이터 추가하기
INSERT INTO TB_PUBLISHER VALUES (1, '길벗', '02-123-1234');
INSERT INTO TB_PUBLISHER VALUES (2, '정아출판', '02-123-1233');
INSERT INTO TB_PUBLISHER VALUES (3, '인수출판', '02-123-1244');

SELECT * FROM TB_PUBLISHER;

-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블 (TB_BOOK)
--  1) 컬럼 : BK_NO (도서번호) -- 기본 키
--           BK_TITLE (도서명) -- NOT NULL
--           BK_AUTHOR(저자명) -- NOT NULL
--           BK_PRICE(가격)
--           BK_PUB_NO(출판사 번호) -- 외래 키(TB_PUBLISHER 테이블을 참조하도록)
--                                    이때 참조하고 있는 부모 데이터 삭제 시 자식 데이터도 삭제 되도록 옵션 지정
CREATE TABLE TB_BOOK(
    BK_NO NUMBER,
    BK_TITLE VARCHAR2(120) NOT NULL,
    BK_AUTHOR VARCHAR2(20) NOT NULL,
    BK_PRICE NUMBER,
    BK_PUB_NO NUMBER,
    CONSTRAINT BK_NO_PK PRIMARY KEY (BK_NO),
    CONSTRAINT BK_PUB_NO_FK FOREIGN KEY(BK_PUB_NO) REFERENCES TB_PUBLISHER ON DELETE CASCADE 
);

COMMENT ON COLUMN TB_BOOK.BK_NO IS '도서번호';
COMMENT ON COLUMN TB_BOOK.BK_TITLE IS '도서명';
COMMENT ON COLUMN TB_BOOK.BK_AUTHOR IS '저자명';
COMMENT ON COLUMN TB_BOOK.BK_PRICE IS '가격';
COMMENT ON COLUMN TB_BOOK.BK_PUB_NO IS '출판사 번호';

--  2) 5개 정도의 샘플 데이터 추가하기
INSERT INTO TB_BOOK VALUES(1, '도서1', '저자1', 10000, 1);
INSERT INTO TB_BOOK VALUES(2, '도서2', '저자2', 20000, 2);
INSERT INTO TB_BOOK VALUES(3, '도서3', '저자3', 30000, 3);
INSERT INTO TB_BOOK VALUES(4, '도서4', '저자4', 40000, 2);
INSERT INTO TB_BOOK VALUES(5, '도서5', '저자5', 45000, 1);
INSERT INTO TB_BOOK VALUES(6, '도서5', '저자5', 45000, 5);

SELECT * FROM TB_BOOK;

-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블 (TB_MEMBER)
--  1) 컬럼 : MEMBER_NO(회원번호) -- 기본 키
--           MEMBER_ID(아이디)   -- 중복 금지
--           MEMBER_PWD(비밀번호) -- NOT NULL
--           MEMBER_NAME(회원명) -- NOT NULL
--           GENDER(성별)        -- 'M' 또는 'F'로 입력되도록 제한
--           ADDRESS(주소)       
--           PHONE(연락처)       
--           STATUS(탈퇴 여부)     -- 기본값으로 'N' 그리고 'Y' 혹은 'N'으로 입력되도록 제약조건
--           ENROLL_DATE(가입일)  -- 기본값으로 SYSDATE, NOT NULL
CREATE TABLE TB_MEMBER(
    MEMBER_NO NUMBER,                                                       --(회원번호)  기본 키
    MEMBER_ID VARCHAR2 (40) UNIQUE ,                                        --(아이디)  중복 금지
    MEMBER_PWD VARCHAR2 (40) NOT NULL,                                      --(비밀번호) NOT NULL
    MEMBER_NAME VARCHAR2 (30) NOT NULL,                                     --(회원명) NOT NULL
    GENDER CHAR (1),                                                        --(성별)'M' 또는 'F'로 입력되도록 제한
    ADDRESS VARCHAR2 (200),                                                 --(주소)       
    PHONE VARCHAR2 (20),                                                    --(연락처)       
    STATUS CHAR (1) DEFAULT 'N',                                            --(탈퇴 여부) 기본값으로 'N' 그리고 'Y' 혹은 'N'으로 입력되도록 제약조건
    ENROLL_DATE DATE DEFAULT SYSDATE NOT NULL,                              --(가입일) 기본값으로 SYSDATE, NOT NULL
    CONSTRAINT TB_MEMBER_MEMBER_NO_PK PRIMARY KEY(MEMBER_NO),
    CONSTRAINT TB_MEMBER_GENDER_CK CHECK (GENDER IN ('M', 'F')),
    CONSTRAINT TB_MEMBER_STATUS_CK CHECK (STATUS IN ('Y', 'N'))
);

COMMENT ON TABLE  TB_MEMBER              IS '회원';
COMMENT ON COLUMN TB_MEMBER.MEMBER_NO    IS '회원번호';  -- 기본 키
COMMENT ON COLUMN TB_MEMBER.MEMBER_ID    IS '아이디';    -- 중복 금지
COMMENT ON COLUMN TB_MEMBER.MEMBER_PWD   IS '비밀번호';  -- NOT NULL
COMMENT ON COLUMN TB_MEMBER.MEMBER_NAME  IS '회원명';    -- NOT NULL
COMMENT ON COLUMN TB_MEMBER.GENDER       IS '성별';      -- 'M' 또는 'F'로 입력되도록 제한
COMMENT ON COLUMN TB_MEMBER.ADDRESS      IS '주소';
COMMENT ON COLUMN TB_MEMBER.PHONE        IS '연락처';
COMMENT ON COLUMN TB_MEMBER.STATUS       IS '탈퇴 여부'; -- 기본값으로 'N' 그리고 'Y' 혹은 'N'으로 입력되도록 제약조건
COMMENT ON COLUMN TB_MEMBER.ENROLL_DATE  IS '가입일';    -- 기본값으로 SYSDATE, NOT NULL

--  2) 3개 정도의 샘플 데이터 추가하기
INSERT INTO TB_MEMBER VALUES(1, 'ID0001', 'A1234', '김일혁', 'M', '서울 중구 남대문로 120 대일빌딩 1층', '010-0000-0000', DEFAULT, DEFAULT);
INSERT INTO TB_MEMBER VALUES(2, 'ID0002', 'B1234', '김이혁', 'M', '서울 중구 남대문로 120 대일빌딩 2층', '010-0000-0001', DEFAULT, '20231114');
INSERT INTO TB_MEMBER VALUES(3, 'ID0003', 'C1234', '김삼혁', 'F', '서울 중구 남대문로 120 대일빌딩 3층', '010-0000-0002', DEFAULT, '20231115');

-- 4. 도서를 대여한 회원에 대한 데이터를 담기 위한 대여 목록 테이블(TB_RENT)
--  1) 컬럼 : RENT_NO(대여번호) -- 기본 키
--           RENT_MEM_NO(대여 회원번호) -- 외래 키(TB_MEMBER와 참조)
--                                      이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정
--           RENT_BOOK_NO(대여 도서번호) -- 외래 키(TB_BOOK와 참조)
--                                      이때 부모 데이터 삭제 시 NULL 값이 되도록 옵션 설정
--           RENT_DATE(대여일) -- 기본값 SYSDATE
CREATE TABLE TB_RENT(
    RENT_NO NUMBER,
    RENT_MEM_NO NUMBER,
    RENT_BOOK_NO NUMBER,
    RENT_DATE DATE DEFAULT SYSDATE,
    CONSTRAINT RENT_RENT_NO_PK PRIMARY KEY(RENT_NO),
    CONSTRAINT RENT_MEM_NO_FK FOREIGN KEY(RENT_MEM_NO) REFERENCES TB_MEMBER(MEMBER_NO) ON DELETE SET NULL,
    CONSTRAINT RENT_BOOK_NO_FK FOREIGN KEY(RENT_BOOK_NO) REFERENCES TB_BOOK(BK_NO) ON DELETE SET NULL
);
COMMENT ON COLUMN TB_RENT.RENT_NO IS '대여번호';
COMMENT ON COLUMN TB_RENT.RENT_MEM_NO IS '대여 회원번호';
COMMENT ON COLUMN TB_RENT.RENT_BOOK_NO IS '대여 도서번호';
COMMENT ON COLUMN TB_RENT.RENT_DATE IS '대여일';

--  2) 샘플 데이터 3개 정도 
INSERT INTO TB_RENT
VALUES(1, 1, 2, DEFAULT);
INSERT INTO TB_RENT
VALUES(2, 1, 3, DEFAULT);
INSERT INTO TB_RENT
VALUES(3, 2, 1, DEFAULT);
INSERT INTO TB_RENT
VALUES(4, 2, 2, DEFAULT);
INSERT INTO TB_RENT
VALUES(5, 1, 5, DEFAULT);

SELECT * FROM TB_RENT;

-- 5. 2번 도서를 대여한 회원의 이름, 아이디, 대여일, 반납 예정일(대여일 + 7일)을 조회하시오.
SELECT TM.MEMBER_NAME,
       TM.MEMBER_ID,
       TR.RENT_DATE, 
       TR.RENT_DATE + 7
FROM TB_MEMBER TM
INNER JOIN TB_RENT TR ON(TM.MEMBER_NO = TR.RENT_MEM_NO)
WHERE TR.RENT_BOOK_NO = 2;

-- 6. 회원번호가 1번인 회원이 대여한 도서들의 도서명, 출판사명, 대여일, 반납 예정일(대여일 + 7일)을 조회하시오.
SELECT TB.BK_TITLE,
       TP.PUB_NAME,
       TR.RENT_DATE,
       TR.RENT_DATE + 7
FROM TB_RENT TR
INNER JOIN TB_BOOK TB ON (TR.RENT_BOOK_NO = TB.BK_NO)
INNER JOIN TB_PUBLISHER TP ON (TB.BK_PUB_NO = TP.PUB_NO)
WHERE TR.RENT_MEM_NO = 1;
----------------------------------------------------------------------------------------------------------------