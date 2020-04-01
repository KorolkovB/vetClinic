SELECT `specialization`.`name`
FROM `specialization`
         join `vet_spec` on `specialization`.`id` = `vet_spec`.`specId`
WHERE `vet_spec`.`vetId` = ?