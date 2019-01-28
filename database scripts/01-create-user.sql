CREATE USER 'gradebook'@'localhost' IDENTIFIED BY 'gradebook';

GRANT ALL PRIVILEGES ON * . * TO 'gradebook'@'localhost';

ALTER USER 'gradebook'@'localhost' IDENTIFIED WITH mysql_native_password BY 'gradebook';