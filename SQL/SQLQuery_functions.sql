
select SUM(Salary) as total_salary
from Employee

select MIN(Salary) as min_salary, MAX(Salary) as max_salary
from Employee

select COUNT(SSN)
from Employee

select COUNT(*)
from Employee

select COUNT(Superssn)
from Employee

select AVG(Salary)
from Employee

select MIN(Salary), Sex
from Employee
group by Sex

select MAX(Salary), Dno
from Employee
group by Dno

select SUM(Salary), Dno
from Employee
group by Dno

select * from Employee

select COUNT(SSN), Sex
from Employee E
where Dno in (20,30)
group by Sex

select * from Employee

select MAX(Salary), Dno
from Employee
where Fname like 'm%'
group by Dno

select SUM(Salary), Dno
from Employee
group by Dno 
having SUM(Salary) >3000

select COUNT(SSN), Dno
from Employee
group by Dno
having COUNT(SSN)>=3

select SUM(Salary), Dno
from Employee
group by Dno 
having COUNT(SSN) >=3

select SUM(Salary), Dno
from Employee
where Fname like 'a%'
group by Dno 
having SUM(Salary) >1000

select MAX(Salary), Sex
from Employee
where Dno in (10,30)
group by Sex
having COUNT(SSN)>3

select SUM(Salary), D.Dname, D.Dnum
from Employee E inner join Departments D
on E.Dno=D.Dnum
group by D.Dnum, D.Dname


select * from Employee


select SUM(Salary), Dno 
from Employee
group by Dno

select SUM(Salary), Dno 
from Employee
where Salary>1000
group by Dno

select SUM(Salary), Dno
from Employee
group by Dno
having SUM(Salary)>3000

select SUM(Salary), Dno
from Employee
where Salary>1000
group by Dno
having SUM(Salary)>3000

select SUBSTRING(Fname,1,3)
from Employee

select *
from Employee
---first three onl, not like order by with values 
select top(3) *
from Employee

select top(3) Salary
from Employee

select top(3) Salary
from Employee
order by Salary desc


select MAX(Salary)
from Employee

select top(1) Salary
from Employee
order by Salary desc

--- with ties, also display the ties (similar) values of last one, third one in top 3, if we had another 1000, it will 
---diplay total 4
select top(3)  with ties Salary
from Employee 
order by Salary


--- newid provide new random ids, every time we run the query
select *, NEWID() as random_ids
from Employee


--- every time we run the top query, with newid. We would have new results. Because ids are random and changing.
select top(3) *
from Employee
order by NEWID()

--- the first one will run, the second one won't. because of excution order where before select
select Fname + ' ' + Lname as full_name
from Employee
order by full_name


-- how to solve this, by using subquries
select Fname+ ' '+ Lname as full_name
from Employee
where full_name ='Amr Omran'

select *
from (select Fname + ' ' + Lname as full_name from Employee) as newtable
where full_name = 'Amr Omran'

-- we can select table from another DB
select *
from training.dbo.Student

select Fname
from Employee
union All
select ename
from training.dbo.Student


---DDL using select, creating new table from values of existence table

select * into new_table
from Employee

select * 
from new_table

---we can copy table also to another database

select * into training.dbo.employee
from Employee

select *
from training.dbo.employee

select * into student
from training.dbo.Student

select *
from student

select * into tab1
from Employee
where Fname='Amr'

select *
from tab1

--copy empty table, only structure no values by using where condition that won't get matched

select * into empty_table
from Employee
where 1=2

select * 
from empty_table


select Fname
from Employee

select RIGHT(Fname,3)
from Employee

select Left(Fname,3)
from Employee
--- insert based select, copying values in an empty existing table with similar structure 
insert into empty_table
select * from Employee

select *
from Employee

insert into Employee
values('Han', 'Sol', 666, Null, 'Nablus', 'F', 1500, Null, Null)


--- Ranking functions
select *, ROW_NUMBER() over (order by Salary desc) as RN,  
DENSE_RANK() over (order by Salary desc) as DR,
NTILE(3) over (order by Salary desc) as groups,
RANK() over (order by Salary desc) as rank
from Employee

select *
from (select *, ROW_NUMBER() over (order by Salary desc) as RN  
from Employee) as new_table
where RN=1


select *
from (select *, DENSE_RANK() over (order by Salary desc) as DR  
from Employee) as new_table
where DR=4




select *, ROW_NUMBER() over (partition by Dno order by Salary desc) as RN,
DENSE_RANK() over (partition by Dno order by Salary desc) as DR
from Employee

select *
from (select *, DENSE_RANK() over (partition by Dno order by Salary desc) as DR  
from Employee) as new_table
where DR=1


update Employee 
set Dno=30
where SSN=666


select Fname + ' '+ Lname as fullName, Salary,
CASE
   when Salary >2000  then 'high salary'
   when Salary <2000 then 'low salary'
   else 'no value'
END AS  salary_status
from Employee

update Employee
set Salary=
case 
when Salary >2000 then Salary*1
else Salary*1.2
end

select Fname, iif(Salary >2000, 'high','low')
from Employee

select CAST(GETDATE() as varchar(20))

select CONVERT(varchar(20), GETDATE(),102)
select CONVERT(varchar(20), GETDATE(),103)
select CONVERT(varchar(20), GETDATE(),104)
select CONVERT(varchar(20), GETDATE(),105)

select FORMAT(GETDATE(), 'dd-MM-yyyy')
select FORMAT(GETDATE(), 'dddd MMMM yyyy')
select FORMAT(GETDATE(), 'dddd')
select FORMAT(GETDATE(), 'MMMM')
select FORMAT(GETDATE(), 'hh:mm:ss')
select FORMAT(GETDATE(), 'HH')
select FORMAT(GETDATE(), 'hh tt')


select FORMAT(eomonth(GETDATE()), 'dd')
select FORMAT(eomonth(GETDATE()), 'dddd')

create schema HR

alter schema HR transfer new_table

select * from HR.new_table

create synonym HN for HR.new_table


select * from HN




