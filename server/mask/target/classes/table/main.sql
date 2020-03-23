create table if not exists classify(
    id smallint auto_increment primary key,
    name varchar(100) unique,
    enabled tinyint default 1,
    main tinyint default 0,
    parentClass smallint
);

create table if not exists baseConfig
(
    name varchar(50) primary key,
    emailAddress varchar(255) comment '发送地址以逗号隔开',
    companyAddress varchar(500) comment '公司地址',
    companyTel varchar(100) comment '公司电话',
    companyMail varchar(128) comment '公司邮箱'
);

create table if not exists user(
    id bigint primary key ,
    name varchar(50) not null,
    email varchar(255) not null,
    positionName varchar(255) not null default 'sale' comment '职位名称'
);


create table if not exists userMapping(
    id bigint auto_increment primary key ,
    userId bigint,
    userType varchar(50) comment '用户属性'
)