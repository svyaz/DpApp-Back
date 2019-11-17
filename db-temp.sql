-- CREATE USER
CREATE USER "DP_APP" IDENTIFIED BY "password";
GRANT CONNECT, RESOURCE TO "DP_APP";

-- CREATE TABLE BANK
CREATE TABLE "DP_APP"."BANK" (
    "ID" NUMBER NOT NULL ENABLE,
	"NAME" VARCHAR2(100 BYTE) NOT NULL ENABLE,
    CONSTRAINT "BANK_PK" PRIMARY KEY ("ID")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
    STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
    PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
    TABLESPACE "SYSTEM"  ENABLE
) SEGMENT CREATION IMMEDIATE
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
TABLESPACE "SYSTEM";

COMMENT ON COLUMN "DP_APP"."BANK"."ID" IS 'Идентификатор банка';
COMMENT ON COLUMN "DP_APP"."BANK"."NAME" IS 'Название банка';

CREATE SEQUENCE  "DP_APP"."BANK_SEQ"
    MINVALUE 1 MAXVALUE 9999999999999999999999999999
    INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

CREATE OR REPLACE TRIGGER "DP_APP"."BANK_TRG"
    BEFORE INSERT ON BANK
    FOR EACH ROW
    BEGIN
        <<COLUMN_SEQUENCES>>
        BEGIN
            IF INSERTING AND :NEW.ID IS NULL THEN
                SELECT BANK_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
            END IF;
        END COLUMN_SEQUENCES;
    END;
/
ALTER TRIGGER "DP_APP"."BANK_TRG" ENABLE;

-- CREATE TABLE COUNTRY
CREATE TABLE "DP_APP"."COUNTRY"
   (	"ID" NUMBER NOT NULL ENABLE,
	"NAME" VARCHAR2(100 BYTE) NOT NULL ENABLE
   ) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

   COMMENT ON COLUMN "DP_APP"."COUNTRY"."ID" IS 'Идентификатор страны';
   COMMENT ON COLUMN "DP_APP"."COUNTRY"."NAME" IS 'Название страны';

-- CREATE TABLE CITY
CREATE TABLE "DP_APP"."CITY"
   (	"ID" NUMBER NOT NULL ENABLE,
	"NAME" VARCHAR2(100 BYTE) NOT NULL ENABLE,
	"COUNTRY_ID" NUMBER NOT NULL ENABLE
   ) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

   COMMENT ON COLUMN "DP_APP"."CITY"."ID" IS 'Идентификатор города';
   COMMENT ON COLUMN "DP_APP"."CITY"."NAME" IS 'Название города';
   COMMENT ON COLUMN "DP_APP"."CITY"."COUNTRY_ID" IS 'Идентификатор страны';

-- CREATE TABLE DPSERVICE

  CREATE TABLE "DP_APP"."DPSERVICE"
   (	"ID" NUMBER NOT NULL ENABLE,
	"NAME" VARCHAR2(100 BYTE) NOT NULL ENABLE
   ) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

   COMMENT ON COLUMN "DP_APP"."DPSERVICE"."ID" IS 'Идентификатор сервиса ДП';
   COMMENT ON COLUMN "DP_APP"."DPSERVICE"."NAME" IS 'Название сервиса ДП';

-- CREATE TABLE DPPOINT
CREATE TABLE "DP_APP"."DPPOINT"
   (	"ID" NUMBER NOT NULL ENABLE,
	"NAME" VARCHAR2(100 BYTE) NOT NULL ENABLE,
	"ADDRESS" VARCHAR2(100 BYTE) NOT NULL ENABLE,
	"CITY_ID" NUMBER NOT NULL ENABLE,
	"BANK_ID" NUMBER NOT NULL ENABLE
   ) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

   COMMENT ON COLUMN "DP_APP"."DPPOINT"."ID" IS 'Идентификатор точки ДП';
   COMMENT ON COLUMN "DP_APP"."DPPOINT"."NAME" IS 'Название точки ДП';
   COMMENT ON COLUMN "DP_APP"."DPPOINT"."ADDRESS" IS 'Адрес точки ДП';
   COMMENT ON COLUMN "DP_APP"."DPPOINT"."CITY_ID" IS 'Идентификатор города';
   COMMENT ON COLUMN "DP_APP"."DPPOINT"."BANK_ID" IS 'Идентификатор банка';

-- CREATE TABLE DPPOINT_PDSERVICE
CREATE TABLE "DP_APP"."DPPOINT_DPSERVICE"
   (	"DPPOINT" NUMBER NOT NULL ENABLE,
	"DPSERVICE" NUMBER NOT NULL ENABLE
   ) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

   COMMENT ON COLUMN "DP_APP"."DPPOINT_DPSERVICE"."DPPOINT" IS 'Идентификатор точки ДП';
   COMMENT ON COLUMN "DP_APP"."DPPOINT_DPSERVICE"."DPSERVICE" IS 'Идентификатор сервиса ДП';
