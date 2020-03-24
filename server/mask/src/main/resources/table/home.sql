drop table if exists homeShopNav;
create table if not exists homeShopNav(
    id mediumint auto_increment primary key ,
    name varchar(100),
    des varchar(255),
    createDate datetime default current_timestamp not null,
    toOrder mediumint,
    img varchar(500),
    classifyId smallint comment 'nav to classify',
    href varchar(500) comment 'nav to href',
    type varchar(20) comment 'type:carousel,nav '
);