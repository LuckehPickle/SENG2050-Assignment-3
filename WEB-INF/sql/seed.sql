-- noinspection SqlResolveForFile

-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO Users(id, username, firstName, lastName, email, password, phoneNumber)
VALUES ('03364a8a-d21e-4a66-ad22-1a4757ac3388', 'seanbailey', 'Sean', 'Bailey', 'sean@seanbailey.io', 'password', '12345678');

INSERT INTO Issues (id, authorId, category, subCategory, title, body)
VALUES ('e1ee9260-2082-4013-a7b6-f2b44315938c', '03364a8a-d21e-4a66-ad22-1a4757ac3388', 'NETWORK', 'CANT_CONNECT', 'Help, I''ve fallen and I can''t get up.', 'Please. I need some help. K thanx bye.'),
       ('d6ed113e-3b5a-473d-a33c-2f9def2aff4a', '03364a8a-d21e-4a66-ad22-1a4757ac3388', 'SOFTWARE', 'WONT_LOAD', 'My Microsoft Word is broken.', 'Idk what happened. It just won''t start up.');

INSERT INTO Articles (id, title, body, answer, helpfulness, category, subCategory)
VALUES ('f31a1c3e-d526-4de3-aa42-b6f5770c4068', 'Why does Linux Sux', 'Halp I jest dunt ud3rStnD', 'Just Dont thx its bud', 20, 'SOFTWARE', 'WONT_BOOT'),
       ('80b63a6c-032b-4d02-a6a2-1cb5eef31c4c', 'Posting Issue', 'How do I post a Issue', 'Just Dont thx its bud', 5, 'NETWORK', 'CANT_CONNECT'),
       ('e7f41ce0-28eb-4642-a480-bd9c60d03901','How to plagiarize an article without your fellow mates finding out','Hello fellow mates, it is I, Chit. How do I copy english text without being catched. A good GDay to you all','Chit pls', 9001, 'EMAIL', 'DISK_DRIVE');

INSERT INTO MaintenanceEvents (id, description, startAt, finishAt)
VALUES ('f31a1c3e-d526-4de3-aa42-b6f5770c4054','PINGUUUU PINNNNGUUUUUU YOU WILL ALL GET PINGUED','2016-06-1 07:27:39','2018-07-1 07:27:39'),
	('f31a2c3e-d526-4de3-aa42-b6f5770c4054','Prepare for a DDOS Attack','2018-06-1 07:27:39','2018-07-1 07:27:39'),
	('f31a3c3e-d526-4de3-aa42-b6f5770c4054','Website down due to file type encryption to .Crabs','2018-06-1 07:27:39','2018-07-1 07:27:39'),
	('f34a1c3e-d526-4de3-aa42-b6f5770c4054','Site shut down due to Hax','2018-06-1 07:27:39','2018-07-1 07:27:39');
