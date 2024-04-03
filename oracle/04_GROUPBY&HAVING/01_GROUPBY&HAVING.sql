/*
  <GROUP BY>
    그룹 기준을 제시할 수 있는 구문이다.
    여러 개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용한다.
*/
-- EMPLOYEE 테이블에서 부서별 급여의 합계를 조회
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- EMPLOYEE 테이블에서 직급별 급여의 합계를 조회(단, 직급별 내림차순 정렬)
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE DESC;

-- EMPLOYEE 테이블에서 부서별 사원의 수를 조회
SELECT NVL(DEPT_CODE, '부서 없음'), COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- EMPLOYEE 테이블에서 직급별 사원의 수를 조회(단, 직급별 내림차순 정렬)
SELECT JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE DESC;

-- EMPLOYEE 테이블에서 부서별 보너스를 받는 사원의 수를 조회
SELECT NVL(DEPT_CODE, '부서 없음'), COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

SELECT NVL(DEPT_CODE, '부서 없음'), COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- EMPLOYEE 테이블에서 직급별 보너스를 받는 사원의 수를 조회(단, 직급별 내림차순 정렬)
SELECT JOB_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE DESC;

-- EMPLOYEE 테이블에서 직급별 급여의 평균을 조회
SELECT NVL(JOB_CODE,'부서 없음') AS "직급",
       TO_CHAR(ROUND(AVG(NVL(SALARY,0))),'FML999,999,999') AS "급여 평균"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- EMPLOYEE 테이블에서 부서별 사원의 수, 보너스를 받는 사원의 수,
-- 급여의 합, 평균 급여, 최고 급여, 최저 급여를 조회 (부서별 내림차순)
SELECT NVL(DEPT_CODE, '부서없음') AS "부서 코드",
       COUNT(*) AS "사원 수",
       COUNT(BONUS) AS "보너스를 받는 사원의 수",
       TO_CHAR(SUM(SALARY), '999,999,999') AS "부서별 급여의 합",
       TO_CHAR(ROUND(AVG(SALARY)), '999,999,999') AS "부서별 평균 급여",
       TO_CHAR(MAX(SALARY),'999,999,999') AS "부서별 최고 급여",
       TO_CHAR(MIN(SALARY), '999,999,999') AS "부서별 최저 급여"
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE DESC;

-- EMPLOYEE 테이블에서 성별 별 사원의 수를 조회
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남자', '2', '여자') AS "성별",
       COUNT(*) AS "사원 수"
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1)
ORDER BY "성별";

SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남자', '2', '여자', '3', '남자', '4', '여자') AS "성별",
       COUNT(*) AS "사원 수"
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남자', '2', '여자', '3', '남자', '4', '여자')
ORDER BY "성별";

-- EMPLOYEE 테이블에서 부서 코드와 직급 코드가 같은 사원의 수, 급여의 합을 조회
SELECT DEPT_CODE, JOB_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE, JOB_CODE;

/*
  <HAVING>
    그룹에 대한 조건을 제시할 때 사용하는 구문이다.
    
  <실행 순서>
    SELECT    -- 5
    FROM      -- 1
    WHERE     -- 2
    GROUP BY  -- 3
    HAVING    -- 4
    ORDER BY  -- 6
*/
-- EMPLOYEE 테이블에서 부서별로 급여가 300만원 이상인 직원의 평균 급여를 조회
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
WHERE SALARY >= 3000000
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE;

-- EMPLOYEE 테이블에서 부서별 평균 급여가 300만원 이상인 부서의
-- 부서 코드와 평균 급여를 조회
SELECT DEPT_CODE, TRUNC(AVG(NVL(SALARY, 0)), -1)
FROM EMPLOYEE
--WHERE TRUNC(AVG(NVL(SALARY, 0)), -1) >= 3000000
GROUP BY DEPT_CODE
HAVING TRUNC(AVG(NVL(SALARY, 0)), -1) >= 3000000
ORDER BY DEPT_CODE;

-- EMPLOYEE 테이블에서 직급별 총 급여의 합이 10000000 이상인
-- 직급의 직급 코드, 급여의 합을 조회
  SELECT JOB_CODE                                             AS "직급코드"
     , '￦' || LPAD(TO_CHAR(SUM(SALARY), 'FM999,999,999'),12) AS "급여"
    FROM EMPLOYEE
GROUP BY JOB_CODE
  HAVING SUM(SALARY) > 10000000
ORDER BY JOB_CODE;
       
-- EMPLOYEE 테이블에서 부서별 보너스를 받는 사원이 없는 부서의
-- 부서 코드를 조회
SELECT NVL(DEPT_CODE,'부서없음') AS "부서 코드",
       COUNT(BONUS)
FROM EMPLOYEE 
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0
ORDER BY DEPT_CODE;

/*
  <집계 함수>
*/
-- EMPLOYEE 테이블에서 직급별 급여의 합계를 조회
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
--GROUP BY DEPT_CODE
-- 마지막 행에 전체 총 급여의 합계까지 조회
--GROUP BY ROLLUP(DEPT_CODE)
GROUP BY CUBE(DEPT_CODE)
ORDER BY DEPT_CODE;

-- EMPLOYEE 테이블에서 직급 코드와 부서 코드가 같은 사원들의 급여 합계를 조회
SELECT DEPT_CODE,
       JOB_CODE,
       SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
--GROUP BY DEPT_CODE, JOB_CODE
-- ROLLUP(컬럼 1, 컬럼 2, ...) -> 컬럼 1을 가지고 중간 집계를 내는 함수
--GROUP BY ROLLUP(DEPT_CODE, JOB_CODE)
-- CUBE(컬럼 1, 컬럼 2, ...) -> 전달되는 모든 컬럼을 가지고 중간 집계를 내는 함수
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE, JOB_CODE;