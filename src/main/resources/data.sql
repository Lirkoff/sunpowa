insert into users (id, active, email, first_name, last_name, password)
values
    (1, 1, 'admin@example.com', 'Admin', 'Adminov', 'c57131f2c88c8ba649f20a01ee1eb3f44e402dfcc57665eb2900a36402aed389de157acd3ae510c25d5d6dd768a56087');


insert into roles (id, role)
VALUES
    (1, 'MASTER'),
    (2, 'ADMIN'),
    (3, 'USER');

insert into users_roles (user_id, role_id)
VALUES
    (1, 1),
    (1, 2),
    (1, 3);
INSERT INTO brands (id, name, model)
VALUES
    (1, 'Mitsubishi Electric', 'Air Power 1000'),
    (2, 'Huawei', 'GtX800'),
    (3, 'LG', 'Dynamo');
