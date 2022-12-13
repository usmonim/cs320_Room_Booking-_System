Drop table if exists building;
Drop table if exists admin;

create table building (
	id					int				not null,
    building_name		varchar(30)		not null,
    primary key(id)
);


create table admin (
	id					int				not null,
    admin_name		    varchar(30)	    not null,
    primary key(id)
);


