drop table if exists users;
drop table if exists files;
drop table if exists shares;
drop view if exists UserFile;

create table users (
	uid			integer Not null AUTO_INCREMENT,
	uname		varchar(100) Not Null,
	pass		varchar(100) Not Null,
	PRIMARY KEY ( uid )
);

create table files (
    id			integer Not null AUTO_INCREMENT primary key,
	uid			integer not null references  users(uid) ,
    name		varchar(900) Not Null,
	type		varchar(900) Not Null,
	size		mediumint Not Null,
    date 		timestamp default current_timestamp,
    parent		integer references files(id),
    folder 		boolean not null
);

create view UserFile As select users.uid,users.uname,files.id,files.name,files.type,files.size,files.date,files.parent 
from users inner join files on users.uid=files.uid where folder=false;


create table shares (
    id			integer Not null AUTO_INCREMENT primary key,
	oid			integer not null references  users(uid) ,
    fid			integer not null references  files(id),
    sid			integer not null references users(uid),
    name		varchar(900) Not Null,
	size		mediumint Not Null,
    date 		timestamp default current_timestamp
);

select * from users;

select * from files;

select * from shares;

select * from UserFile;

insert into users (uname,pass) values ('cysun', 'abcd');
-- insert into files (uid,name,type,size,folder) values (1,'doc', 'abcd',5,true);


