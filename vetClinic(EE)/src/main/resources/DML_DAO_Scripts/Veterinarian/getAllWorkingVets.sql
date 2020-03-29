SELECT `veterinarian`.`id`,
       `veterinarian`.`firstName`,
       `veterinarian`.`lastName`,
       `veterinarian`.`hiringDate`,
       `veterinarian`.`dismissalDate`
FROM `vetclinic`.`veterinarian`
WHERE `veterinarian`.`dismissalDate` > now()
  and `veterinarian`.`hiringDate` < now()