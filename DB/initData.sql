INSERT INTO user VALUES ('1', '2019-03-11 00:00:00', 'zhyjhdw@126.com', '2019-03-11 00:00:00', 'admin','$2a$10$PXZ9oJ6U36/ZuG8G4S4pKeR3.98GnSg03CpY0W8irb5W5p6pQ7rei','18539161177','2019-03-11 00:00:00');
INSERT INTO role VALUES ('1','2019-03-11 00:00:00','管理员','管理员');
INSERT INTO role VALUES ('2','2019-03-11 00:00:00','测试角色','测试角色');
INSERT INTO permission VALUES ('1','系统','system','0','/system');
INSERT INTO permission VALUES ('2','用户管理','system.user','1','/system/user');
INSERT INTO permission VALUES ('3','获取用户列表','system.user.list','2','/system/user');


INSERT INTO user VALUES ('1', '2019-03-11 00:00:00', 'zhyjhdw@126.com', '2019-03-11 00:00:00', 'houdengw','$2a$10$PXZ9oJ6U36/ZuG8G4S4pKeR3.98GnSg03CpY0W8irb5W5p6pQ7rei','18539161177','2019-03-11 00:00:00');

INSERT INTO user_role VALUES (1,1);
INSERT INTO user_role VALUES (2,2);

INSERT INTO role_permission VALUES (1,1);
INSERT INTO role_permission VALUES (1,2);
INSERT INTO role_permission VALUES (1,3);
INSERT INTO role_permission VALUES (2,1);
INSERT INTO role_permission VALUES (2,2);
