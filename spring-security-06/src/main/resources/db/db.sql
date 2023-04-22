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
