select * from Employee

select Fname, Lname, Salary, Dno 
from Employee

select Pname, Plocation, Dnum
from Project


select Fname+ ' ' + Lname as full_name, Salary*.01 as annaul_com
from Employee

select Fname +' '+Lname as Full_name 
from Employee
where Salary >1000

select Fname +' '+Lname as Full_name, Salary*12 
from Employee

select Fname +' '+Lname as Full_name, Salary*12 
from Employee
where Salary *12>10000

select Fname +' ' + Lname as full_name, Salary
From Employee
where Sex ='F'

select * from Departments

select Dname from Departments
where MGRSSN=968574

select * from Project

select Pname, Plocation
from Project
where Dnum=10


