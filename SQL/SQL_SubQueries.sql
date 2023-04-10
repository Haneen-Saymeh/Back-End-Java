
select AVG(Salary)
from Employee

select * 
from Employee

select * 
from Employee
where Salary> (select AVG(Salary) from Employee)