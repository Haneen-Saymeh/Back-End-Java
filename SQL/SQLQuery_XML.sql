select * from Employee
for xml raw

select * from Employee
for xml raw('employee')


select * from Employee
for xml raw('employee'), elements

select * from Employee
for xml raw('employee'), elements, root

select * from Employee
for xml raw('employee'), elements, root('employess')

select * from Employee
for xml raw('employee'), elements xsinil, root('employess')

--- join problem using xml auto
select E.Fname, D.Dname
from  Employee E, Departments D
where E.Dno=D.Dnum
for xml auto, elements
--- use @ to define attribute, "" to define tags, / for nesting
select SSN "@employeeID",
Fname "EmployeeName/FirstName",
Lname "EmployeeName/LastName",
Salary "Salary"
from Employee
for xml path('employee'), root('Employee')

--- 5 steps to transfer xml to table
--- 1 declare xml variables
declare @docs xml =
'<Employee>
  <employee employeeID="666">
    <EmployeeName>
      <FirstName>Hanz</FirstName>
      <LastName>Sol</LastName>
    </EmployeeName>
    <Salary>2600</Salary>
  </employee>
  <employee employeeID="757">
    <EmployeeName>
      <FirstName>Thanos</FirstName>
    </EmployeeName>
  </employee>
  <employee employeeID="767">
    <EmployeeName>
      <FirstName>Tasha</FirstName>
    </EmployeeName>
    <Salary>3200</Salary>
  </employee>
  <employee employeeID="777">
    <EmployeeName>
      <FirstName>Hanz</FirstName>
    </EmployeeName>
  </employee>
  <employee employeeID="999">
    <EmployeeName>
      <FirstName>Hanz</FirstName>
    </EmployeeName>
  </employee>
  <employee employeeID="1515">
    <EmployeeName>
      <FirstName>Stark</FirstName>
    </EmployeeName>
    <Salary>15000</Salary>
  </employee>
  <employee employeeID="1719">
    <EmployeeName>
      <FirstName>Stark</FirstName>
    </EmployeeName>
    <Salary>15000</Salary>
  </employee>
  <employee employeeID="112233">
    <EmployeeName>
      <FirstName>Ahmed</FirstName>
      <LastName>Ali</LastName>
    </EmployeeName>
    <Salary>2360</Salary>
  </employee>
  <employee employeeID="123456">
    <EmployeeName>
      <FirstName>Hanaa</FirstName>
      <LastName>Sobhy</LastName>
    </EmployeeName>
    <Salary>1760</Salary>
  </employee>
  <employee employeeID="222020">
    <EmployeeName>
      <FirstName>darth vader</FirstName>
    </EmployeeName>
  </employee>
  <employee employeeID="223344">
    <EmployeeName>
      <FirstName>Kamel</FirstName>
      <LastName>Mohamed</LastName>
    </EmployeeName>
    <Salary>2960</Salary>
  </employee>
  <employee employeeID="321654">
    <EmployeeName>
      <FirstName>Amr</FirstName>
      <LastName>Omran</LastName>
    </EmployeeName>
    <Salary>3300</Salary>
  </employee>
  <employee employeeID="512463">
    <EmployeeName>
      <FirstName>Edward</FirstName>
      <LastName>Hanna</LastName>
    </EmployeeName>
    <Salary>2600</Salary>
  </employee>
  <employee employeeID="521634">
    <EmployeeName>
      <FirstName>Maged</FirstName>
      <LastName>Raoof</LastName>
    </EmployeeName>
    <Salary>2000</Salary>
  </employee>
  <employee employeeID="669955">
    <EmployeeName>
      <FirstName>Mariam</FirstName>
      <LastName>Adel</LastName>
    </EmployeeName>
    <Salary>1700</Salary>
  </employee>
  <employee employeeID="968574">
    <EmployeeName>
      <FirstName>Noha</FirstName>
      <LastName>Mohamed</LastName>
    </EmployeeName>
    <Salary>2720</Salary>
  </employee>
</Employee>'

--- 2 declare document handle
declare @hdocs int

---3 create memory tree
Exec sp_xml_preparedocument @hdocs output, @docs

---4 process document read tree from memory
---openxml create result set from xml document
select * into xmlemp
from OPENXML (@hdocs, '//employee')
with (EmployeeID int '@employeeID',
Salary int 'Salary',
fname varchar(20)  'EmployeeName/FirstName',
lname varchar(20) 'EmployeeName/LastName'

)

--- 5 remove memeory tree
Exec sp_xml_removedocument @hdocs

select * from xmlemp
