SELECT `disease`.`name`,
       `pet_disease`.`isActive`
FROM `vetclinic`.`disease`
         join `vetclinic`.`pet_disease` on `disease`.`id` = `pet_disease`.`diseaseId`
         join `vetclinic`.`pet` on `pet_disease`.`petId` = `pet`.`id`
where `pet`.`id` = ?