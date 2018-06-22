CREATE TABLE product(
  id int AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  description CHAR(100) NOT NULL UNIQUE,
  price decimal(8,3) NOT NULL
);

