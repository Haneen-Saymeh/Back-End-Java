

declare @x int
set @x=10
select @x

declare @x int
select @x=15
select @x

declare @x int=666
select @x

declare @x int= (select max(Salary) from Employee)
select @x

declare @x int
select @x=(select sum(Salary) from Employee)
select @x

declare @z int, @y varchar(20)
select @z=Salary, @y=Fname from Employee where SSN=666
select @z,@y

select *
from Employee


---defining a variable when the select ouput is more than one value, like an array or sth

declare @t table(x int)
insert into @t
select  Salary from Employee where Dno=30
select *  from @t


declare @t table(x int, y varchar(20))
insert into @t
select  Salary,  Fname from Employee where Dno=30
select *  from @t


---dynamic query

declare @col varchar(20)='Fname', @tab varchar(20) = 'Employee'
execute ('select '+ @col + ' from '+@tab)

execute('select * from Employee')

---------------------------------------------------------------------

---Global variable built in variables can't be declared or assigned

select @@servername
select @@version

update Employee
set Salary +=500

select @@rowcount
select @@rowcount

select * from sth
select @@error

--- show identity msg from last insert operation
select @@identity

--------------------------------------------------
---control of flow statments
--- if statment 
declare @x int
update Employee
set Salary +=300 
set @x = @@rowcount
if @x > 0
begin
select 'multi value affected'
end
else 
begin
select 'no rows affected'
end

---- if exists 
select * from sys.tables

if exists(select name from sys.tables where name = 'student')
select 'table exists'
else
create table student(
id int,
age int,
)


