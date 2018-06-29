USE [master]
GO

select * from dbo.client;
select * from dbo.phone_number;
If not exists( select [name] from sys.tables where[name]='dbo.client')
	CREATE TABLE dbo.client  
	   (id int not null identity(1,1) , 
	   	name varchar(20) NOT NULL ,
		streetaddress varchar(30) not null,
		city varchar(20) ,
		state varchar(20) ,
		zipcode varchar(20) ,
		country varchar(20) 
		 CONSTRAINT client_pk PRIMARY KEY (id))
		
GO  

If not exists( select [name] from sys.tables where[name]='dbo.phone_number')
	CREATE TABLE dbo.phone_number  
	   (id int not null identity(1,1) , 
	   	client_id int ,
		number varchar(30) ,
		type varchar(20) 
		 CONSTRAINT phnum_pk PRIMARY KEY (id))
		
GO  

ALTER TABLE dbo.phone_number
  ADD CONSTRAINT FK_phonenumber_client
    FOREIGN KEY(client_id) REFERENCES dbo.client(id)
Go