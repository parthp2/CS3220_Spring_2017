drop table if exists contact;
drop table if exists field;

create table contact (
	id			integer Not null AUTO_INCREMENT,
	name		varchar(100) Not Null,
	contact		varchar(100) Not Null,
    letter 		varchar(100) Not Null,
	PRIMARY KEY ( id )
);

create table field (
    id			integer Not null AUTO_INCREMENT primary key,
	uid			integer not null references  users(uid) ,
    fname		varchar(900) Not Null,
	fvalue		varchar(900) Not Null
);