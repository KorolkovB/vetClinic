SELECT `client`.`firstName` as `clientFirstName`,
       `client`.`lastName`  as `clientLastName`,
       `kind`.`name`        as `petKind`,
       `pet`.`nickname`     as `petNickname`,
       `pet`.`age`          as `petAge`,
       `room`.`name`        as `roomName`,
       `visit`.`visitDateTime`,
       `visit`.`visited`
FROM `vetclinic`.`visit`
         join `vetclinic`.`pet` on `vetclinic`.`visit`.`petId` = `vetclinic`.`pet`.`id`
         join `vetclinic`.`client` on `vetclinic`.`pet`.`ownerId` = `vetclinic`.`client`.`id`
         join `vetclinic`.`kind` on `vetclinic`.`pet`.`kindId` = `vetclinic`.`kind`.`id`
         left join `vetclinic`.`room` on `vetclinic`.`visit`.`roomId` = `vetclinic`.`room`.`id`
where `visit`.`canceledByClient` = false
  and `pet`.`isDeleted` = false
  and `visit`.`vetId` = ?
order by `visit`.`visitDateTime` desc