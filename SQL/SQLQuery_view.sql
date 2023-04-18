

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
