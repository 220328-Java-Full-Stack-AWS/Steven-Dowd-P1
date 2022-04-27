drop table if exists ers_users;

create table if not exists ers_users (
	ers_users_id serial primary key,
	ers_username varchar(50) unique,
	ers_password varchar(50),
	user_first_name varchar(50),
	user_last_name varchar (50),
	user_email varchar(50) unique,
	user_role_id int,
	constraint user_roles_fk foreign key (user_role_id) references ers_user_roles (ers_user_role_id)
);
select * from ers_users;

UPDATE ers_users SET ers_username = 'tbot', ers_password = 'pass', user_first_name = 'bob', user_last_name = 'tex', user_email = 'tbob@aol.com', user_role_id = 1 WHERE ers_users_id = 12


delete from ers_users where ers_users_id = 2;

insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values ('sdowd', 'pass','Steven','Dowd','sdowd@gmail.com',2);
insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values ('test', 'pass','Test','Case','test@gmail.com',1);

drop table if exists ers_reimb;

create table if not exists ers_reimb (
	reimb_id serial primary key,
	reimb_amount decimal(8,2),
	reimb_submitted timestamp,
	reimb_resolved timestamp,
	reimb_description varchar(250),
	reimb_author int,
	reimb_resolver int,
	reimb_status_id int,
	reimb_type_id int,
	constraint ers_users_fk_auth foreign key (reimb_author) references ers_users (ers_users_id),
	constraint ers_users_fk_reslvr foreign key (reimb_resolver) references ers_users (ers_users_id),
	constraint ers_reimb_status_fk foreign key (reimb_status_id) references ers_reimb_status (reimb_status_id),
	constraint ers_reimb_type_fk foreign key (reimb_type_id) references ers_reimb_type (reimb_type_id)
);

insert into ers_reimb (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) values (99.99, now(), 'test', 2,1,1);

select * from ers_reimb;
delete from ers_reimb where reimb_id = 3;

drop table ers_reimb_type;
create table if not exists ers_user_roles (
	ers_user_role_id int primary key,
	user_role varchar(10)

);

insert into ers_user_roles values (1, 'user');
insert into ers_user_roles values (2, 'admin');

select * from ers_user_roles; 

create table if not exists ers_reimb_type (
	reimb_type_id int primary key,
	reimb_type varchar(10)
);

insert into ers_reimb_type values (1, 'FOOD');
insert into ers_reimb_type values (2, 'TRAVEL');
insert into ers_reimb_type values (3, 'LODGING');

select * from ers_reimb_type;

create table if not exists ers_reimb_status (
	reimb_status_id int primary key,
	reimb_status varchar(10)
);

insert into ers_reimb_status values (1, 'PENDING');
insert into ers_reimb_status values (2, 'APPROVED');
insert into ers_reimb_status values (3, 'DENIED');

select * from ers_reimb_status;

create user sdowd with password 'revature33'

grant all privileges on all tables in schema public to sdowd
