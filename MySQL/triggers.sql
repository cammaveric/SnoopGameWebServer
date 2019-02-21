delimiter $$
create trigger update_phone before update on phone for each row
begin
DECLARE `count` int; declare count_free int;
if(new.phone_amount!=old.phone_amount) then
set `count`=old.phone_amount+new.phone_amount;/*plus/minus phone_count*/
set new.phone_amount=`count`;
set count_free=old.free_phone_amount+new.phone_amount;/*plus/minus free_phone_count*/
set new.free_phone_amount=count_free;
end if;
if (new.free_phone_amount!=old.free_phone_amount) then 
set `count`=old.free_phone_amount+new.free_phone_amount;/*plus/minus free_phone_count*/
set new.free_phone_amount=`count`;
end if;
END$$   
DELIMITER ;

delimiter $$
create trigger update_order before update on `order` for each row
begin
DECLARE msg tinytext;
if(old.id_status=2)then set msg= CONCAT('Can\'t to update record, order already executed');
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT=msg, MYSQL_ERRNO=30001;
end if;
END$$   
DELIMITER ;

SELECT Concat('DROP TRIGGER IF EXISTS ', Trigger_Name, ';') FROM  information_schema.TRIGGERS WHERE TRIGGER_SCHEMA = 'androidproject';


create user 'springuser'@'%' identified by 'password'; 
grant select, insert, delete, update on androidproject to 'springuser'@'localhost';
