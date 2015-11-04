--
-- Create Schema Script 
--   Database Version          : 11.2.0.2.0 
--   Database Compatible Level : 11.2.0.0.0 
--   Script Compatible Level   : 11.2.0.0.0 
--   Toad Version              : 11.6.0.43 
--   DB Connect String         : XE 
--   Schema                    : BOOK_SHOP 
--   Script Created by         : BOOK_SHOP 
--   Script Created at         : 04.11.2015 22:22:46 
--   Physical Location         :  
--   Notes                     :  
--

-- Object Counts: 
--   Roles: 3           Sys Privs: 211      Roles: 12           Obj Privs: 0 
--   Users: 1           Sys Privs: 1        Roles: 3            Tablespace Quotas: 1 
--   Tablespaces: 2     DataFiles: 1        TempFiles: 1 
-- 
--   Directories: 4 
--   Indexes: 3         Columns: 3          
--   Object Privileges: 3 
--   Sequences: 3 
--   Tables: 3          Columns: 10         Constraints: 8      
--   Triggers: 1 


-- "Set define off" turns off substitution variables. 
Set define off; 

--
-- BOOK_SHOP  (User) 
--
CREATE USER BOOK_SHOP
  IDENTIFIED BY <password>
  DEFAULT TABLESPACE USERS
  TEMPORARY TABLESPACE TEMP
  PROFILE DEFAULT
  ACCOUNT UNLOCK;
  -- 3 Roles for BOOK_SHOP 
  GRANT CONNECT TO BOOK_SHOP;
  GRANT DBA TO BOOK_SHOP;
  GRANT RESOURCE TO BOOK_SHOP;
  ALTER USER BOOK_SHOP DEFAULT ROLE ALL;
  -- 1 System Privilege for BOOK_SHOP 
  GRANT UNLIMITED TABLESPACE TO BOOK_SHOP;
  -- 1 Tablespace Quota for BOOK_SHOP 
  ALTER USER BOOK_SHOP QUOTA UNLIMITED ON USERS;




--
-- GEN_AUTHOR_ID  (Sequence) 
--
CREATE SEQUENCE BOOK_SHOP.GEN_AUTHOR_ID
  START WITH 1
  MAXVALUE 9999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  ORDER;


--
-- GEN_BOOK_ISBN  (Sequence) 
--
CREATE SEQUENCE BOOK_SHOP.GEN_BOOK_ISBN
  START WITH 2
  MAXVALUE 9999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  NOCACHE
  ORDER;


--
-- GEN_BOOK_TO_AUTHOR_ID  (Sequence) 
--
CREATE SEQUENCE BOOK_SHOP.GEN_BOOK_TO_AUTHOR_ID
  START WITH 1
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;


--
-- AUTHOR  (Table) 
--
CREATE TABLE BOOK_SHOP.AUTHOR
(
  ID          INTEGER,
  FIRST_NAME  VARCHAR2(100 CHAR),
  LAST_NAME   VARCHAR2(100 CHAR),
  SHURNAME    VARCHAR2(100 CHAR)
)
TABLESPACE USERS
RESULT_CACHE (MODE DEFAULT)
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
            FLASH_CACHE      DEFAULT
            CELL_FLASH_CACHE DEFAULT
           )
NOCOMPRESS ;


--
-- BOOK  (Table) 
--
CREATE TABLE BOOK_SHOP.BOOK
(
  ISBN       INTEGER,
  NAME       VARCHAR2(255 CHAR)                 NOT NULL,
  AUTHOR_ID  INTEGER                            NOT NULL
)
TABLESPACE USERS
RESULT_CACHE (MODE DEFAULT)
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
            FLASH_CACHE      DEFAULT
            CELL_FLASH_CACHE DEFAULT
           )
NOCOMPRESS ;


--
-- BOOK_ISBN_PK  (Index) 
--
CREATE UNIQUE INDEX BOOK_SHOP.BOOK_ISBN_PK ON BOOK_SHOP.BOOK
(ISBN)
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
            FLASH_CACHE      DEFAULT
            CELL_FLASH_CACHE DEFAULT
           );


