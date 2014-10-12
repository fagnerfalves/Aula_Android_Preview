-- Creator:       MySQL Workbench 6.1.7/ExportSQLite plugin 2013.08.05
-- Author:        Felipe Lugão Eccard
-- Caption:       New Model
-- Project:       Name of the project
-- Changed:       2014-10-11 22:25
-- Created:       2014-10-11 00:12
PRAGMA foreign_keys = OFF;

-- Schema: Aula-android
BEGIN;

DROP TABLE IF EXISTS "Disciplina";

CREATE TABLE IF NOT EXISTS "Disciplina"(
  "_id" INTEGER PRIMARY KEY NOT NULL,
  "professor" VARCHAR(45),
  "nome" VARCHAR(45),
  "cargahoraria" INTEGER,
  "periodo" INTEGER
);

DROP TABLE IF EXISTS "Aluno";

CREATE TABLE IF NOT EXISTS "Aluno"(
  "matricula" INTEGER PRIMARY KEY NOT NULL,
  "nome" VARCHAR(45)
);

DROP TABLE IF EXISTS "Curso";

CREATE TABLE IF NOT EXISTS "Curso"(
  "codigo" INTEGER PRIMARY KEY NOT NULL,
  "nome" VARCHAR(45)
);

DROP TABLE IF EXISTS "Noticia";

CREATE TABLE IF NOT EXISTS "Noticia"(
  "codigo" INTEGER PRIMARY KEY NOT NULL,
  "nome" VARCHAR(45),
  "conteudo" TEXT,
  "data" VARCHAR(10),
  "hora" VARCHAR(5)
);

DROP TABLE IF EXISTS "Curso_has_Disciplina";

CREATE TABLE IF NOT EXISTS "Curso_has_Disciplina"(
  "Curso_codigo" INTEGER NOT NULL,
  "Disciplina__id" INTEGER NOT NULL,
  PRIMARY KEY("Curso_codigo","Disciplina__id"),
  CONSTRAINT "fk_Curso_has_Disciplina_Curso"
    FOREIGN KEY("Curso_codigo")
    REFERENCES "Curso"("codigo")
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT "fk_Curso_has_Disciplina_Disciplina1"
    FOREIGN KEY("Disciplina__id")
    REFERENCES "Disciplina"("_id")
);
CREATE INDEX "Curso_has_Disciplina.fk_Curso_has_Disciplina_Disciplina1_idx" ON "Curso_has_Disciplina"("Disciplina__id");
CREATE INDEX "Curso_has_Disciplina.fk_Curso_has_Disciplina_Curso_idx" ON "Curso_has_Disciplina"("Curso_codigo");

DROP TABLE IF EXISTS "Disciplina_has_Aluno";

CREATE TABLE IF NOT EXISTS "Disciplina_has_Aluno"(
  "Disciplina__id" INTEGER NOT NULL,
  "Aluno_matricula" INTEGER NOT NULL,
  PRIMARY KEY("Disciplina__id","Aluno_matricula"),
  CONSTRAINT "fk_Disciplina_has_Aluno_Disciplina1"
    FOREIGN KEY("Disciplina__id")
    REFERENCES "Disciplina"("_id")
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT "fk_Disciplina_has_Aluno_Aluno1"
    FOREIGN KEY("Aluno_matricula")
    REFERENCES "Aluno"("matricula")
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
CREATE INDEX "Disciplina_has_Aluno.fk_Disciplina_has_Aluno_Aluno1_idx" ON "Disciplina_has_Aluno"("Aluno_matricula");
CREATE INDEX "Disciplina_has_Aluno.fk_Disciplina_has_Aluno_Disciplina1_idx" ON "Disciplina_has_Aluno"("Disciplina__id");

DROP TABLE IF EXISTS "Curso_has_Noticia";

CREATE TABLE IF NOT EXISTS "Curso_has_Noticia"(
  "Curso_codigo" INTEGER NOT NULL,
  "Noticia_codigo" INTEGER NOT NULL,
  PRIMARY KEY("Curso_codigo","Noticia_codigo"),
  CONSTRAINT "fk_Curso_has_Noticia_Curso1"
    FOREIGN KEY("Curso_codigo")
    REFERENCES "Curso"("codigo")
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT "fk_Curso_has_Noticia_Noticia1"
    FOREIGN KEY("Noticia_codigo")
    REFERENCES "Noticia"("codigo")
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
CREATE INDEX "Curso_has_Noticia.fk_Curso_has_Noticia_Noticia1_idx" ON "Curso_has_Noticia"("Noticia_codigo");
CREATE INDEX "Curso_has_Noticia.fk_Curso_has_Noticia_Curso1_idx" ON "Curso_has_Noticia"("Curso_codigo");

DROP TABLE IF EXISTS "Aula";

CREATE TABLE IF NOT EXISTS "Aula"(
  "_id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "sala" VARCHAR(45),
  "dia" VARCHAR(45),
  "hora" VARCHAR(45),
  "idDisciplina" INTEGER NOT NULL,
  CONSTRAINT "fk_Aula_Disciplina1"
    FOREIGN KEY("idDisciplina")
    REFERENCES "Disciplina"("_id")
);
CREATE INDEX "Aula.fk_Aula_Disciplina1_idx" ON "Aula"("idDisciplina");

COMMIT;
