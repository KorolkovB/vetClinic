SELECT `user`.`id`,
       `user`.`login`,
       `user`.`password`,
       `user`.`isAdmin`,
       `user`.`isVet`,
       `user`.`isClient`,
       `user`.`vetId`,
       `user`.`clientId`
FROM `vetclinic`.`user`
WHERE `user`.`login` = ?