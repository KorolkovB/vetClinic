INSERT INTO `vetclinic`.`kind`
    (`name`)
VALUES ('Vambat'),
       ('Siberian cat'),
       ('German shepherd'),
       ('Black Mamba'),
       ('Chinese softshell turtle');

INSERT INTO `vetclinic`.`disease`
    (`name`)
VALUES ('Baldness'),
       ('Deafness'),
       ('Leg fracture'),
       ('Intoxication'),
       ('Head bruise');

INSERT INTO `vetclinic`.`room`
    (`name`)
VALUES ('Inspection room'),
       ('Surgical'),
       ('Treatment room'),
       ('Еherapy room'),
       ('X-ray room');

INSERT INTO `vetclinic`.`specialization`
    (`name`)
VALUES ('Therapist'),
       ('Surgeon'),
       ('Treatment room'),
       ('Anesthetist'),
       ('ENT doctor');

INSERT INTO `vetclinic`.`veterinarian`
    (`firstName`, `lastName`, `hiringDate`, `dismissalDate`)
VALUES ('Thomas', 'Smith', '2016-05-03', null),
       ('James', 'Miller', '2010-01-15', '2018-05-03'),
       ('Sophia', 'White', '2019-09-23', null),
       ('Isabelle', 'Wood', '2017-11-05', null),
       ('Oliver', 'Morgan', '2015-12-25', null);

INSERT INTO `vetclinic`.`client`
(`firstName`, `lastName`, `passportSeries`, `passportNumber`, `phoneNumber`, `email`)
VALUES ('Maddison', 'Hill', 4689, 569312, 984213356, 'Maddison.Hill@gmail.com'),
       ('Joshua', 'Jackson', 2003, 135487, 942364528, 'joshua.jackson@gmail.com'),
       ('Ruby', 'Scott', 9634, 466872, 978522365, 'Ruby.Scott@gmail.com'),
       ('Jacob', 'Green', 1456, 754365, 975631598, 'Jacob.Green@gmail.com'),
       ('William', 'Turner', 8921, 941236, 961532156, 'William.Turner@gmail.com');

INSERT INTO `vetclinic`.`vet_spec`
    (`vetId`, `specId`)
VALUES (1, 4),
       (1, 2),
       (2, 1),
       (2, 4),
       (3, 5),
       (4, 1),
       (5, 3);

INSERT INTO `vetclinic`.`pet`
    (`kindId`, `nickname`, `age`, `ownerId`, `isDeleted`)
VALUES (1, 'Babur', 4, 1, 0),
       (3, 'Badboy', 2, 1, 0),
       (3, 'Rocket', 2, 1, 1),
       (2, 'Fang', 5, 2, 0),
       (3, 'Rufus', 7, 3, 0),
       (4, 'Abraxas', 2, 4, 0),
       (5, 'Swift', 10, 5, 0);

INSERT INTO `vetclinic`.`visit`
(`petId`, `vetId`, `roomId`, `visitDateTime`, `visited`, `canceledByClient`)
VALUES (1, 2, 5, '2019-09-23 10:30:00', true, false),
       (1, 2, 2, '2021-09-23 10:30:00', false, false),
       (2, 3, 4, '2019-10-11 15:40:00', true, false),
       (3, 1, null, '2019-12-10 08:10:00', false, true),
       (4, 5, 2, '2020-01-28 10:30:00', true, false),
       (5, 4, 1, '2020-04-01 10:30:00', true, false);

INSERT INTO `vetclinic`.`pet_disease`
    (`petId`, `diseaseId`, `isActive`, `diagnosisDate`)
VALUES (1, 2, 1, '2019-09-23'),
       (1, 1, 1, '2019-09-23'),
       (1, 4, 0, '2019-09-23'),
       (2, 1, 1, '2019-09-23'),
       (3, 2, 1, '2019-09-23'),
       (4, 3, 1, '2019-10-10'),
       (5, 1, 1, '2019-12-09'),
       (5, 5, 0, '2019-12-09'),
       (6, 5, 1, '2020-01-20'),
       (7, 4, 1, '2020-03-01');

INSERT INTO `vetclinic`.`user`
(`login`, `password`, `isAdmin`, `isVet`, `isClient`, `vetId`, `clientId`)
VALUES ('admin', 'admin', true, false, false, null, null),
       ('Smith', 'Smith', false, true, false, 1, null),
       ('Miller', 'Miller', false, true, false, 2, null),
       ('White', 'White', false, true, false, 3, null),
       ('Wood', 'Wood', false, true, false, 4, null),
       ('Morgan', 'Morgan', false, true, false, 5, null),
       ('Hill', 'Hill', false, false, true, null, 1),
       ('Jackson', 'Jackson', false, false, true, null, 2),
       ('Scott', 'Scott', false, false, true, null, 3),
       ('Green', 'Green', false, false, true, null, 4),
       ('Turner', 'Turner', false, false, true, null, 5);