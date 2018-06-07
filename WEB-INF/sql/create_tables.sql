-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE Users (
  id          CHAR(36)     PRIMARY KEY,
  username    VARCHAR(32)  NOT NULL UNIQUE,
  firstName   VARCHAR(32)  NOT NULL,
  lastName    VARCHAR(32)  NOT NULL,
  email       VARCHAR(128) NOT NULL,
  password    VARCHAR(128) NOT NULL,
  phoneNumber VARCHAR(24)  NOT NULL,
  role        VARCHAR(8)   NOT NULL DEFAULT 'USER'
);

CREATE TABLE Issues (
  id          CHAR(36)     PRIMARY KEY,
  authorId    CHAR(36)     NOT NULL,
  state       VARCHAR(24)  NOT NULL DEFAULT 'NEW',
  category    VARCHAR(24)  NOT NULL,
  subCategory VARCHAR(32)  NOT NULL,
  title       VARCHAR(128) NOT NULL,
  body        TEXT         NOT NULL,
  locked      BIT          NOT NULL DEFAULT 0
);

CREATE TABLE Articles (
  id          CHAR(36)     PRIMARY KEY,
  title       VARCHAR(128) NOT NULL,
  body        TEXT         NOT NULL,
  answer      TEXT         NOT NULL,
  helpfulness INT          NOT NULL DEFAULT 0,
  category    VARCHAR(24)  NOT NULL,
  subCategory VARCHAR(32)  NOT NULL
);

CREATE TABLE MaintenanceEvents (
  id          CHAR(36)     PRIMARY KEY,
  description TEXT         NOT NULL,
  startAt     DATETIME     NOT NULL,
  finishAt       DATETIME     NOT NULL
);

ALTER TABLE Issues ADD INDEX author_index (authorId);