INSERT INTO role (id,name,description) VALUES (1,'ROLE_USER','Użytkownik');
INSERT INTO role (id,name,description) VALUES (2,'ROLE_ADMIN','Administrator');
INSERT INTO myuser (id,firstname,lastname,email,username,password) VALUES(1,'Jan','Nowak','nowakj@zti.pl','administrator','$2a$11$cPJgwpx/ZG60KT4Va37W/eS6S9jCSqHGXxppw2VKvMeZbXJHKEL3a');
INSERT INTO myuser (id,firstname,lastname,email,username,password) VALUES(2,'Jan','Kowalski','kowalskij@zti.pl','testuser','$2a$11$3pUBhRBmAIbT.aS91OK6sue4zUrK9t3KJm9jHcU.l8Lg9L9P.TzDe');
INSERT INTO user_role (user_id,role_id) VALUES(1,1);
INSERT INTO user_role (user_id,role_id) VALUES(1,2);
INSERT INTO user_role (user_id,role_id) VALUES(2,1);
select setval('user_seq', (select max(id)+1 from myuser), false);
select setval('role_seq', (select max(id)+1 from role), false);