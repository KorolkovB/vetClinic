UPDATE `vetclinic`.`visit`
SET
    `canceledByClient` = true
WHERE `id` = ?