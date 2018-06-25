USE master;  
GO  


If not exists( select [name] from sys.tables where[name]='dbo.customer')
	CREATE TABLE dbo.customer  
	   (id int  NOT NULL ,  
		name varchar(100) NOT NULL,  
		email varchar(100) NOT NULL
	  CONSTRAINT customerid_pk PRIMARY KEY (id))
GO  

select * from customer;



