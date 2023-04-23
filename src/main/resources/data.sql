--Adição primeira família
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, SALARY_INCOME) values (9999, 28, '123', 'Pedro', 100);
insert into HOUSE_FAMILY (ID, PERSON_ID) values (8888, 9999);
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, FAMILY_ID) values (9998, 12, '321', 'Carla', 8888);
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, FAMILY_ID) values (9997, 16, '856', 'Flavia', 8888);

--Adição segunda família
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, SALARY_INCOME) values (9996, 28, '123', 'Sara', 600);
insert into HOUSE_FAMILY (ID, PERSON_ID) values (8889, 9996);
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, FAMILY_ID) values (9995, 12, '321', 'Ruan', 8889);
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, FAMILY_ID, SALARY_INCOME) values (9994, 18, '856', 'Alex', 8889, 380);