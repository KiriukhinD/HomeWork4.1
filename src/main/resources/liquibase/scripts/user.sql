--liquibase formatted sql
--changeset jrembo:1
CREATE INDEX student_index ON student (name);
CREATE INDEX faculty_index ON faculty (color);
