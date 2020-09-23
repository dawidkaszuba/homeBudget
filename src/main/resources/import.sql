insert into user( user_name, password, name) values ('test', '$2y$12$iXXuH9qxndl69AFLezwwrO8lDZ/2K0GjilEUfUxTvj3u4YhPkTrfK', 'Super');
insert into user( user_name, password, name) values ('mickey', '$2a$10$kSqU.ek5pDRMMK21tHJlceS1xOc9Kna4F0DD2ZwQH/LAzH0ML0p6.', 'Mickey');
insert into user( user_name, password, name) values ('minnie', '$2a$10$MnHcLn.XdLx.iMntXsmdgeO1B4wAW1E5GOy/VrLUmr4aAzabXnGFq', 'Minnie');
insert into user( user_name, password, name) values ('donald', '$2a$10$0UCBI04PCXiK0pF/9kI7.uAXiHNQeeHdkv9NhA1/xgmRpfd4qxRMG', 'Donald');
insert into user( user_name, password, name) values ('daisy', '$2a$10$aNoR88g5b5TzSKb7mQ1nQOkyEwfHVQOxHY0HX7irI8qWINvLDWRyS', 'Daisy');
insert into user( user_name, password, name) values ( 'clarabelle', '$2a$10$cuTJd2ayEwXfsPdoF5/hde6gzsPx/gEiv8LZsjPN9VPoN5XVR8cKW', 'Clarabelle');

INSERT INTO ROLE(id,name) VALUES (1, 'admin');
INSERT INTO ROLE(id,name) VALUES (2, 'regular');


INSERT INTO income(amount,income_date,user_id) VALUES(2500.00,'2020-09-10',1);
INSERT INTO income(amount,income_date,user_id) VALUES(2600.00,'2020-09-10',1);

Insert into income(amount,income_date, user_id) values (5000.00, '2020-09-11',1);

INSERT INTO tag(name,user_id,kind) VALUES('food',1,'NEGATIVE');
INSERT INTO tag(name,user_id,kind) VALUES('clothes',1,'NEGATIVE');
INSERT INTO tag(name,user_id,kind) VALUES('bus tickets',1,'NEGATIVE');
INSERT INTO tag(name,user_id,kind) VALUES('kindergarten',1,'NEGATIVE');
INSERT INTO tag(name,user_id,kind) VALUES('salary',1,'POSITIVE');
INSERT INTO tag(name,user_id,kind) VALUES('my_salary',2,'POSITIVE');
INSERT INTO tag(name,user_id,kind) VALUES('petrol',2,'NEGATIVE');
INSERT INTO tag(name,user_id,kind) VALUES('salary2',1,'POSITIVE');


INSERT INTO expenditure(amount,expenditure_date,user_id) VALUES(24.56,'2020-09-12',1);
INSERT INTO expenditure(amount,expenditure_date,note,user_id) VALUES(99.99,'2020-09-10','jacket',1);
INSERT INTO expenditure(amount,expenditure_date,note,user_id) VALUES(52.39,'2020-09-15','fruit for birthday',2);


INSERT into PLANNED_CASH_FLOW (NAME,CURRENT_SUM_AMOUNT,END_DATE,IS_SUM_AMOUNT_EXCEEDED,NOTE,PLANNED_AMOUNT,START_DATE,USER_ID) VALUES('Petrol',200.00,'2020-09-31',false,'note1',300.00,'2020-09-01',1);
INSERT into PLANNED_CASH_FLOW (NAME,CURRENT_SUM_AMOUNT,END_DATE,IS_SUM_AMOUNT_EXCEEDED,NOTE,PLANNED_AMOUNT,START_DATE,USER_ID) VALUES('Food',0.00,'2020-09-31',false,'note1',1500.00,'2020-09-01',1);
INSERT into PLANNED_CASH_FLOW (NAME,CURRENT_SUM_AMOUNT,END_DATE,IS_SUM_AMOUNT_EXCEEDED,NOTE,PLANNED_AMOUNT,START_DATE,USER_ID) VALUES('Food in work',0.00,'2020-09-31',false,'note1',200.00,'2020-09-01',1);

INSERT INTO expenditure(amount,expenditure_date,user_id,PLANNED_CASH_FLOW_ID ) VALUES(90,'2020-09-12',1,1);
INSERT INTO expenditure(amount,expenditure_date,user_id,PLANNED_CASH_FLOW_ID ) VALUES(110,'2020-09-14',1,1);

INSERT INTO savings(amount,last_modification_date, user_id) VALUES(1000,'2020-09-01',1);





