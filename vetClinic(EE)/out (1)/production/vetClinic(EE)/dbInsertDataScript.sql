INSERT INTO `vetclinic`.`kind`
(`name`)
VALUES
('Vambat'),('Siberian cat'),('German shepherd'),('Black Mamba'),('Chinese softshell turtle');

INSERT INTO `vetclinic`.`disease`
(`name`)
VALUES
('Baldness'),('Deafness'),('Leg fracture'),('Intoxication'),('Head bruise');

INSERT INTO `vetclinic`.`room`
(`name`)
VALUES
('Inspection room'),('Surgical'),('Treatment room'),('Еherapy room'),('X-ray room');

INSERT INTO `vetclinic`.`specialization`
(`name`)
VALUES
('Therapist'),('Surgeon'),('Treatment room'),('Anesthetist'),('ENT doctor');

INSERT INTO `vetclinic`.`veterinarian`
(`firstName`,`lastName`,`hiringDate`,`dismissalDate`)
VALUES
('Thomas','Smith','2016-05-03',null),
('James','Miller','2010-01-15','2018-05-03'),
('Sophia','White','2019-09-23',null),
('Isabelle','Wood','2017-11-05',null),
('Oliver','Morgan','2015-12-25',null);

INSERT INTO `vetclinic`.`client`
(`firstName`,`lastName`,`passportSerie`,`passportNumber`,`phoneNumber`,`email`)
VALUES
('Maddison','Hill',4689,569312,984213356,'Maddison.Hill@gmail.com'),
('Joshua','Jackson',2003,135487,942364528,'joshua.jackson@gmail.com'),
('Ruby','Scott',9634,466872,978522365,'Ruby.Scott@gmail.com'),
('Jacob','Green',1456,754365,975631598,'Jacob.Green@gmail.com'),
('William','Turner',8921,941236,961532156,'William.Turner@gmail.com');

INSERT INTO `vetclinic`.`vet_spec`
(`vetId`,`specId`)
VALUES
(1,4),(1,2),(2,1),(2,4),(3,5),(4,1),(5,3);

INSERT INTO `vetclinic`.`pet`
(`kindId`,`nickname`,`age`,`ownerId`)
VALUES
(1,'Babur',4,1),
(2,'Fang',5,2),
(3,'Rufus',7,3),
(4,'Abraxas',2,4),
(5,'Swift',10,5);

INSERT INTO `vetclinic`.`visit`
(`petId`,`vetId`,`roomId`,`visitDateTime`,`visited`)
VALUES
(1,2,5,'2019-09-23 10:30:00',true),
(2,3,4,'2019-10-11 15:40:00',true),
(3,1,3,'2019-12-10 08:10:00',false),
(4,5,2,'2020-01-28 10:30:00',true),
(5,4,1,'2020-04-01 10:30:00',true);

INSERT INTO `vetclinic`.`pet_disease`
(`petId`,`diseaseId`,`isActive`,`diagnosisDate`)
VALUES
(1,2,0,'2019-09-23'),
(1,4,0,'2019-09-23'),
(2,3,0,'2019-10-10'),
(3,1,1,'2019-12-09'),
(3,5,0,'2019-12-09'),
(4,5,0,'2020-01-20'),
(5,4,1,'2020-03-01');