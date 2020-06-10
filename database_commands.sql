create database db_przepisy;
create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
grant all on db_przepisy.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database
use db_przepisy;
insert into user values('1', '$2a$10$VgMfhglD5nTCMeIccQWYcOtgqJEh5colz6S8UCwJrmBu14Qq8lNEq',  'username123');
insert into user values('2', '$2a$10$VgMfhglD5nTCMeIccQWYcOtgqJEh5colz6S8UCwJrmBu14Qq8lNEq', 'username1234');
insert into user values('3', '$2a$10$VgMfhglD5nTCMeIccQWYcOtgqJEh5colz6S8UCwJrmBu14Qq8lNEq', 'admin');
insert into role values(1, "admin");
insert into user_roles values(1,1);