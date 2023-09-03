package com.project.simpleB.reply.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class Reply {
    private long rId;
    private long bId;
    private long mId;
    private String rContent;
    private Date rCreateDate;
    private Date rUpdateDate;
    private Long rParentId;
    private long rDept;
}
//SELECT *
//FROM REPLY
//WHERE B_ID = #{bId}
//START WITH R_PARENT_ID IS NULL
//CONNECT BY PRIOR R_ID = R_PARENT_ID
//ORDER SIBLINGS BY R_ID

//create
//    definer = SIMPLE_PRJ@localhost procedure replyHierarchy(IN bId int)
//BEGIN
//    WITH RECURSIVE hierarchy AS (
//        SELECT *, CAST(r_id AS CHAR(255)) AS path
//        FROM reply
//        WHERE r_parent_id IS NULL AND b_id = bId
//
//        UNION ALL
//
//        SELECT r.*,
//              CONCAT(h.path, ',', LPAD(r.r_id, 5, '0'))
//        FROM reply AS r
//              JOIN hierarchy AS h ON h.r_Id = r.r_parent_Id AND h.b_Id = bId
//    )
//    SELECT * FROM hierarchy ORDER BY path;
//END;

