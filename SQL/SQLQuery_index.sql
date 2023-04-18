--- won't work, only one clustered index for the table. it has pk clustered 
create clustered index myindex
on Employee(Fname)

create nonclustered index myindex1
on Employee(Fname)

create nonclustered index myindex2
on Employee(Lname)

--- built in indexes
--- pk ---> constraint ---> clustered index
--- unique filed ---> constraint---> non clustered index


-- this table wil have two built in index, clustered pk and non unique
create table test (
id int primary key,
name varchar(20),
age int unique
)

--- it won't work if field has duplicates
create unique index qsth
on Employee(Salary)
--- tools help us to find column that will be used for searching most, to make clustered 
--- sql server profiler
--- sql server tunin advisor



------ this is an example of local table, which is saved on tempdb
create table #exam (
id int,
name varchar(20)
)


--- global tables
create table ##exam(
idd int,
name varchar(20)
)