CREATE database if not exists nerve_study;

use nerve_study; 

drop table if exists study;
drop table if exists nerve;

create table if not exists study(
id int(10) not null auto_increment,
name varchar(100) not null,
primary key(id)
);

create table if not exists nerve(
id int(10) not null auto_increment, 
muscle varchar(120) not null,
type varchar(120) not null,
study_id int(10) not null,
primary key(id),
foreign key(study_id) references study(id)
); 


describe nerve;