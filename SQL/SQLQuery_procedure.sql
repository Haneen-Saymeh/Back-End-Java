--- creating procedure
---- for security 

create proc getEmp
as 
select * from Employee

---calling the procedure
getEmp

create proc getbygender @gender varchar(1)
as 
select Fname, SSN, Salary
from Employee
where Sex=@gender

getbygender 'F'


create proc insertinto @id int, @name varchar(20)
as 
begin try
insert into Employee (SSN, Fname)
values (@id, @name)
end try

begin catch 
select 'error'
end catch

insertinto 757,'Thanos'

getEmp


create proc sumvalues @x int, @y int
as
select @x+@y

sumvalues 10,5   ---calling parameters by position x=10, y=5

sumvalues @x=6, @y=3  ---calling parameter by name


