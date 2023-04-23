create table sys_user
(
    user_id                bigint primary key auto_increment,
    username               varchar(20)  not null,
    password               varchar(256) not null,
    sex                    varchar(1)   not null,
    address                varchar(256),
    enable                 int default 1,
    account_no_expired     int default 1,
    credentials_no_expired int default 1,
    account_no_locked      int default 1
);

alter table sys_user
    change username username varchar(20) not null unique;

insert into sys_user (username, password, sex, address)
values ('admin', '$2a$10$ANg11d1ZSJr5sgxbeqo.DuDs6aF5KxAP.C9jAJqmM8AB6MpkbwwvC', '男', '南京');

insert into sys_user (username, password, sex, address)
values ('student', '$2a$10$oUD0nspoxQybHNW3G9MqbuYOlPYi6IcX0yAnyl48VLNG2hI7d729K', '男', '南京');

insert into sys_user (username, password, sex, address)
values ('teacher', '$2a$10$oUD0nspoxQybHNW3G9MqbuYOlPYi6IcX0yAnyl48VLNG2hI7d729K', '男', '南京');


create table sys_role
(
    id       bigint auto_increment primary key,
    rolename varchar(256) not null,
    remark   varchar(256) not null
);

insert into sys_role (rolename, remark)
values ('ROLE_ADMIN', '管理员'),
       ('ROLE_STUDENT', '学生'),
       ('ROLE_TEACHER', '老师');


create table sys_role_user
(
    uid bigint not null,
    rid bigint not null
);

insert into sys_role_user (uid, rid)
values (1, 1),
       (2, 2),
       (3, 3);

create table sys_menu
(
    id      bigint primary key auto_increment,
    pid     bigint       not null,
    name    varchar(256) not null,
    code    varchar(256) not null,
    type    int          not null,
    deleted int default 0
);

insert into sys_menu (pid, name, code, type)
values (0, '学生管理', '/student/**', 0),
       (1, '学生查询', 'student:query', 1),
       (1, '学生添加', 'student:add', 1),
       (1, '学生修改', 'student:update', 1),
       (1, '学生删除', 'student:delete', 1),
       (1, '导出学生信息', 'student:export', 1),
       (0, '教师管理', '/teacher/**', 0),
       (7, '教师查询', 'teacher:query', 1);


create table sys_role_menu
(
    rid bigint not null,
    mid bigint not null
);

insert into sys_role_menu (rid, mid)
values (1, 1),
       (3, 1),
       (2, 2),
       (3, 2),
       (1, 3),
       (2, 3),
       (1, 4),
       (2, 4),
       (1, 5),
       (2, 5),
       (3, 6),
       (1, 9),
       (2, 9),
       (3, 9),
       (1, 10),
       (1, 17);


select *
from sys_user;

select *
from sys_role;

select *
from sys_role_user;

select *
from sys_menu;

select *
from sys_role_menu;

select t1.user_id, t1.username, t2.rolename, t4.name, t4.code
from sys_user t1,
     sys_role t2,
     sys_role_user t3,
     sys_menu t4,
     sys_role_menu t5
where t1.user_id = t3.uid
  and t2.id = t3.rid
  and t2.id = t5.rid
  and t4.id = t5.mid
  and t1.user_id = 4;

# 优化后
SELECT u.user_id, u.username, r.rolename, m.name AS menu_name, m.code AS menu_code
FROM sys_user u
         JOIN sys_role_user ru ON u.user_id = ru.uid
         JOIN sys_role r ON r.id = ru.rid
         JOIN sys_role_menu rm ON r.id = rm.rid
         JOIN sys_menu m ON m.id = rm.mid
WHERE u.user_id = 1;