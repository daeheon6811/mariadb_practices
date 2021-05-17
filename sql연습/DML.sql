select * from pet;

SET SQL_SAFE_UPDATES = 0;


drop table pet;

create table pet(
name varchar(20),
owner varchar(20),
species varchar(20),
gender char(1),
birth date,
death date
);

desc pet;

select * from pet;

-- 데이터 넣기 
insert into pet values ("똥개","박대헌","dog","m","2018-12-25",null);

-- 데이터 삭제(delete)
delete from pet where name ="똥개"; 

-- 조회 연습1

-- 1990년 이후에 태어난 아이들은?
select * from pete where birth > '1990-12-31';


-- gwn과 함계 사는 아이들은? 
select * from pet where owner ='gwen';

-- 조회 연습: order by

-- 어린순으로 정렬하고 생일이 같으면 이름순으로 다시 정렬
select * from pet order by birth desc;

select * from pet where death is null;


select * from pet where death is not null




 
 





 
