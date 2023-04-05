

--DDL
create table Student 
(
eid int Primary Key,
ename varchar(20) not null,
eage int,
eadd varchar(20) default 'Cairo',
hiredate date default getdate(),
Dnum int,
)

alter table Student add salary int
alter table Student drop column salary
alter table Student add lName VarChar(50)

--DML
--insert/update delete
insert into Student
values (1,'han',Null,'alex',Null,Null)

--insert into many rows at same time
insert into Student(ename,eid)
values('Tony',3),('Thor',4),('capatain america',5)

insert into Student(ename,eid,eage)
values('wang',6,25),('amin',7,51),('hanin',8,18)

insert into Student(ename,eid,eage)
values('loli',9,7),('yogi',10,33)


update Student 
set ename='sth', eage=17 
where eid=1

update Student 
set lName ='last name'

update Student 
set eadd='Mansoura' 
where eid=8 

update Student 
set eadd= 'Alex'
where eid =7 


update Student
set eage +=1

delete from Student
where eid=1

update Student 
set eage=Null


--DQL data query language
select * from Student

select * from Student
order by eage

select ename + '  ' + lName as Full_Name 
from Student

select *
from Student
where ename is not null and lName is not null

select distinct ename
from Student

select * 
from Student 
where eadd in ('Mansoura', 'Alex')

select *
from Student
where eadd= 'Mansoura' and eage >=18

select * 
from Student
where eage between 18 and 40