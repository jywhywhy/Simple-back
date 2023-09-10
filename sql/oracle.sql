DROP TABLE file_info;
DROP TABLE reply;
DROP TABLE board;
DROP TABLE member;

DROP SEQUENCE seq_file_info;
DROP SEQUENCE seq_reply;
DROP SEQUENCE seq_board;
DROP SEQUENCE seq_member;

DROP TRIGGER trg_file_info;
DROP TRIGGER trg_reply;
DROP TRIGGER trg_board;
DROP TRIGGER trg_member;

CREATE SEQUENCE seq_file_info
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE seq_reply
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE seq_board
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE seq_member
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE member(
                       m_id NUMBER PRIMARY KEY ,
                       m_name varchar2(20) NOT NULL ,
                       username varchar2(50) NOT NULL UNIQUE ,
                       password varchar2(100) NOT NULL
);

CREATE TABLE board(
                      b_id NUMBER PRIMARY KEY ,
                      m_id NUMBER NOT NULL REFERENCES member(m_id) ,
                      b_title VARCHAR2(30) NOT NULL ,
                      b_content CLOB NOT NULL ,
                      b_create_date DATE DEFAULT SYSDATE ,
                      b_update_date DATE DEFAULT SYSDATE ,
                      b_views NUMBER DEFAULT 0
);

CREATE TABLE reply(
                      r_id NUMBER PRIMARY KEY ,
                      b_id NUMBER NOT NULL REFERENCES board(b_id) ,
                      m_id NUMBER NOT NULL REFERENCES member(m_id) ,
                      r_content varchar2(255) NOT NULL ,
                      r_create_date DATE DEFAULT SYSDATE ,
                      r_update_date DATE DEFAULT SYSDATE ,
                      r_parent_id NUMBER REFERENCES reply(r_id) ,
                      r_dept NUMBER DEFAULT 0
);

CREATE TABLE file_info(
                          f_id NUMBER PRIMARY KEY ,
                          b_id NUMBER NOT NULL REFERENCES board(b_id) ,
                          originalName varchar2(50) NOT NULL ,
                          saveName varchar2(100) NOT NULL
);

CREATE OR Replace TRIGGER trg_file_info
    BEFORE INSERT ON file_info
    FOR EACH ROW
BEGIN
    :NEW.f_id := seq_file_info.NEXTVAL;
END;

CREATE OR REPLACE TRIGGER trg_reply
    BEFORE INSERT ON reply
    FOR EACH ROW
BEGIN
    :NEW.r_id := seq_reply.NEXTVAL;
END;

CREATE OR REPLACE TRIGGER trg_board
    BEFORE INSERT ON board
    FOR EACH ROW
BEGIN
    :NEW.b_id := seq_board.NEXTVAL;
END;

CREATE OR REPLACE TRIGGER trg_member
    BEFORE INSERT ON member
    FOR EACH ROW
BEGIN
    :NEW.m_id := seq_member.NEXTVAL;
END;

SELECT *
FROM reply
START WITH r_parent_id IS NULL
CONNECT BY PRIOR r_id = r_parent_id
ORDER SIBLINGS BY r_id;

COMMIT;

