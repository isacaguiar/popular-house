--Adição família
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, SALARY_INCOME) values (9990, 28, '123', 'Pedro', 100);
insert into HOUSE_FAMILY (ID, PERSON_ID) values (9990, 9990);
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, FAMILY_ID) values (9991, 12, '321', 'Carla', 9990);
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, FAMILY_ID) values (9992, 16, '856', 'Flavia', 9990);
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, FAMILY_ID) values (9993, 11, '587', 'Dudu', 9990);

--Adição família
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, SALARY_INCOME) values (9970, 28, '123', 'Sara', 600);
insert into HOUSE_FAMILY (ID, PERSON_ID) values (9970, 9970);
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, FAMILY_ID, SALARY_INCOME) values (9971, 18, '856', 'Alex', 9970, 380);

--Adição família
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, SALARY_INCOME) values (9980, 28, '123', 'Jose', 200);
insert into HOUSE_FAMILY (ID, PERSON_ID) values (9980, 9980);
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, FAMILY_ID) values (9981, 12, '321', 'Italo', 9980);
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, FAMILY_ID) values (9982, 18, '856', 'Felipe', 9980);
insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, FAMILY_ID) values (9938, 18, '856', 'Tata', 9980);