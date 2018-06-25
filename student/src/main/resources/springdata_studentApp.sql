USE [master]
GO


If not exists( select [name] from sys.tables where[name]='dbo.student')
	CREATE TABLE dbo.student  
	   (id int  NOT NULL identity(1,1)  ,  
		lname varchar(100) NOT NULL ,
		fname varchar(100) not null,
		score int not null
		  CONSTRAINT student_pk PRIMARY KEY (id))
GO  

SELECT TOP 1000 [id]
      ,[lname]
      ,[fname]
      ,[score]
  FROM [master].[dbo].[student];