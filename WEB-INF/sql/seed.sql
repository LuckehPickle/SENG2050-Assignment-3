-- noinspection SqlResolveForFile

-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO Users(id, username, firstName, lastName, email, password, phoneNumber)
VALUES ('03364a8a-d21e-4a66-ad22-1a4757ac3388', 'seanbailey', 'Sean', 'Bailey', 'sean@seanbailey.io', 'password', '12345678');

INSERT INTO Issues (id, authorId, category, subCategory, title, body)
VALUES ('e1ee9260-2082-4013-a7b6-f2b44315938c', '03364a8a-d21e-4a66-ad22-1a4757ac3388', 'NETWORK', 'CANT_CONNECT', 'Help, I''ve fallen and I can''t get up.', 'Please. I need some help. K thanx bye.'),
       ('d6ed113e-3b5a-473d-a33c-2f9def2aff4a', '03364a8a-d21e-4a66-ad22-1a4757ac3388', 'SOFTWARE', 'WONT_LOAD', 'My Microsoft Word is broken.', 'Idk what happened. It just won''t start up.');