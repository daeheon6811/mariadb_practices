select avg(salary) from salaries where emp_no ='10060';

select avg(salary) from salaries where emp_no ='10060';

-- select 절에 그룹 함수가 있는 경우 , 어떤 컬럼도 select 절에 올 수 없다.
-- emp_no는 아무런 의미가 없다.


-- (1) from : 접근 테이블 확인
-- (2) where : 조건에 맞는 row 선택 -> 임시 테이블
-- (3) 집계
-- (4) projection


select emp_no , avg(salary)
      from salaries

      where emp_no = '10060';
      
      
select avg(salary)
from salaries
where to_date = '9999-01-01' ;

 -- group by 에 참여 하고 있는 컬럼은 projection 가능(select 절에 올 수 없다.);
select emp_no , avg(salary)
from salarie 
group by emp_no



-- 집계 결과 임시 테이블에서 로우를 선택해야 하는 경우
-- 이미 where절은 실행이 되었기 때문에 having절에서 조건을 주어야 한다.




-- order by
select emp_no , avg(salary)
from salarie 
group by emp_no
having avg(salary) > 60000


      
      