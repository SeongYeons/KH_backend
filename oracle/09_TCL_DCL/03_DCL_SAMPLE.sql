-- 3. SAMPLE 계정에서 테이블 생성
CREATE TABLE TEST(
    TNO NUMBER
);

SELECT * FROM TEST;
INSERT INTO TEST VALUES(1);
UPDATE TEST SET TNO = 2;
DELETE FROM TEST;
DROP TABLE TEST;

-- 5. SAMPLE 계정에서 KH 계정의 EMPLOYEE 테이블을 조회
SELECT * FROM C##KH.EMPLOYEE;

-- 6. SAMPLE 계정에서 KH 계정의 DEPARTMENT 테이블을 조회
SELECT * FROM C##KH.DEPARTMENT;

-- 7. SAMPLE 계정에서 KH 계정의 DEPARTMENT 테이블에 데이터 추가
INSERT INTO C##KH.DEPARTMENT VALUES('D0', '개발부', 'L2');

ROLLBACK;