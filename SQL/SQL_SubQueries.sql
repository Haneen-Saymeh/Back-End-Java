
select AVG(Salary)
from Employee

select * 
from Employee

select * 
from Employee
where Salary> (select AVG(Salary) from Employee)

select *, (select COUNT(SSN) from Employee) as total_number
from Employee


select Dname 
from Departments
where Dnum in (select Dno from Employee where Dno is not null)

--its faster to use join tho
select distinct Dname
from Departments D inner join Employee E
on D.Dnum=E.Dno

select * from Departments
select * from Project

select Dname 
from Departments
where Dnum in (select Dnum from Project where City ='Cairo')

--------Union Family

select Fname as names from Employee 
Union All 
select Pname from Project

select Fname as names from Employee 
Union All 
select Dname from Departments

select Fname as names from Employee 
Union 
select Pname from Project

select * from Employee
select * from Departments

select SSN as ids from Employee 
Union All 
select MGRSSN from Departments

select SSN as ids from Employee 
Union  
select MGRSSN from Departments

select SSN as ids from Employee 
intersect  
select MGRSSN from Departments

select SSN as ids from Employee 
except 
select MGRSSN from Departments

select MGRSSN from Departments
except 
select SSN as ids from Employee 

select MGRSSN from Departments
intersect 
select SSN as ids from Employee


