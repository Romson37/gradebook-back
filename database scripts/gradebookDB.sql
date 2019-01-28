CREATE DATABASE IF NOT EXISTS `gradebook` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gradebook`;


DROP TABLE IF EXISTS `teachers_groups`;
DROP TABLE IF EXISTS `groups`;
DROP TABLE IF EXISTS `marks`;
DROP TABLE IF EXISTS `students`;
DROP TABLE IF EXISTS `teachers`;
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `teachers` (
  `username` varchar(50) NOT NULL,
  `teacher_id` integer NOT NULL AUTO_INCREMENT,
  `name` varchar(15),
  `surname` varchar(15),
  `email` varchar(30),
  PRIMARY KEY (`teacher_id`),
  CONSTRAINT `teachers_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `students` (
  `username` varchar(50) NOT NULL,
  `student_id` integer NOT NULL AUTO_INCREMENT,
  `name` varchar(15),
  `surname` varchar(15),
  `email` varchar(30),
  PRIMARY KEY (`student_id`),
  CONSTRAINT `students_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `groups` (
  `group_id` varchar(10) NOT NULL,
  `student_id` integer,
  `surname` varchar(15),
  `email` varchar(30),
  PRIMARY KEY (`group_id`),
  CONSTRAINT `group_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `teachers_groups` (
  `user_group_id` integer NOT NULL AUTO_INCREMENT,
  `teacher_id` integer NOT NULL,
  `group_id` varchar(10) NOT NULL,
  `subject` varchar(30),
  PRIMARY KEY (`user_group_id`),
  CONSTRAINT `teacher_group_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`teacher_id`),
  CONSTRAINT `teacher_group_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `marks` (
  `mark_id` integer NOT NULL AUTO_INCREMENT,
  `mark_value` varchar(3) NOT NULL,
  `student_id` integer NOT NULL,
  `teacher_id` integer NOT NULL,    
  PRIMARY KEY (`mark_id`),
  CONSTRAINT `mark_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




INSERT INTO `users` 
VALUES 
('admin','{noop}admin',1);

INSERT INTO `authorities`
VALUES 
('admin','ROLE_ADMIN');

