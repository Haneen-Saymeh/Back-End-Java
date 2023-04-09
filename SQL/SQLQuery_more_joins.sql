select * from Departments

select Dname, Pname
from Departments D inner join Employee E
on D.Dnum=E.Dno
join Works_for W 
on E.SSN=W.ESSn
join Project P
on W.Pno=P.Pnumber