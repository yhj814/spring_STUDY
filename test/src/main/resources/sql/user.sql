CREATE SEQUENCE SEQ_USER;

CREATE TABLE TBL_USER(
    ID NUMBER CONSTRAINT PK_USER PRIMARY KEY,
    USER_EMAIL VARCHAR2(255) NOT NULL,
    USER_NAME VARCHAR2(255) NOT NULL,
    USER_NICKNAME VARCHAR2(255) NOT NULL,
    USER_PHONE VARCHAR2(255) NOT NULL,
    USER_PASSWORD VARCHAR2(255) NOT NULL
);

SELECT *FROM TBL_USER;