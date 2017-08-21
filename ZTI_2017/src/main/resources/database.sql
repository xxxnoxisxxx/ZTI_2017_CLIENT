INSERT INTO role VALUES (1,'ROLE_USER');
INSERT INTO role VALUES (2,'ROLE_ADMIN');
INSERT INTO myuser (id,username,password) VALUES(1,'administrator','$2a$11$cPJgwpx/ZG60KT4Va37W/eS6S9jCSqHGXxppw2VKvMeZbXJHKEL3a');
INSERT INTO myuser (id,username,password) VALUES(2,'testuser','$2a$11$3pUBhRBmAIbT.aS91OK6sue4zUrK9t3KJm9jHcU.l8Lg9L9P.TzDe');
INSERT INTO user_role (user_id,role_id) VALUES(1,1);
INSERT INTO user_role (user_id,role_id) VALUES(1,2);
INSERT INTO user_role (user_id,role_id) VALUES(2,1);
select setval('user_seq', (select max(id)+1 from myuser), false);
select setval('role_seq', (select max(id)+1 from role), false);