insert into users (id, user_name, password, name, admin) values (1, 'mickey', '$2a$10$kSqU.ek5pDRMMK21tHJlceS1xOc9Kna4F0DD2ZwQH/LAzH0ML0p6.', 'Mickey', 'no');
insert into users (id, user_name, password, name, admin) values (2, 'minnie', '$2a$10$MnHcLn.XdLx.iMntXsmdgeO1B4wAW1E5GOy/VrLUmr4aAzabXnGFq', 'Minnie', 'no');
insert into users (id, user_name, password, name, admin) values (3, 'donald', '$2a$10$0UCBI04PCXiK0pF/9kI7.uAXiHNQeeHdkv9NhA1/xgmRpfd4qxRMG', 'Donald', 'no');
insert into users (id, user_name, password, name, admin) values (4, 'daisy', '$2a$10$aNoR88g5b5TzSKb7mQ1nQOkyEwfHVQOxHY0HX7irI8qWINvLDWRyS', 'Daisy', 'no');
insert into users (id, user_name, password, name, admin) values (5, 'clarabelle', '$2a$10$cuTJd2ayEwXfsPdoF5/hde6gzsPx/gEiv8LZsjPN9VPoN5XVR8cKW', 'Clarabelle', 'no');
insert into users (id, user_name, password, name, admin) values (6, 'admin', '$2a$10$JQOfG5Tqnf97SbGcKsalz.XpDQbXi1APOf2SHPVW27bWNioi9nI8y', 'Super', 'yes');


INSERT INTO expenditure(amount,expenditure_date,tag) VALUES(24.56,'2019-11-12','food');
INSERT INTO expenditure(amount,expenditure_date,tag,note) VALUES(99.99,'2019-11-10','clothes','jacket');
INSERT INTO expenditure(amount,expenditure_date,tag,note) VALUES(52.39,'2019-11-15','food','fruit for birthday');
INSERT INTO income(amount,income_date,tag) VALUES(2500.00,'2019-11-10','salary');
INSERT INTO income(amount,income_date,tag) VALUES(2600.00,'2019-10-10','salary');
INSERT INTO tag(name) VALUES('food');
INSERT INTO tag(name) VALUES('clothes');
INSERT INTO tag(name) VALUES('bus tickets');
INSERT INTO tag(name) VALUES('kindergarten');