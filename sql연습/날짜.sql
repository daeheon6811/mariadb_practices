
select emp_no , lpad(salaries , 10 , ' ') as 'salary'
from salaries
where from_date like '2001-%';


select  trim ,ltrim , rtrim
concat('',ltrim(' hello ' )), '---' ) ltrim,


-- 절대값
select abs(-1) , abs(1);

-- 나머지값
select mod(10,3);

-- floor(x) : x 보다 크지 않은 가장 큰 정수를 반환

select floor(3.14);
select ceiling(3.14);
select ceil(3.14);

select round(1.298) , round(1.298 , 1), round(1.298 , 0);


select pow(2, 10) , power(10,3);
select sign(2) , sign(-2), sign(0);

select greatest(10,40,20,30), least(10,40,20,30);

select CURDATE(), CURRENT_dATE;

select CURTIME(), CURRENT_TIME;
 SDF
select now() , sleep(2) , sysdate();
select sysdate() ,sleep(2) ,sysdata();



select now();


select first_name , period_diff(data_format(curdate(),'%Y%m') , data_format(hire_date,'%Y%m'))
from employees;

-- cast
select cast('20210-05-07' as date) + 10;
select cast('20210-05-07' as date);
 -- mysql type
 -- varchar,char,text
 -- int(integer), medium int , big int , int(11)
 -- float , double
 

select first_name,
       hire_date
       date_add(hire_date interval 5 year)
	from employees;
    
    
    
select cast(cast(1-2 as unsigned)as signed);































select * from salaries;