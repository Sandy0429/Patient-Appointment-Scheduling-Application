use mydb;

create table patient(
	id int primary key auto_increment,
    first_name varchar(20),
    last_name varchar(30),
    phone varchar(30),
    provider_name varchar(30),
    copay decimal(10.5)
);

create table doctor(
	id int primary key auto_increment,
    first_name varchar(20),
    last_name varchar(30),
    speciality varchar(30)
);

create table patients_doctors(
	patient_id int,
    doctor_id int,
    foreign key(patient_id)references patient(id),
    foreign key(doctor_id)references doctor(id)
);

create table appointment(
	id int primary key auto_increment,
    patient_id int,
    doctor_id int,
    appointment_time datetime,
    started tinyint(1),
    ended tinyint(1),
    reason varchar(200),
    foreign key(patient_id)references patient(id),
    foreign key(doctor_id)references doctor(id)
);

select * from patient;
select * from doctor;
select * from patients_doctors;
select * from appointment;
