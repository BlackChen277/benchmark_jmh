CREATE TABLE `person`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_name` varchar(32) NOT NULL DEFAULT '',
  `person_age` int(11) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) CHARACTER SET = utf8mb4;