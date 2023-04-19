

create view Vemp
as 
select *
from Employee

select * from Vemp

create view Vdep20
as
select *
from Employee
where Dno=20

select * from Vdep20
select Fname from Vdep20

alter view Vdep20(Fname, id, gender, Dno)
as
select Fname, SSN, Sex, Dno
from Employee
where Dno=20

select * from Vdep20


create view Vdep10(Fname, id, gender, Dno)
as 
select Fname, SSN, Sex, Dno 
from Employee
where Dno=10

select * from Vdep10

create view Vall
as 
select *
from Vdep20
union all 
select *
from Vdep10

select * from Vall

create view Vjoin

as
select E.Fname, E.Salary, E.SSN, D.Dname
from Employee E inner join Departments D
on E.Dno=D.Dnum


select * from Vjoin


create view Vhours

as
select j.Fname, j.Salary,w.Hours
from Vjoin j inner join Works_for W
on j.SSN=W.ESSn

select * from Vhours


--- where is the security if we can access how it's created?
sp_helptext 'Vjoin'
--- we have to add with encryption to the process of creation

alter view Vjoin
with encryption
as
select E.Fname, E.Salary, E.SSN, D.Dname
from Employee E inner join Departments D
on E.Dno=D.Dnum
with check option


---DML 
---insert 
---- view from table

insert into Vdep20
values ('Hanz', 999, 'F', 20)

select * from Vdep20

----view from multi table
---- no delete
---- insert only effect one table

select * from Vjoin
--- this won't work, because it insert values in two tables
insert into Vjoin
values('Stark', 15000, 1515,'DP3')

---this work, same table
insert into Vjoin(Fname,  SSN)
values('vader',  1113)


select Fname,  SSN
from Vjoin
--- we can see the changes in the original table
select * from Employee

--- this take copy from the original table
create view someView 
with schemabinding
as 
select Fname, Salary, SSN
from dbo.Employee
where Salary=1500

--- changes on original table
--- we can't because the view someview depends on this field
alter table Employee alter column Fname varchar(100)


