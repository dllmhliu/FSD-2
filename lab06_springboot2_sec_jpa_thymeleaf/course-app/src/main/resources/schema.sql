DROP TABLE IF EXISTS tbl_user;

CREATE TABLE tbl_user (
  user_id INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  name VARCHAR(20) not null,
  email VARCHAR(20) not null,
  username VARCHAR(20) unique not null,
  password VARCHAR(60) not null,
  admin boolean not null default FALSE
);