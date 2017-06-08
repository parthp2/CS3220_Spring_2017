drop table if exists courses;
drop table if exists coursesmap;


create table courses (
	id			integer Not null AUTO_INCREMENT,
	cname		varchar(100) Not Null,
    term	    varchar(100) Not Null,
	letter		varchar(100) Not Null,
    num			integer Not Null,
	PRIMARY KEY ( id )
);

create table coursesmap (
    id			integer Not null AUTO_INCREMENT primary key,
	qcname		varchar(100) Not Null references  courses(cname) ,
    scname		varchar(100) Not Null references  courses(cname) 
);



select * from courses;


select * from coursesmap;