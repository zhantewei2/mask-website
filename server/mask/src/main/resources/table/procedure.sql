delimiter //
drop procedure if exists new_classify //
    create procedure new_classify(
        in _name varchar(100),
        in _main boolean,
        in _parentClass smallint
    )
    begin
        declare auto_id smallint;
        declare set_main tinyint;
        if _main then
            set set_main=1;
        else
            set set_main=0;
        end if;
        insert classify(name,main,parentClass) values(_name,set_main,_parentClass);

        select last_insert_id() into auto_id;

        update classify set toOrder=auto_id where id=auto_id;

    end //
delimiter ;



delimiter //
drop procedure if exists new_homeShopNav //
create procedure new_homeShopNav(
    in _name varchar(100),
    in _des varchar(255),
    in _img varchar(500),
    in _classifyId smallint,
    in _href varchar(500),
    in _type varchar(20)
)
begin
    declare auto_id smallint;
    insert homeShopNav(name,des,img,classifyId,href,type)
        values(_name,_des,_img,_classifyId,_href,_type);
    select last_insert_id() into auto_id;
    update homeShopNav set toOrder=auto_id where id=auto_id;
end //

delimiter ;