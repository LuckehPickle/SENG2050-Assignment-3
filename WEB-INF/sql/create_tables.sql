-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE Users (
  id          CHAR(36)     PRIMARY KEY,
  username    VARCHAR(32)  NOT NULL UNIQUE,
  firstName   VARCHAR(32)  NOT NULL,
  lastName    VARCHAR(32)  NOT NULL,
  email       VARCHAR(128) NOT NULL,
  password    VARCHAR(128) NOT NULL,
  phoneNumber VARCHAR(24)  NOT NULL,
  role        VARCHAR(8)   NOT NULL DEFAULT 'USER',
  createdAt   DATETIME     NOT NULL DEFAULT '2018-06-8 13:30:00',
  updatedAt   DATETIME     NOT NULL DEFAULT '2018-06-8 13:30:00'
);

CREATE TABLE Issues (
  id          CHAR(36)     PRIMARY KEY,
  authorId    CHAR(36)     NOT NULL,
  state       VARCHAR(24)  NOT NULL DEFAULT 'NEW',
  category    VARCHAR(24)  NOT NULL,
  subCategory VARCHAR(32)  NOT NULL,
  title       VARCHAR(80) NOT NULL,
  body        TEXT         NOT NULL,
  answerId    CHAR(36),
  locked      BIT          NOT NULL DEFAULT 0,
  createdAt   DATETIME     NOT NULL DEFAULT '2018-06-8 13:30:00',
  updatedAt   DATETIME     NOT NULL DEFAULT '2018-06-8 13:30:00'
);

ALTER TABLE Issues ADD INDEX issue_author_index (authorId);

CREATE TABLE Comments (
  id        CHAR(36) PRIMARY KEY,
  authorId  CHAR(36) NOT NULL,
  issueId   CHAR(36) NOT NULL,
  body      TEXT     NOT NULL,
  edited    BIT      NOT NULL DEFAULT 0,
  createdAt DATETIME NOT NULL DEFAULT '2018-06-8 13:30:00',
  updatedAt DATETIME NOT NULL DEFAULT '2018-06-8 13:30:00'
);

ALTER TABLE Comments ADD INDEX comment_author_index (authorId);
ALTER TABLE Comments ADD INDEX comment_issue_index (issueId);

CREATE TABLE Articles (
  id          CHAR(36)    PRIMARY KEY,
  title       VARCHAR(80) NOT NULL,
  body        TEXT        NOT NULL,
  answer      TEXT        NOT NULL,
  helpfulness INT         NOT NULL DEFAULT 0,
  category    VARCHAR(24) NOT NULL,
  subCategory VARCHAR(32) NOT NULL,
  publisher   VARCHAR(64) NOT NULL,
  createdAt   DATETIME    NOT NULL DEFAULT '2018-06-8 13:30:00',
  updatedAt   DATETIME    NOT NULL DEFAULT '2018-06-8 13:30:00'
);

CREATE TABLE MaintenanceEvents (
  id          CHAR(36)     PRIMARY KEY,
  title       VARCHAR(256) NOT NULL,
  startAt     DATETIME     NOT NULL,
  finishAt    DATETIME     NOT NULL,
  createdAt   DATETIME     NOT NULL DEFAULT '2018-06-8 13:30:00',
  updatedAt   DATETIME     NOT NULL DEFAULT '2018-06-8 13:30:00'
);