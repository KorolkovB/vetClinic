SELECT `pet`.`id`    as petId,
       `pet`.`nickname`,
       `pet`.`age`,
       `kind`.`name` as kindName
FROM `vetclinic`.`pet`
         join `vetclinic`.`kind` on `pet`.`kindId` = `kind`.`id`
where `pet`.`ownerId` = ?