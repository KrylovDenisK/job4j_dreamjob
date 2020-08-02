CREATE TABLE if not exists users (
  id serial,
  name character varying(100),
  email character varying(100),
  password character varying(100),
  PRIMARY KEY (id)
);

CREATE TABLE if not exists post (
  id serial,
  name character varying(100),
  PRIMARY KEY (id)
);

create table if not exists city (
	id serial,
	name varchar(100) not null unique,
	primary key (id)
);

CREATE TABLE if not exists candidate (
  id serial,
  name character varying(100),
  idcity integer,
  PRIMARY KEY (id),
  foreign key ("idcity") references city ("id")
);