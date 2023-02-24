delete
from user_role;
delete
from usr;

insert into usr(id, activation_code, active, email, password, username)
values (1, null, true, null, '1', '1'),
       (2, null, true, null, '2', '2'),
       (2, null, true, null, '2', '2');
insert into user_role(user_id, roles) VALUES
                                          (1,'USER'),
                                          (1,'Admin');