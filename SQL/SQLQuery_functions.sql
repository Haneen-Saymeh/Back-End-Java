
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
