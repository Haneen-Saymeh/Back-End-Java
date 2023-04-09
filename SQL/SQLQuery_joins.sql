select Fname, Dname 
from Employee, Departments
where Employee.Dno=Departments.Dnum

select Fname,Dname
from Employee E inner join Departments D 
on E.Dno=D.Dnum

select Fname,Dname
from Employee E inner join Departments D 
on E.Dno=D.Dnum
where E.Sex='F'

select Fname,Dname
from Employee E inner join Departments D 
on E.Dno=D.Dnum
where E.Salary >=1300

select Fname,Dname
from Employee E left outer join Departments D
on E.Dno=D.Dnum

select Fname,Dname
from Employee E right outer join Departments D
on E.Dno=D.Dnum

--self join employee and managers 
--- we identify table X as original table in our database. which it has the employee, and is a child table, has the forign key superssn
-- Y table is imaginary table that is the parent table which it has the managers, which has the primary key SSN
select X.Fname as employee, Y.Fname as manager
from Employee X,Employee Y 
where Y.SSN=X.superssn


-- multiple tables join---> 3 tables
select E.Fname, P.Pname, W.Hours
from Employee E, Project P, Works_for W
where E.SSN=W.ESSn and W.Pno=P.Pnumber

select Fname, Pname, Hours
from Employee E  inner join Works_for W
on E.SSN=W.ESSn
inner join Project P
on W.Pno=P.Pnumber


select Fname, Pname, Hours
from Employee E  inner join Works_for W
on E.SSN=W.ESSn
inner join Project P
on W.Pno=P.Pnumber
where W.Hours >=15

select Fname+' '+ Lname as Full_name, Pname, Hours
from Employee E inner join Works_for W
on E.SSN=W.ESSn
inner join Project P 
on W.Pno=P.Pnumber
where E.Sex='M' and W.Hours >10

update Works_for
set Hours+=5
from Employee E inner join Works_for W
on E.SSN=W.ESSn


-- replace null 
select ISNULL(Dno, '')
from Employee

select ISNULL(Fname, Lname)
from Employee


---- multiple option, if first name doesn't exist, show last name. if last name doesn't exsit show address, if not show no data
select Coalesce(Fname, Lname, Address, 'No data')
from Employee


---concatinate two columns of different data type 
select Fname+' '+ CONVERT(varchar(50),Salary)
from Employee

--if one value is null the concatination will be null
select ISNULL(Fname,' ') + ' ' + ISNULL(CONVERT(varchar(50),Salary),0)
from Employee

--the above function has alot of functions inside which will effect performance, we can do the function below instead
-- concat transfer everything to string and replace null values with empty string
select CONCAT(Fname, ' ', Salary)
from Employee



---end with a
select *
from Employee
where Fname like '%a'

---start with a
select *
from Employee
where Fname like 'a%'

---a anywhere
select *
from Employee
where Fname like '%a%'

--a is second
select *
from Employee
where Fname like '_a%'


---order by first select choice
select Fname, Lname,Salary
from Employee
order by 1

select Fname, Lname,Salary
from Employee
order by 3

select Fname, Lname,Salary
from Employee
order by 3 desc

select Fname, Lname,Salary
from Employee
order by Fname,Salary desc

select Fname, Dname
from Employee E inner join Departments D
on E.Superssn=D.MGRSSN



