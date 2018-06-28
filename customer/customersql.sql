USE master;  
GO  


If not exists( select [name] from sys.tables where[name]='dbo.customer')
	CREATE TABLE dbo.customer  
	   (id int  NOT NULL IDENTITY(1,1) ,  
		name varchar(100) NOT NULL,  
		email varchar(100) NOT NULL
	  CONSTRAINT customerid_pk PRIMARY KEY (id))
GO  

select * from customer;
 select
        count(*) as col_0_0_ 
    from
        customer customer0_

	use master	

ALTER TABLE dbo.customer
  ADD streetaddress varchar(30),
		city varchar(20) ,
		state varchar(20) ,
		zipcode varchar(20) ,
		country varchar(20) ;

	go



