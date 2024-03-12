show databases;
create database bankmanagmentsystem;
use bankmanagmentsystem;
show tables;

create table signup(formno varchar(20), name varchar(20), fname varchar(20),dob varchar(20), gender varchar(20),email varchar(30),marital varchar(20),address varchar(40),city varchar(25),state varchar(25),pincode varchar(20));
select * from signup;

create table signuptwo(formno varchar(20), religion varchar(20), category varchar(10),income varchar(15), education varchar(20),occupation varchar(20),aadhar varchar(20),pan varchar(15),SeniorCitizen varchar(25),exisitingaccount varchar(25));
select * from signuptwo;

create table signupthree(formno varchar(20), accountType varchar(40),cardnumber varchar(20),pin varchar(10),facility varchar(100));
select * from signupthree;


create table login(formno varchar(20), cardnumber varchar(40),pin varchar(10));
select * from login;


create table bank(pin varchar(10),date varchar(50),type varchar(20),amount varchar(20 ));
select * from bank;

drop table bank;
drop table login;
drop table signup;
drop table signupthree;
drop table signuptwo;