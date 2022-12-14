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

create table room (
	id					int				not null auto_increment unique,
    room_name			varchar(30) 	,
    building_id			int				,
    capacity 			int 			,
	property_string		varchar(30) 	, 
    reservation_status	varchar(30) 	,
    primary key(room_name, building_id ),
    foreign key (building_id) references building(id)
);
