CREATE DATABASE IF NOT EXISTS `gradebook` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gradebook`;



DROP TABLE IF EXISTS `teachers_groups`;
DROP TABLE IF EXISTS `marks`;
DROP TABLE IF EXISTS `students`;
DROP TABLE IF EXISTS `groups`;
DROP TABLE IF EXISTS `learning_Groups`;
DROP TABLE IF EXISTS `learninggroups`;
DROP TABLE IF EXISTS `teachers`;
DROP TABLE IF EXISTS `users_authorities`;
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
                       `username` varchar(50) NOT NULL unique,
                       `password` varchar(61) not null,
                       PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `teachers` (
                          `username` varchar(50) NOT NULL,
                          `teacher_id` integer NOT NULL AUTO_INCREMENT,
                          `name` varchar(15),
                          `surname` varchar(15),
                          `email` varchar(50),
                          `subject` varchar(30),
                          PRIMARY KEY (`teacher_id`),
                          CONSTRAINT `teachers_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `learning_Groups` (
                                 `group_id` varchar(10) NOT NULL,
                                 PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `students` (
                          `username` varchar(50) NOT NULL,
                          `student_id` integer NOT NULL AUTO_INCREMENT,
                          `name` varchar(15),
                          `surname` varchar(15),
                          `email` varchar(50),
                          `group_id` varchar(10) NOT NULL,
                          PRIMARY KEY (`student_id`),
                          CONSTRAINT `students_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`),
                          CONSTRAINT `students_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `learning_Groups` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `teachers_groups` (
                                 `teacher_id` integer NOT NULL,
                                 `group_id` varchar(10) NOT NULL,
                                 PRIMARY KEY (`teacher_id`, `group_id`),
                                 CONSTRAINT `teacher_group_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`teacher_id`),
                                 CONSTRAINT `teacher_group_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `learning_Groups` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `marks` (
                       `mark_id` integer NOT NULL AUTO_INCREMENT,
                       `mark_value` varchar(3) NOT NULL,
                       `student_id` integer NOT NULL,
                       `teacher_id` integer NOT NULL,
                       PRIMARY KEY (`mark_id`),
                       CONSTRAINT `mark_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
                       CONSTRAINT `mark_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `authorities` (
                             `authority_id` integer NOT NULL auto_increment,
                             `authority` varchar(50) NOT NULL,
                             primary key `authorities_idx_1` (`authority_id`)
) ENGINE=InnoDB auto_increment = 1 DEFAULT CHARSET=latin1;


CREATE TABLE `users_authorities` (
                                   `username` varchar(50) NOT NULL,
                                   `authority_id` integer NOT NULL,
                                   primary key `authorities_idx_1` (`username`,`authority_id`),
                                   CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`),
                                   CONSTRAINT `authorities_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `authorities` (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



select * from `students`;
select * from `users`;
select * from `teachers`;
select * from `learning_Groups`;
select * from gradebook.`marks`;
select * from gradebook.`authorities`;
select * from users_authorities;


insert into gradebook.`users`
values('admin','admin');

insert into gradebook.`learning_Groups`
values ('I5B6S1');

insert into  gradebook.`learning_Groups`
values ('I6X4S1');
insert into `learning_Groups`
values ('I4B5S2');
insert into  gradebook.`learning_Groups`
values ('K5D2S1');
insert into `learning_Groups`
values ('ALFA');
insert into  gradebook.`learning_Groups`
values ('GAMMA');



INSERT INTO gradebook.`authorities` (`authority`)
VALUES
('ROLE_User');

INSERT INTO gradebook.`authorities` (`authority`)
VALUES
('ROLE_ADMIN');

INSERT INTO gradebook.`authorities` (`authority`)
VALUES
('ROLE_STUDENT');

INSERT INTO gradebook.`authorities` (`authority`)
VALUES
('ROLE_TEACHER');



INSERT INTO gradebook.`users_authorities`
VALUES
('admin',1);

INSERT INTO gradebook.`users_authorities`
VALUES
('admin',2);


