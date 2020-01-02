
delete from person;

set datestyle to NATIONAL;

insert into person (first_name, last_name, date_of_birth, email)
values ('John', 'Doe', '1982/10/08', 'john.doe@foobar.com'),
       ('Mary', 'Ann', '1975/09/11', 'mary.ann@foobar.com');

insert into person (first_name, last_name, date_of_birth, email, auto_email_greetings)
values ('Vadim', 'Vlasov', '03.03.1982', 'stea1th@mail.ru', true);
