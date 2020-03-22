create table if not exists shop(
    id bigint primary key,
    name varchar(100) unique not null,
    price decimal default 0,
    img text not null,
    vestIn mediumint not null comment '分类指向 classify表',
    index queryIndex (id,vestIn),
    createDate datetime default current_timestamp,
    updateDate timestamp on update current_timestamp,
    hot bigint default 0 comment '热度'
);


create table if not exists shopInfo(
    id bigint primary key,
    type varchar(100) not null default 'basic type' comment '型号名',
    imgs text not null comment '图片集 逗号隔开',
    box varchar(100),
    ctn varchar(100),
    dimension varchar(100),
    GW mediumint comment '毛重',
    NW mediumint comment '净值'
)