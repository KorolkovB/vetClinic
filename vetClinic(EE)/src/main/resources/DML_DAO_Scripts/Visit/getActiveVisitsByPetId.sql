SELECT `visit`.`id`,
       `visit`.`visitDateTime`,
       `veterinarian`.`firstName`,
       `veterinarian`.`lastName`
FROM `vetclinic`.`visit`
         join `vetclinic`.`veterinarian` on `visit`.`vetId` = `veterinarian`.`id`
WHERE `visit`.`visited` = false
  and `visit`.`visitDateTime` > now()
  and `visit`.`canceledByClient` = false
  and `visit`.`petId` = ?