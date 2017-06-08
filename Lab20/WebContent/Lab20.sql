drop table if exists departments;
drop table if exists faculty;

create table departments (
	id			integer Not null AUTO_INCREMENT,
	dname		varchar(100) Not Null,
	PRIMARY KEY ( id )
);

create table faculty (
	id			integer Not null AUTO_INCREMENT,
	did		    integer Not Null,
	fname		varchar(900) Not Null,
    chair		boolean Not Null,
	PRIMARY KEY ( id )
);



