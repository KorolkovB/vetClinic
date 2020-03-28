SELECT `client`.`id`,
       `client`.`firstName`,
       `client`.`lastName`,
       `client`.`passportSeries`,
       `client`.`passportNumber`,
       `client`.`phoneNumber`,
       `client`.`email`
FROM `vetclinic`.`client`
WHERE `client`.`id` = ?