drop table if exists problems cascade;
drop table if exists submissions;

create table if not exists users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table if not exists authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index if not exists ix_auth_username on authorities (username,authority);

-- add indexes later

create table if not exists problems(id int not null primary key, title varchar(100) not null, description varchar(500) not null, sample_input varchar(500), sample_output varchar(500), author varchar(50) not null, version int);

create table if not exists submissions(id serial not null primary key, problem_id int not null, username varchar(50) not null, code varchar(5000) not null, verdict varchar(50) not null, submission_time timestamp, runtime int, memory double precision, language varchar(50) not null, foreign key(problem_id) references problems(id));