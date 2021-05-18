-- 문제 1. 
-- 현재 급여가 많은 직원부터 직원의 사번, 이름, 그리고 연봉을 출력 하시오.

SELECT e.first_name , s.salary FROM employees e, salaries s
WHERE 1 = 1
AND e.emp_no = s.emp_no
ORDER BY s.salary desc;


-- 문제2.
-- 전체 사원의 사번, 이름, 현재 직책을 이름 순서로 출력하세요.


SELECT e.emp_no , e.first_name, t.title FROM employees e, titles t
WHERE 1 = 1
AND e.emp_no = t.emp_no
AND t.to_date = '9999-01-01'
ORDER BY t.title asc;

-- 문제3.
-- 전체 사원의 사번, 이름, 현재 부서를 이름 순서로 출력하세요..

SELECT  e.emp_no , e.first_name , dn.dept_no
FROM dept_emp dn, employees e
WHERE 1 = 1
AND e.emp_no = dn.emp_no
AND dn.to_date = '9999-01-01'
order by dn.dept_no asc;

-- 문제4.
-- 전체 사원의 사번, 이름, 연봉, 직책, 부서를 모두 이름 순서로 출력합니다.

SELECT  e.emp_no , e.first_name , dn.dept_no , t.title
FROM dept_emp dn, employees e , salaries s , titles t
WHERE 1 = 1
AND e.emp_no = dn.emp_no
AND dn.emp_no = s.emp_no
AND e.emp_no = dn.emp_no
AND t.to_date = '9999-01-01'
AND s.to_date = '9999-01-01'
AND dn.to_date = '9999-01-01'
order by dn.dept_no , s.salary , t.title asc;  
 

-- 문제5.
-- ‘Technique Leader’의 직책으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 출력하세요
-- (현재 ‘Technique Leader’의 직책(으로 근무하는 사원은 고려하지 않습니다.) 이름은 first_name과 last_name을 합쳐 출력 합니다.

SELECT e.emp_no , concat(e.first_name, " ", e.last_name) 
FROM
employees e , titles t
WHERE t.title = 'Technique Leader';
 

-- 문제6.
-- 직원 이름(last_name) 중에서 S(대문자)로 시작하는 직원들의 이름, 부서명, 직책을 조회하세요.

SELECT e.first_name , e.last_name , dn.dept_no , t.title
FROM
employees e,
dept_emp dn,
titles t
WHERE 1 = 1
AND e.emp_no = dn.emp_no
AND dn.emp_no = t.emp_no
AND e.emp_no = dn.emp_no
AND e.last_name Like "%S";

-- 문제7.
-- 현재, 직책이 Engineer인 사원 중에서 현재 급여가 40000 이상인 사원을 급여가 큰 순서대로 출력하세요.

SELECT e.first_name , e.last_name , t.title
FROM
employees e,
salaries s,
titles t
WHERE 1 = 1
AND e.emp_no = t.emp_no
AND s.emp_no = t.emp_no
AND e.emp_no = s.emp_no
AND t.title = 'Engineer'
AND s.salary > 40000
ORDER BY s.salary DESC;



-- 문제8.
-- 현재 급여가 50000이 넘는 직책을 직책, 급여로 급여가 큰 순서대로 출력하시오

SELECT t.title, (s.salary) as avgsal , t.title
FROM
salaries s,
titles t
WHERE 1 = 1
AND s.emp_no = t.emp_no
group by t.title
HAVING AVG(avgsal) > 50000
ORDER BY avgsal DESC
limit 0,50;


-- 문제9.
-- 현재, 부서별 평균 연봉을 연봉이 큰 부서 순서대로 출력하세요.

SELECT d.dept_no , AVG(s.salary) 
FROM 
salaries s ,
dept_emp d
WHERE 1 = 1
AND s.emp_no = d.emp_no
GROUP BY d.dept_no;



-- 문제10.
-- 현재, 직책별 평균 연봉을 연봉이 큰 직책 순서대로 출력하세요.

SELECT t.title , AVG(s.salary) 
FROM 
salaries s ,
titles t
WHERE 1 = 1
AND s.emp_no = t.emp_no
GROUP BY t.title


