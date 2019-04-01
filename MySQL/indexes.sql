create index employee_index on employee(middle_name, name,surname);
create index user_index on user(id,active,password,username);
create index phone_index on phone (id,amount,firmware_name,firmware_version,free_phone_amount,name);
create index order_index on order_phone(id,date_end,date_start,employee_fk,phone_fk,status);
create index user_role_index on user_role(user_id, roles);