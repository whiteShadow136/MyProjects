create database if not exists mydatabase;
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
