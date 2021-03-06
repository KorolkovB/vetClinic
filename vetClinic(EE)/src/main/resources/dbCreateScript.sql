DROP DATABASE IF EXISTS VetClinic;
CREATE DATABASE IF NOT EXISTS VetClinic;
use VetClinic;

CREATE TABLE IF NOT EXISTS veterinarian
(
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstName     VARCHAR(45)  NOT NULL,
    lastName      VARCHAR(45)  NOT NULL,
    hiringDate    date         NOT NULL,
    dismissalDate date,
    INDEX (lastName)
);

CREATE TABLE IF NOT EXISTS specialization
(
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50)  NOT NULL,
    INDEX (`name`)
);

CREATE TABLE IF NOT EXISTS vet_spec
(
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    vetId  INT UNSIGNED NOT NULL,
    specId INT UNSIGNED NOT NULL,
    FOREIGN KEY (vetId) REFERENCES veterinarian (id),
    FOREIGN KEY (specId) REFERENCES specialization (id),
    UNIQUE (vetId, specId)
);

CREATE TABLE IF NOT EXISTS `client`
(
    id             INT UNSIGNED     NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstName      VARCHAR(45)      NOT NULL,
    lastName       VARCHAR(45)      NOT NULL,
    passportSeries INT(4) UNSIGNED  NOT NULL,
    passportNumber INT(6) UNSIGNED  NOT NULL,
    phoneNumber    INT(11) UNSIGNED NOT NULL,
    email          VARCHAR(45),
    INDEX (lastName),
    UNIQUE (passportSeries, passportNumber)
);

CREATE TABLE IF NOT EXISTS kind
(
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    INDEX (`name`)
);

CREATE TABLE IF NOT EXISTS disease
(
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(150) NOT NULL,
    INDEX (`name`)
);

CREATE TABLE IF NOT EXISTS pet
(
    id        INT UNSIGNED    NOT NULL AUTO_INCREMENT PRIMARY KEY,
    kindId    INT UNSIGNED    NOT NULL,
    nickname  VARCHAR(45)     NOT NULL,
    age       INT(3) UNSIGNED NOT NULL,
    ownerId   INT UNSIGNED    NOT NULL,
    isDeleted BOOLEAN         NOT NULL DEFAULT FALSE,
    FOREIGN KEY (kindId) REFERENCES kind (id),
    FOREIGN KEY (ownerId) REFERENCES `client` (id),
    INDEX (nickname),
    UNIQUE (kindId, nickname, age, ownerId)
);

CREATE TABLE IF NOT EXISTS pet_disease
(
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    petId         INT UNSIGNED NOT NULL,
    diseaseId     INT UNSIGNED NOT NULL,
    isActive      BOOLEAN      NOT NULL DEFAULT TRUE,
    diagnosisDate date         NOT NULL,
    FOREIGN KEY (petId) REFERENCES pet (id),
    FOREIGN KEY (diseaseId) REFERENCES disease (id),
    UNIQUE (petId, diseaseId)
);

CREATE TABLE IF NOT EXISTS room
(
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50)  NOT NULL,
    INDEX (`name`)
);

CREATE TABLE IF NOT EXISTS visit
(
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    petId         INT UNSIGNED NOT NULL,
    vetId         INT UNSIGNED NOT NULL,
    roomId        INT UNSIGNED,
    visitDateTime datetime     NOT NULL,
    visited       BOOLEAN default false,
    canceledByClient       BOOLEAN default false,
    FOREIGN KEY (petId) REFERENCES pet (id),
    FOREIGN KEY (vetId) REFERENCES veterinarian (id),
    FOREIGN KEY (roomId) REFERENCES room (id)
);

CREATE TABLE IF NOT EXISTS `user`
(
    id         INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login      VARCHAR(50)  NOT NULL,
    `password` VARCHAR(10)  NOT NULL,
    isAdmin    BOOLEAN      NOT NULL,
    isVet      BOOLEAN      NOT NULL,
    isClient   BOOLEAN      NOT NULL,
    vetId      INT UNSIGNED,
    clientId   INT UNSIGNED,
    INDEX (login),
    FOREIGN KEY (vetId) REFERENCES veterinarian (id),
    FOREIGN KEY (clientId) REFERENCES `client` (id),
    UNIQUE (login),
    UNIQUE (vetId),
    UNIQUE (clientId)
);