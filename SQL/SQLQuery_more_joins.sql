select * from Departments
select * from Employee

select X.Fname as employee, Y.Fname as manager
from Employee X,Employee Y 
where Y.SSN=X.superssn

select Y.Fname as manager, D.Dname
from Employee X inner join Employee Y 
on Y.SSN=X.superssn
join Departments D
on Y.Dno= D.Dnum


select Dname, Pname
from Departments D inner join Employee E
on D.Dnum=E.Dno
join Works_for W 
on E.SSN=W.ESSn
join Project P
on W.Pno=P.Pnumber


select E.Fname, D.Dependent_name, D.Sex, D.Bdate
from Employee E inner join Dependent D
on E.SSN=D.ESSN


select Pname, Plocation
from Project 
where City in ('Alex', 'Cairo')



select Pname, Pnumber, Plocation, City
from Project
where Pname like 'a%'


select E.Fname, E.Salary
from Employee E
where E.Dno=30 and E.Salary between 1000 and 2000

select E.Fname
from Employee E inner join Works_for W
on E.SSN=W.ESSn
join Project P
on W.Pno=P.Pnumber
where E.Dno=10 and W.Hours >=10 and P.Pname='Al Rabwah'

select E.Fname as employee_name
from Employee E inner join Employee M
on M.SSN=E.Superssn
where M.Fname='Kamel'

select E.Fname, P.Pname
from Employee E inner join Works_for W
on E.SSN=W.ESSn
join Project P 
on W.Pno=P.Pnumber
order by P.Pname

select distinct(M.Fname) as manager, M.Bdate,M.Salary,M.Sex,M.Dno
from Employee E inner join Employee M 
on M.SSN=E.Superssn



select E.Fname +' ' + E.Lname as full_name,E.Bdate, E.Salary, E.Salary,ISNULL(D.Dependent_name,'NO DATA'), ISNULL(D.Sex, 'NO DATA'), ISNULL(D.Bdate,0)
from Employee E left outer join Dependent D
on E.SSN=D.ESSN


select * from Project
select * from Departments

select P.Pnumber,D.Dname,M.Fname +' ' + M.Lname as manager_name, M.Address,M.Bdate, P.City, D.Dnum
from Employee E inner join Employee M 
on M.SSN=E.Superssn
join Works_for W 
on M.SSN=W.ESSn
join Project P 
on W.Pno=P.Pnumber
join Departments D 
on M.Dno=D.Dnum
where P.City='Cairo'