UPDATE `vetclinic`.`client`
SET `firstName`      = ?,
    `lastName`       = ?,
    `passportSeries` = ?,
    `passportNumber` = ?,
    `phoneNumber`    = ?,
    `email`          = ?
WHERE `id` = ?