USE master;  
GO  

--Delete the TestData database if it exists.  
IF EXISTS(SELECT * from sys.databases WHERE name='mydb')  
BEGIN  
    DROP DATABASE mydb;  
END  

--Create a new database called TestData.  
CREATE DATABASE mydb; 

USE mydb;  
If not exists( select [name] from sys.tables where[name]='dbo.product')
	CREATE TABLE dbo.product  
	   (id int  NOT NULL ,  
		name varchar(100) NOT NULL,  
		description varchar(100) NOT NULL,
		price decimal(8,3)
	  CONSTRAINT users_pk PRIMARY KEY (id))
GO  

select * from product;



