create table public.sensor_type
(
    id   serial
        primary key,
    name varchar(40) not null
);

alter table public.sensor_type
    owner to admin;

create table public.sensor_unit
(
    id   serial
        primary key,
    name varchar(40) not null
);

alter table public.sensor_unit
    owner to admin;

create table public.sensor
(
    id          serial
        primary key,
    range_from  integer     not null,
    range_to    integer     not null,
    CONSTRAINT valid_range CHECK (range_from < range_to),
    type_id     integer     not null
        constraint fksqsj9at1rxxb1x37dnftf8hrt
            references public.sensor_type,
    unit_id     integer     not null
        constraint fkmemgt7l3xhi5v5w5gm8y04krq
            references public.sensor_unit,
    model       varchar(15) not null,
    name        varchar(30) not null,
    location    varchar(40),
    description varchar(200)
);

alter table public.sensor
    owner to admin;

create table public.users
(
    id       serial
        primary key,
    role     varchar(30)
        constraint users_role_check
            check ((role)::text = ANY ((ARRAY ['USER'::character varying, 'ADMIN'::character varying])::text[])),
    status   varchar(30)
        constraint users_status_check
            check ((status)::text = ANY ((ARRAY ['ACTIVE'::character varying, 'BANNED'::character varying])::text[])),
    username varchar(40),
    password varchar(200)
);

alter table public.users
    owner to admin;


