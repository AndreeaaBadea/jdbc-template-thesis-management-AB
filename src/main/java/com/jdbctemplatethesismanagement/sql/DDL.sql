--CREATE TABLE teachers (
--    id_teacher BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
--    first_name VARCHAR(255),
--    last_name VARCHAR(255),
--    email VARCHAR(255),
--    cnp VARCHAR(255),
--    number_of_students INT
-- );

--CREATE TABLE projects (
--   id_project BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
--   project_title VARCHAR(255) NOT NULL,
--   project_description VARCHAR(255) NOT NULL,
--   project_availability TINYINT NOT NULL,
--   id_teacher INT NULL,
--   PRIMARY KEY (`id_project`),
--   INDEX `fk_id_teacher_idx` (`id_teacher` ASC) VISIBLE,
--   CONSTRAINT `fk_id_teacher`
--   FOREIGN KEY (`id_teacher`)
--   REFERENCES `thesis-management`.`teachers` (`id_teacher`)
--   ON DELETE NO ACTION
--   ON UPDATE NO ACTION
--  );