-- 서브쿼리(SUBQUERY) SQL 문제입니다.

-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?

   SELECT count(*) FROM ( SELECT AVG(S.salary) as avgsal
   FROM salaries S
   WHERE  S.to_date ='9999-01-01') A , salaries s
   WHERE s.salary > A.avgsal;
 

-- 문제2. 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 



SELECT e.emp_no , e.first_name , A.maxdept 
FROM 
( select d.emp_no as emp_no, d.dept_no , MAX(s.salary) as maxdept
 FROM dept_emp d , salaries s
 WHERE 1 = 1 
 and d.emp_no = s.emp_no
 and d.to_date = '9999-01-01'
 and s.to_date = '9999-01-01'
 Group by d.dept_no) A,
 employees e
 WHERE 1 = 1
 AND A.emp_no = e.emp_no;

-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 


SELECT e.emp_no , e.first_name , s.salary
FROM employees e , salaries s 
 WHERE 1 = 1
 AND e.emp_no = s.emp_no
 AND s.salary > ANY (SELECT d.emp_no as emp_no , d.dept_no , AVG(s.salary) as avgsal
FROM dept_emp d , salaries s
WHERE 1 = 1
AND d.emp_no = s.emp_no
and d.to_date = '9999-01-01'
and s.to_date = '9999-01-01'
 Group by d.dept_no);
 
 
 
 
 SELECT AVG(salary) FROM salaries; 


-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.

SELECT e.emp_no , e.first_name ,  d.dept_name
FROM departments d , dept_emp de ,  employees e
where 1 = 1
AND e.emp_no = de.emp_no
AND de.dept_no = d.dept_no;



-- 문제5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.




-- 문제6.
-- 평균 연봉이 가장 높은 부서는? 

-- 문제7.
-- 평균 연봉이 가장 높은 직책?

-- 문제8.
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.

