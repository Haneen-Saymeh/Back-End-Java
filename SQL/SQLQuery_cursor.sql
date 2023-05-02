declare c1 cursor
for select SSN, Fname
    from Employee
    where Sex ='M'
for read only     --- or update

declare @id int, @name varchar(20)
open c1 
fetch c1 into @id, @name

while @@FETCH_STATUS=0
begin
select @id, @name
fetch c1 into @id, @name
end

close c1
deallocate c1

---------------------------------------------------------
declare c1 cursor
for select Fname
    from Employee
for read only

declare @name varchar(20), @allnames varchar(500) = ' '
open c1
fetch c1 into @name

while @@FETCH_STATUS=0
begin
set  @allnames = concat(@allnames, ',' , @name)
fetch c1 into @name
end
select @allnames
close c1
deallocate c1
------------------------------------------------
--- for update
declare c1 cursor
for select Salary
    from Employee
    where Salary is not null
for update

declare @sal int
open c1
fetch c1 into @sal

while @@FETCH_STATUS=0
begin
   if @sal >=3000
   update Employee        
      set Salary =@sal *1.20
	  where current of c1
   else
   update Employee
   set Salary = @sal*1.10
   where current of c1
fetch c1 into @sal    -------- ===> to avoid infinit loop, like ++
end
close c1
deallocate c1
------------------------------------------------------------------------

declare c1 cursor
for select Fname
    from Employee
	order by Fname
for read only

declare @name varchar(20), @counter int=0, @flag int=0
open c1
fetch c1 into @name

while @@FETCH_STATUS=0
begin
       if @name = 'Ahmed'
	   begin
	   set @flag =1
	   end

	   if @name = 'Stark'
	   begin 
	     if @flag =1
	       begin 
		  set @counter +=1
		  set @flag=0
	       end
	   end
fetch c1 into @name
end
select @counter
close c1
deallocate c1

