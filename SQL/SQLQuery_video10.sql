create table something (
id int,
name varchar(20)
)

bulk insert something
from 'D:\Ejada Java Training\SQL\data.txt'
with  (fieldterminator = ',')

select * from something

---------------------------
--- creating snapshot
create Database trainingsnap
on 
(
name='training',
filename='D:\Ejada Java Training\SQL\trainingsnap.ss'
)
as snapshot of training