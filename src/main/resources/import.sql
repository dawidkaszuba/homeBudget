insert into user ( user_name, password, name) values ('mickey', '$2a$10$kSqU.ek5pDRMMK21tHJlceS1xOc9Kna4F0DD2ZwQH/LAzH0ML0p6.', 'Mickey');
insert into user ( user_name, password, name) values ('minnie', '$2a$10$MnHcLn.XdLx.iMntXsmdgeO1B4wAW1E5GOy/VrLUmr4aAzabXnGFq', 'Minnie');
insert into user ( user_name, password, name) values ('donald', '$2a$10$0UCBI04PCXiK0pF/9kI7.uAXiHNQeeHdkv9NhA1/xgmRpfd4qxRMG', 'Donald');
insert into user ( user_name, password, name) values ('daisy', '$2a$10$aNoR88g5b5TzSKb7mQ1nQOkyEwfHVQOxHY0HX7irI8qWINvLDWRyS', 'Daisy');
insert into user ( user_name, password, name) values ( 'clarabelle', '$2a$10$cuTJd2ayEwXfsPdoF5/hde6gzsPx/gEiv8LZsjPN9VPoN5XVR8cKW', 'Clarabelle');
insert into user ( user_name, password, name) values ('admin', '$2a$10$JQOfG5Tqnf97SbGcKsalz.XpDQbXi1APOf2SHPVW27bWNioi9nI8y', 'Super');


INSERT INTO tag(name,user_id) VALUES('food',1);
INSERT INTO tag(name,user_id) VALUES('clothes',1);
INSERT INTO tag(name,user_id) VALUES('bus tickets',1);
INSERT INTO tag(name,user_id) VALUES('kindergarten',1);
INSERT INTO tag(name,user_id) VALUES('salary',1);


INSERT INTO expenditure(amount,expenditure_date,user_id) VALUES(24.56,'2019-11-12',1);
INSERT INTO expenditure(amount,expenditure_date,note,user_id) VALUES(99.99,'2019-11-10','jacket',1);
INSERT INTO expenditure(amount,expenditure_date,note,user_id) VALUES(52.39,'2019-11-15','fruit for birthday',2);

INSERT INTO income(amount,income_date,user_id) VALUES(2500.00,'2019-11-10',1);
INSERT INTO income(amount,income_date,user_id) VALUES(2600.00,'2019-10-10',2);


INSERT into expenditure_tags(expenditure_id,tags_id) VALUES(1,1);
INSERT into expenditure_tags(expenditure_id,tags_id) VALUES(2,2);
INSERT into expenditure_tags(expenditure_id,tags_id) VALUES(3,1);
INSERT into income_tags(income_id,tags_id) VALUES(1,5);
INSERT into income_tags(income_id,tags_id) VALUES(2,5);

