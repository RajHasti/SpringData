If not exists( select [name] from sys.tables where[name]='dbo.bankaccount')
	CREATE TABLE dbo.bankaccount  
	   (acctno int not null identity(1,1) , 
	   	lastname varchar(20) ,
		firstname varchar(20) ,
		bal int
		 CONSTRAINT bankaccount_pk PRIMARY KEY (acctno))
		
GO  

select * from dbo.bankaccount;

insert into dbo.bankaccount values ('Rajini','Konduru',2000);
GO