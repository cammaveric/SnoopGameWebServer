
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
grant select, insert, delete, update on androidproject.* to 'springuser'@'localhost';
