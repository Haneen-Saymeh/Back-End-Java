
create table emp
(
eid int identity(1,1),
ename varchar(50),
address varchar(50) default 'Cairo',
hiredate date default getdate(),
salary int,
overtime int,
netsalary as(isnull(salary,0)+isnull(overtime,0)) persisted,
BD date,
age as (getdate()-year(BD)),
gender varchar(1),
hour_rate int not null,
did int,
constraint c1 primary key(eid,ename),
constraint c2 unique(salary),
constraint c3 unique(overtime),
constraint c4 check(salary>1000),
constraint c5 check(address in ('Cairo','Alex', 'Mansoura')),
constraint c6 check(gender='F' or gender='M'),
constraint c7 check(overtime between 100 and 500),
constraint c8 foreign key(did) references dept(dept_id) on delete set null on update cascade
)

create table dept 
(
dept_id int primary key,
dname varchar(50),
)

alter table emp add constraint c100 check(hour_rate >100)
alter table emp drop constraint c3

create rule r1 as @x>1000
sp_bindrule r1, 'emp.salary'
sp_bindrule r1, 'Employer.Salary'

sp_unbindrule 'emp.salary'
sp_unbindrule 'Employer.Salary'
drop rule r1

create default def1 as 5000

sp_bindefault def1, 'emp.salary'
sp_unbindefault  'emp.salary'
drop default def1


--create new data type which is integer, and >1000, default 5000

create rule r1 as @x>1000
create default def1 as 5000

sp_addtype complexDT, 'int'

sp_bindrule r1, complexDT
sp_bindefault def1, complexDT

create table table666 (
id int,
name varchar(20),
salary complexDT,
)
