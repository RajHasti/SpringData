USE [master]
GO

If not exists( select [name] from sys.tables where[name]='dbo.payment')
	CREATE TABLE dbo.payment  
	   (id int  NOT NULL identity(1,1)  , 
	   --Discriminatory column 
		pmode varchar(2) NOT NULL ,
		amount decimal(8,3) not null,
		cardnumber varchar(100) ,
		checknumber varchar(100) 
		  CONSTRAINT payment_pk PRIMARY KEY (id))
GO  

select * from dbo.payment;

drop table dbo.payment;

If not exists( select [name] from sys.tables where[name]='dbo.card')
	CREATE TABLE dbo.card  
	   (id int  NOT NULL , 
	  	amount decimal(8,3) not null,
		cardnumber varchar(100) 
		  CONSTRAINT card_pk PRIMARY KEY (id))
GO  

If not exists( select [name] from sys.tables where[name]='dbo.bankcheck')
	CREATE TABLE dbo.bankcheck  
	   (id int  NOT NULL , 
	  	amount decimal(8,3) not null,
		checknumber varchar(100) 
		  CONSTRAINT bankcheck_pk PRIMARY KEY (id))
GO  



---------Strategy - Joined

drop table dbo.payment;
drop table dbo.card;
drop table dbo.bankcheck;
If not exists( select [name] from sys.tables where[name]='dbo.payment')
	CREATE TABLE dbo.payment  
	   (id int  NOT NULL , 
	  	amount decimal(8,3) not null
		  CONSTRAINT payment_pk PRIMARY KEY (id))
GO  

If not exists( select [name] from sys.tables where[name]='dbo.card')
	CREATE TABLE dbo.card  
	   (id int  NOT NULL , 
	  	cardnumber varchar(20) not null
		  CONSTRAINT card_pk PRIMARY KEY (id))
GO  

ALTER TABLE dbo.card
  ADD CONSTRAINT FK_card_payment
    FOREIGN KEY(id) REFERENCES dbo.payment(id)
Go

If not exists( select [name] from sys.tables where[name]='dbo.bankcheck')
	CREATE TABLE dbo.bankcheck  
	   (id int  NOT NULL , 
	  	checknumber varchar(20) not null
		  CONSTRAINT bankcheck_pk PRIMARY KEY (id))
GO  

ALTER TABLE dbo.bankcheck
  ADD CONSTRAINT FK_bankcheck_payment
    FOREIGN KEY(id) REFERENCES dbo.payment(id)
Go

select * from dbo.payment;
select * from dbo.card;
select * from dbo.bankcheck;