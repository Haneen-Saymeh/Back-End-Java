

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

select * from parent
insert into child values(1)
insert into child values(3)
insert into child values(5)
--- only 1 and three has been entered
select * from child

truncate table child

---- we can batch insert in child table, but rollback will undo the process
begin transaction 
insert into child values(1)
insert into child values(2)
insert into child values(3)
rollback

begin transaction 
insert into child values(1)
insert into child values(2)
insert into child values(3)
commit


--if number is right according to the super class it will work

begin try
begin transaction 
insert into child values(1)
insert into child values(2)
insert into child values(3)
commit
end try

begin catch
rollback
end catch


begin try
begin transaction 
insert into child values(1)
insert into child values(5)
insert into child values(3)
commit
end try

begin catch
rollback
end catch


truncate table child
select * from child

------------------------------------------------
--- some of built in function

select len(Fname), Fname
from Employee

select * from Employee

select top(1) Fname
from Employee
order by len(Fname) desc

---- user defined function 

create function getsname(@id int) ---function signature
returns varchar(20)
begin
declare @name varchar(20)
select @name= Fname from Employee where SSN=@id ----------body of the function
return @name
end

select dbo.getsname(666)