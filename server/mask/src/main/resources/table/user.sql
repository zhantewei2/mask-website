create table if not exists User(
    id bigint primary key,
    account varchar(255) unique not null,
    name varchar(255) not null,
    password varchar(255) not null,
    createDate datetime default current_timestamp,
    lastLogin datetime,
    updateDate timestamp on update current_timestamp
)