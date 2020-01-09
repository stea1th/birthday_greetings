
-- set datestyle to NATIONAL;

insert into person (first_name, last_name, date_of_birth, email)
values ('John', 'Doe', '1982-10-08', 'john.doe@foobar.com'),
       ('Mary', 'Ann', '1975-09-11', 'mary.ann@foobar.com');

insert into person (first_name, last_name, date_of_birth, email, auto_email_greetings)
values ('Vadim', 'Vlasov', '1987-01-09', 'dmitri.pechenkin@foobar.com', true),
       ('Mike', 'Moor', '1982-10-08', 'mike.moor@foobar.com', true),
       ('Dmitrij', 'Pechenkin', '1987-01-09', 'stea1th@mail.ru', true);
