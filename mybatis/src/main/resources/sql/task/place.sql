CREATE SEQUENCE SEQ_PLACE;

CREATE TABLE TBL_PLACE(
    ID NUMBER CONSTRAINT PK_PLACE PRIMARY KEY,
    PLACE_DETAIL VARCHAR2(255) NOT NULL,
    PLACE_NAME VARCHAR2(255) NOT NULL,
    PLACE_PRICE NUMBER NOT NULL
);

SELECT *FROM TBL_PLACE;