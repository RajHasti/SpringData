USE [master]
GO

select * from dbo.patient;
select * from dbo.doctor;
select * from dbo.patients_doctors;
select * from dbo.appointment;
If not exists( select [name] from sys.tables where[name]='dbo.patient')
	CREATE TABLE dbo.patient  
	   (id int not null identity(1,1) , 
	   	first_name varchar(20) NOT NULL ,
		last_name varchar(20) NOT NULL ,
		streetaddress varchar(30) not null,
		city varchar(20) ,
		state varchar(20) ,
		zipcode varchar(20) ,
		country varchar(20) 
		 CONSTRAINT patient_pk PRIMARY KEY (id))
		
GO  

If not exists( select [name] from sys.tables where[name]='dbo.doctor')
	CREATE TABLE dbo.doctor  
	   (	
	    id int not null identity(1,1) ,
	    first_name varchar(20) NOT NULL ,
		last_name varchar(20) NOT NULL ,
		streetaddress varchar(30) not null,
		city varchar(20) ,
		state varchar(20) ,
		zipcode varchar(20) ,
		country varchar(20),
		speciality varchar(30)
		 CONSTRAINT doctor_pk PRIMARY KEY (id))
		
GO  

If not exists( select [name] from sys.tables where[name]='dbo.patients_doctors')
	CREATE TABLE dbo.patients_doctors  
	   (	
	    patient_id int  ,
	    doctor_id int )
		
GO  
ALTER TABLE dbo.patients_doctors
  ADD CONSTRAINT FK_patientID_patient
    FOREIGN KEY(patient_id) REFERENCES dbo.patient(id)
Go
ALTER TABLE dbo.patients_doctors
  ADD CONSTRAINT FK_doctorID_patient
    FOREIGN KEY(doctor_id) REFERENCES dbo.doctor(id)
Go

If not exists( select [name] from sys.tables where[name]='dbo.appointment')
	CREATE TABLE dbo.appointment  
	   (	
	    id int not null identity(1,1) ,
	    patient_id int,
		doctor_id int,
		appointment_time datetime,
		started tinyint,
		ended tinyint,
		reason varchar(200)
		CONSTRAINT appointment_pk PRIMARY KEY (id))
		
GO 

ALTER TABLE dbo.appointment
  ADD CONSTRAINT FK_patientID_appointment
    FOREIGN KEY(patient_id) REFERENCES dbo.patient(id)
Go
ALTER TABLE dbo.appointment
  ADD CONSTRAINT FK_doctorID_appointment
    FOREIGN KEY(doctor_id) REFERENCES dbo.doctor(id)
Go

ALTER TABLE dbo.patient 
ADD  phone varchar(30),provider_name varchar(30),copay decimal(10,5);


drop table dbo.patient;
drop table dbo.doctor;
drop table dbo.patients_doctors;
drop table dbo.appointment;


