DROP TABLE reply;
DROP TABLE board;
DROP TABLE member;

CREATE TABLE member(
                       m_id INT PRIMARY KEY KEY AUTO_INCREMENT,
                       m_name VARCHAR(20) NOT NULL,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL
);

CREATE TABLE board(
                      b_id INT PRIMARY KEY KEY AUTO_INCREMENT,
                      m_id INT NOT NULL,
                      b_title VARCHAR(30) NOT NULL,
                      b_content TEXT NOT NULL,
                      b_create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      b_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      b_views INT DEFAULT 0,
                      FOREIGN KEY (m_id) REFERENCES member(m_id)
);

CREATE TABLE reply(
                      r_id INT PRIMARY KEY KEY AUTO_INCREMENT,
                      b_id INT NOT NULL,
                      m_id INT NOT NULL,
                      r_content VARCHAR(255) NOT NULL,
                      r_create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      r_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      r_parent_id INT,
                      r_dept INT DEFAULT 0,
                      FOREIGN KEY (b_id) REFERENCES board(b_id),
                      FOREIGN KEY (m_id) REFERENCES member(m_id),
                      FOREIGN KEY (r_parent_id) REFERENCES reply(r_id)
);

DROP PROCEDURE replyHierarchy;

CREATE
    DEFINER = SIMPLE_PRJ@localhost PROCEDURE replyHierarchy(IN bId INT)
BEGIN
    WITH RECURSIVE hierarchy AS (
        SELECT *, CAST(LPAD(r_id, 5, '0') AS CHAR(255)) AS path
        FROM reply
        WHERE r_parent_id IS NULL AND b_id = bId

        UNION ALL

        SELECT r.*,
               CONCAT(h.path, ',', LPAD(r.r_Id, 5, '0'))
        FROM reply AS r
                 JOIN hierarchy AS h ON h.r_Id = r.r_parent_Id AND h.b_Id = bId
    )
    SELECT * FROM hierarchy ORDER BY path;
END;
COMMIT ;

CALL replyHierarchy(1);

