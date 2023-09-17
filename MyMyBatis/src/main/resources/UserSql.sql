show processlist;

show databases;
create database mydatabase;
use mydatabase;
create table if not exists user
(
    id int,
    name varchar(20),
    age int
);

insert ignore into user values (1, 'mrxie', 24);
insert ignore into user values (2, 'mrxie', 24);
insert ignore into user values (3, 'mrxie', 24);
insert ignore into user values (4, 'mrxie', 24);
insert ignore into user values (5, 'mrxie', 24);
insert ignore into user values (6, 'mrxie', 24);
select * from user;
show variables like '%connection%';
set global max_connections = 8;
show processlist;

kill 20;
kill 21;

show variables like '%wait_timeout%';

show processlist ;
select * from user;

kill 13;