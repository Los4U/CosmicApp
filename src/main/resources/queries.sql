/* ROLES */
insert into role ("role_id", "role")
VALUES(1, 'ADMIN');

insert into role ("role_id", "role")
VALUES(2, 'USER');


/* USERS */
insert into public.user("user_id", "active", "name","password")
values (1, 1, 'admin', '$2a$10$K4/Het4pFLpy3lO0HR.Sn.DYkLO/vveUs8zOuuhrxDtJOqDsYZ/my' );

insert into public.user("user_id", "active", "name", "password")
values (2, 1, 'user', '$2a$10$K4/Het4pFLpy3lO0HR.Sn.DYkLO/$2a$10$8VuIvPxWkzqzXSRLQH8f.OfmccPNzkFPT0.RMzfPRGQlL8KVvXV32/my' );


/* ADD ROLES to USERS */

insert into user_role (user_id, role_id) values (1,1); /*ADMIN*/
insert into user_role (user_id, role_id) values (1,2);

insert into user_role (user_id, role_id) values (2,2);