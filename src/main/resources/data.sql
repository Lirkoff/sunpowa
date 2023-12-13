insert into users (id, active, email, first_name, last_name, password)
values
    (1, 1, 'admin@example.com', 'Admin', 'Adminov', 'c57131f2c88c8ba649f20a01ee1eb3f44e402dfcc57665eb2900a36402aed389de157acd3ae510c25d5d6dd768a56087'),
    (2, 1, 'user@example.com', 'User', 'Userov', '579b1e26be4976073e9706cf34ba52612c3201036288e469370ca2dfb1993f62ebd032db2a9efaadc39f364c42abf7c7');



insert into roles (`id`, `role`)
VALUES
    (1, 'ADMIN'),
    (2, 'USER');

insert into users_roles(`user_id`, `role_id`)
VALUES
    (1, 1),
    (1, 2);

INSERT INTO `brands` (`id`, `name`, `model`)
VALUES
    (1, 'Mitsubishi Electric', 'Air Power 1000'),
    (2, 'Huawei', 'GtX800'),
    (3, 'LG', 'Dynamo');