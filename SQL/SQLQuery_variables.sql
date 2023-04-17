

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

--- try and catch

begin try
delete from Departments where Dnum=30
end try

begin catch
select 'error'
select ERROR_LINE(), ERROR_NUMBER(),  ERROR_MESSAGE()
end catch


--- while loop//// breeak and continue leave the while lopp
declare @x int =10
while @x<=20
begin
set @x +=1
if @x =14
continue 
if @x=16
break
select @x
end

create table parent(pid int primary key)
create table child(cid int foreign key references
parent(pid))

insert into parent values(1)
insert into parent values(2)
insert into parent values(3)


