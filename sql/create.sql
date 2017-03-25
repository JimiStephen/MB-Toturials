CREATE TABLE person (
  id       INT PRIMARY KEY,
  username VARCHAR(255) NOT NULL UNIQUE,
  birthday DATE
);