--
-- AUTHOR_ID_PK  (Index) 
--
CREATE UNIQUE INDEX BOOK_SHOP.AUTHOR_ID_PK ON BOOK_SHOP.AUTHOR
(ID)
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
            FLASH_CACHE      DEFAULT
            CELL_FLASH_CACHE DEFAULT
           );


--
-- BOOK_TO_AUTHOR  (Table) 
--
CREATE TABLE BOOK_SHOP.BOOK_TO_AUTHOR
(
  ID         INTEGER,
  BOOK_ID    INTEGER,
  AUTHOR_ID  INTEGER
)
TABLESPACE USERS
RESULT_CACHE (MODE DEFAULT)
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
            FLASH_CACHE      DEFAULT
            CELL_FLASH_CACHE DEFAULT
           )
NOCOMPRESS ;


--
-- BOOK_TO_AUTHOR_ID_PK  (Index) 
--
CREATE UNIQUE INDEX BOOK_SHOP.BOOK_TO_AUTHOR_ID_PK ON BOOK_SHOP.BOOK_TO_AUTHOR
(ID)
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
            FLASH_CACHE      DEFAULT
            CELL_FLASH_CACHE DEFAULT
           );


--
-- TR_BOOK_TO_AUTHOR  (Trigger) 
--
CREATE OR REPLACE TRIGGER BOOK_SHOP.TR_BOOK_TO_AUTHOR
BEFORE INSERT
ON BOOK_SHOP.BOOK_TO_AUTHOR
REFERENCING NEW AS New OLD AS Old
FOR EACH ROW
BEGIN
-- For Toad:  Highlight column ID
  :new.ID := GEN_BOOK_TO_AUTHOR_ID.nextval;
END TR_BOOK_TO_AUTHOR;
/


-- 
-- Non Foreign Key Constraints for Table AUTHOR 
-- 
ALTER TABLE BOOK_SHOP.AUTHOR ADD (
  CONSTRAINT AUTHOR_ID_PK
  PRIMARY KEY
  (ID)
  USING INDEX BOOK_SHOP.AUTHOR_ID_PK
  ENABLE VALIDATE);


-- 
-- Non Foreign Key Constraints for Table BOOK 
-- 
ALTER TABLE BOOK_SHOP.BOOK ADD (
  CONSTRAINT BOOK_ISBN_PK
  PRIMARY KEY
  (ISBN)
  USING INDEX BOOK_SHOP.BOOK_ISBN_PK
  ENABLE VALIDATE);


-- 
-- Non Foreign Key Constraints for Table BOOK_TO_AUTHOR 
-- 
ALTER TABLE BOOK_SHOP.BOOK_TO_AUTHOR ADD (
  CONSTRAINT BOOK_TO_AUTHOR_ID_PK
  PRIMARY KEY
  (ID)
  USING INDEX BOOK_SHOP.BOOK_TO_AUTHOR_ID_PK
  ENABLE VALIDATE);


-- 
-- Foreign Key Constraints for Table BOOK 
-- 
ALTER TABLE BOOK_SHOP.BOOK ADD (
  CONSTRAINT BOOK_AUTHOR_ID_FK 
  FOREIGN KEY (AUTHOR_ID) 
  REFERENCES BOOK_SHOP.AUTHOR (ID)
  ENABLE VALIDATE);


-- 
-- Foreign Key Constraints for Table BOOK_TO_AUTHOR 
-- 
ALTER TABLE BOOK_SHOP.BOOK_TO_AUTHOR ADD (
  CONSTRAINT BOOK_TO_AUTHOR_BOOK_FK 
  FOREIGN KEY (BOOK_ID) 
  REFERENCES BOOK_SHOP.BOOK (ISBN)
  ENABLE VALIDATE);

ALTER TABLE BOOK_SHOP.BOOK_TO_AUTHOR ADD (
  CONSTRAINT BOOK_TO_AUTHOR_AUTHOR_FK 
  FOREIGN KEY (AUTHOR_ID) 
  REFERENCES BOOK_SHOP.AUTHOR (ID)
  ENABLE VALIDATE);
