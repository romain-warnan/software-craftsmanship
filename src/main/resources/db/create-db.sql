create sequence seq as integer start with 10000 increment by 1;

create table publications (
	id integer primary key,
	titre varchar(200),
	sous_titre varchar(500),
	date_parution date
);