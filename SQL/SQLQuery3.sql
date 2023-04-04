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