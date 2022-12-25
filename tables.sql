Drop table if exists reserves;
Drop table if exists room;
Drop table if exists user;
Drop table if exists admin;
Drop table if exists building;

create table building (
	id			int			not null,
    building_name		varchar(30)		not null,
    primary key(id)
);


create table admin (
	id		    int		    not null,
    admin_name		    varchar(30)	    not null,
    primary key(id)
);
// room


create table user (
	id		int		    not null,
    user_name		varchar(30)	    not null,
    user_email 	        varchar(30) 	    not null,
    city_state	        varchar(30) 	    not null,
    primary key(id)
);

create table reserves (
    reservation_id      int 			not null auto_increment,
    user_id		int 			not null,
    room_id	        int		    	not null,
    primary key(reservation_id),
    foreign key (user_id) references user (id),
    foreign key (room_id) references room (id)
);
