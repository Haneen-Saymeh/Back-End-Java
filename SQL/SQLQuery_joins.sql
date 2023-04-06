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

