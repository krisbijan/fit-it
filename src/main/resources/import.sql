insert into role(id, name) values (1,'ROLE_USER');
insert into role(id, name) values (2,'ROLE_ADMIN');

insert into user_entity(id, first_name, last_name, email, password) values (1,'kiki','kiki', 'kiki@kiki.kiki', 'kiki');
insert into user_entity(id, first_name, last_name, email, password) values (2,'cici','cici', 'cici@cici.cici', 'cici');

insert into user_role(user_id, role_id) values (1,1);
insert into user_role(user_id, role_id) values (1,2);
insert into user_role(user_id, role_id) values (2,1);

