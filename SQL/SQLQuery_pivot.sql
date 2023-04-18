create table sales (
productid int,
salesman varchar(10),
quantity int
)

insert into sales 
values (1, 'ahmad', 10),
(2, 'hanin', 15),
(2, 'han', 21),
(2, 'hanz', 17),
(3, 'amin', 15),
(3, 'eid', 50),
(4, 'mohamed', 20),
(4, 'lola', 90),
(5, 'tony', 25),
(6, 'thor', 30)

select * from sales

select productid as X, sum(quantity) as quantities
from sales
group by productid

--- we want to have 5th row with total of all 
select productid as X, sum(quantity) as quantities
from sales
group by productid
union all 
select 0, sum(quantity)
from sales

---- instead we can use rollup
--- rollup ===> group by + apply same aggregate function on the result of the first query
select productid as X, sum(quantity) as quantities
from sales
group by rollup(productid)


select salesman as name, sum(quantity) as quantities
from sales
group by rollup(salesman)

select salesman as name, avg(quantity) as quantities
from sales
group by rollup(salesman)

insert into sales 
values (7,'han',5),
(5,'amin',7)


insert into sales 
values 
(5,'amin',15)


select productid, salesman, sum(quantity) as quantities
from sales
group by productid,salesman

---only apply it on the first field, productid

select productid, salesman, sum(quantity) as quantities
from sales
group by rollup(productid,salesman)

--- we want roll up on both field, we use cube

--- for each product, for each salesman, total and 
select productid, salesman, sum(quantity) as quantities
from sales
group by cube(salesman,productid)


select productid, salesman, sum(quantity) as quantities
from sales
group by grouping sets(salesman,productid)
order by salesman


select *
from sales 
pivot (sum(quantity) for salesman in ([hanin],[tony],[han])) as PVT