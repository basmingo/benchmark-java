create table "user"
(
    user_id        serial
        constraint user_pk
            primary key,
    first_name     varchar(255) not null,
    last_name      varchar(255) not null,
    email          varchar(30)  not null,
    phone          integer      not null,
    application_id integer
);

alter table "user"
    owner to admin;

create table application
(
    application_id serial
        constraint application_pk
            primary key,
    status         varchar(16) not null,
    data           timestamp   not null,
    amount         numeric     not null,
    user_id        integer     not null
        constraint application_user_user_id_fk
            references "user"
            on delete cascade
);

alter table application
    owner to admin;
