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

create proc mulvalues @x int=3, @y int=2
as
select @x*@y

mulvalues  --- will use the defaults
mulvalues 2 --- will only use default y, and make x =2

getEmp

create proc salaryRange @sa1 int, @sa2 int
as 
select Fname, SSN
from Employee
where Salary between @sa1 and @sa2

salaryRange 2000,3000


select * from tab1
insert into tab1(Fname, SSN)
execute salaryRange 2000,3000

--- reutrn of function return value, but for stored proceure return the behavior, we shouldn't use return
create proc getsal @id int
as 
declare @sal int
select @sal=Salary
from Employee
where SSN= @id
return @sal

declare @x int
set @x = execute getsal 666
select @x

--- we instead use output
create proc getsal2 @id int,  @sal int output
as 

select @sal=Salary
from Employee
where SSN= @id

declare @x int
execute getsal2 666, @x output
select @x


create proc getsal3 @id int,  @sal int output, @name varchar(20) output
as 

select @sal=Salary, @name=Fname
from Employee
where SSN= @id

declare @x int, @y varchar(20)
execute getsal3 666, @x output, @y output
select @x, @y
--- execute nameofanotherstoredprocedure @x, @y



--- input output using same parameter
create proc getsal5  @sal int output, @name varchar(20) output
as 

select @sal=Salary, @name=Fname
from Employee
where SSN= @sal

declare @x int=666, @y varchar(20)
execute getsal5  @x output, @y output
select @x, @y

-------------------------------------------------------------------

--- Triggers: special type of store procedures
--- can't be called
--- can't send parameter


--- table level trigger 

create trigger t1
on Employee
after insert
as select 'insetion successfull'

insert into Employee(Fname, SSN, Salary)
values ('Tasha', 767, 3200)


create trigger t2
on Employee
for update
as 
select getdate()

update  Employee
set Salary +=100


create trigger t3
on Employee
instead of delete 
as 
select 'this operation not allowed for' + SUSER_NAME()

delete from Employee
where SSN = 666

--- making table read only via  trigger

create trigger t4
on student
instead of insert, update, delete
as
select 'not allowed'

update student 
set eage +=1

--- we can drop trigger or disable it
drop trigger t4
alter table student disable trigger t4 --- only disable it

create trigger t6
on tab1
after update   ---work as updating operation
as
if update(Fname)   --- work as update function, which is check if update happen on this field then it will run select
select 'Yoo!'

update tab1
set Salary -=100

update tab1
set Fname ='Hanz'
where SSN=666

select * from tab1
--- when firing trigger, two tables are created inserted and deleted
---- on update operation inserted will have new values, and deleted old ones
---- on insertion inserted will have inserted values and delete empty
---- on delete insert is empty and delete have deleted values
create trigger t7
on tab1
after update
as
select * from inserted
select * from deleted

update  tab1
set Salary =1500

create trigger t8
on tab1
after delete
as
select * from inserted
select * from deleted

delete from tab1 where Fname='Noha'

create trigger t9
on tab1
after insert
as
select * from inserted
select * from deleted

insert into tab1 (SSN, Fname, Salary)
values (333,'Rose', 2000)

-- not allowing deletion on Friday

create trigger t10
on tab1
after delete
as 
if FORMAT(GETDATE(), 'dddd')='Friday'
begin
select 'not allowed'
-- or rollback
insert into tab1
 select * from deleted
 end

 create trigger t11
 on tab1
instead of delete  -- instead of doesn't allow delete
as 
if FORMAT(GETDATE(), 'dddd')!='Friday'
begin
delete from tab1 where SSN=(select SSN from deleted)
end


---deleted and inserted are volatile, not saved on database
--- if we want to save in our db name of user, date for update ..etc

create table history(
username varchar(20),
dateof date,
old_id int,
new_id int
)


create trigger t12
on tab1
instead of update
as 
if update(SSN)
begin
declare @old int, @new int
select @old= SSN from deleted
select @new = SSN from inserted
insert into history
values (SUSER_NAME(), GETDATE(), @old, @new)
end

update tab1
set SSN=555

select * from history

select * from tab1

select * from HR.empty_table
---- examples of run time triggers AKA output
delete from HR.empty_table
output SUSER_NAME(), deleted.Fname
where SSN=112233

update HR.empty_table
set Salary +=1000
output SUSER_NAME(), inserted.Fname
where SSN=223344







