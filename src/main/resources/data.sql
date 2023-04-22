insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, SALARY_INCOME)
values (301, 28, '123', 'João', 100);

insert into HOUSE_FAMILY (ID, PERSON_ID)
values (301, 301);

insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, FAMILY_ID)
values (302, 12, '321', 'Carla', 301);

insert into HOUSE_PERSON (ID, AGE, DOCUMENT_NUMBER, NAME, FAMILY_ID)
values (303, 16, '856', 'Flávia', 301);