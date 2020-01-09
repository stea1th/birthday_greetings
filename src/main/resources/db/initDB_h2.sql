drop table if exists person;

drop sequence if exists global_seq;

create sequence global_seq start with 1000;

create table person
(
    id                   integer default global_seq.nextval primary key,
    first_name           varchar(40)           not null,
    last_name            varchar(40)           not null,
    date_of_birth        date                  not null,
    email                varchar(50)           not null,
    auto_email_greetings boolean default false not null
);

create unique index person_unique_email_index on person (email);
