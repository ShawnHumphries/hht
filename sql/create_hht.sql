-- create and select the database
DROP DATABASE IF EXISTS hht;
CREATE DATABASE hht;
USE hht;

-- create the golf_scores table
CREATE TABLE golf_scores (
  ID			INT				PRIMARY KEY  AUTO_INCREMENT,
  Date			DATE			NOT NULL,
  Course		VARCHAR(100)	NOT NULL,
  Front9Score	INT,
  Back9Score	INT,
  TotalScore	INT				NOT NULL,
  Rating		DECIMAL(10,1)	NOT NULL,
  Slope			INT				NOT NULL,
  Differential	DECIMAL(10,1)	NOT NULL,
  IsCounted		BIT(1)			NOT NULL
);

-- create a user and grant privileges to that user
GRANT SELECT, INSERT, DELETE, UPDATE
ON hht.*
TO hht_user@localhost
IDENTIFIED BY 'Lemon123';
