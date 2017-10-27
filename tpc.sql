Create table Student(
  sid varchar(10) primary key,
  sname varchar(20) not null,
  spassword varchar(10) not null,
  sEmailId varchar(40),
  cpi decimal(4,2) not null,
  placementStatus int not null,
  placedCompany varchar(20),
  salary decimal(4,2)
);

Create table TechStudent(
  sid varchar(10) primary key,
  interest varchar(50),
  branch varchar(10) not null,
  Constraint fk_sidt Foreign key(sid) references Student(sid)
);

Create table NonTechStudent(
  sid varchar(10) primary key,
  interest varchar(50),
  Constraint fk_sidn Foreign key(sid) references Student(sid)
);

Create table Company(
  cIN int primary key,
  cname varchar(20) not null unique,
  cEmailId varchar(40),
  cpiCriteria decimal(4,2) not null,
  city varchar(20),
  visitDate date,
  salary decimal(4,2) not null
);

Create table TechCompany(
  cIN int primary key,
  branch varchar(10) not null,
  requirements varchar(50),
  Constraint fk_cidt Foreign key(cIN) references Company(cIN)
);

Create table NonTechCompany(
  cIN int primary key,
  requirements varchar(50),
  Constraint fk_cidn Foreign key(cIN) references Company(cIN)
);

Create table CellMember(
  cid varchar(10) primary key,
  cname varchar(20) not null,
  cpassword varchar(10) not null,
  cEmailId varchar(40),
  ContactNumber varchar(15) unique,
  year char(3),
  gender char(1),
  category varchar(40)
);

create table TPO(
  tid varchar(10) primary key,
  tname varchar(20),
  tpassword varchar(20),
  sdate date,
  edate date 
);



insert into Student values("15UCS072","Meetasha","m","m@gmail.com",10,0,null,0);
insert into Student values("15UCS017","Aman","a","a@gmail.com",9.3,0,null,0);
insert into Student values("15UCS144","Sukrati","s","s@gmail.com",9.56,0,null,0);
insert into Student values("15UCS084","Rohan","r","r@gmail.com",8.3,0,null,0);
insert into Student values("15UCS000","Dhairya","d","d@gmail.com",7.34,0,null,0);
insert into Student values("15UCS083","Nidhi","n","n@gmail.com",6.21,0,null,0);
insert into Student values("15UCS150","Vidushi","v","v@gmail.com",3.5,0,null,0);

insert into TechStudent values("15UCS072","Backend","cse");
insert into TechStudent values("15UCS017","frontend","cse");
insert into TechStudent values("15UCS144","Android","cce");
insert into TechStudent values("15UCS150","Image processing","ece");

insert into NonTechStudent values("15UCS083","Drama");
insert into NonTechStudent values("15UCS000","Content");
insert into NonTechStudent values("15UCS084","Management");

Insert into Company values(1,"Google","g@gmail.com",8.5,"Delhi",2017-04-29,25);
Insert into Company values(2,"Amazon","a@gmail.com",7,"Gurgaon",2017-05-29,19);
Insert into Company values(3,"Flipkart","f@gmail.com",5.0,"Banglore",2017-04-13,15);
Insert into Company values(4,"Yahoo","y@gmail.com",9.0,"Banglore",2017-03-13,5);
Insert into Company values(5,"TOI","t@gmail.com",5,"Pune",2017-05-23,9);
Insert into Company values(6,"Jaipur Drama Club","j@gmail.com",5,"Jaipur",2017-03-17,6);
Insert into Company values(7,"TATA","tata@gmail.com",5,"Kolkata",2017-03-01,8);

Insert into TechCompany values(1,"cse","Backend");
Insert into TechCompany values(2,"cse","frontend");
Insert into TechCompany values(3,"cse","Android");
Insert into TechCompany values(4,"ece","Image processing");

Insert into NonTechCompany values(5,"Content");
Insert into NonTechCompany values(6,"Drama");
Insert into NonTechCompany values(7,"Management");

Insert into CellMember values("15UCS001","aarshi","ar","ar@gmail.com",908762738,"y15","F","Students stats manager");
Insert into CellMember values("15UCS034","Harsh","hr","hr@gmail.com",9272758373,"y15","M","Company stats manager");
Insert into CellMember values("16ucc098","Sumit","su","su@gmail.com",9873623432,"y16","M","Company stats manager");

insert into TPO values("T1","Manuj","m",2016-04-23,null);









