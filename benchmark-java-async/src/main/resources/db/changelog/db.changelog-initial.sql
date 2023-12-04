create table a_user
(
    id         uuid unique not null,
    first_name varchar(30) not null,
    last_name  varchar(30) not null,
    primary key (id)
);

create table credit_information
(
    id      uuid unique not null,
    amount  numeric     not null,
    status  varchar(16) not null,
    user_id uuid        not null,
    primary key (id)
);

create table passport
(
    id            uuid unique not null,
    serial_number int         not null,
    number        int         not null,
    user_id       uuid        not null,
    primary key (id)
);
