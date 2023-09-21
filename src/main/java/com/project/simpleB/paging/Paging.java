package com.project.simpleB.paging;

import com.project.simpleB.board.entity.Board;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class Paging {
    private int pageIndex;
    private int startRow;
    private int endRow;
    private int startPage;
    private int endPage;
    private int pageSize;
    private int totalCount;
    private List<?> list;

    public void handlePaging(int pageIndex, int pageSize) {
        this.pageIndex = Math.max(pageIndex, 1);
        this.pageSize = Math.max(pageSize, 1);
        this.startRow = ((this.pageIndex - 1) * this.pageSize) + 1;
        this.endRow = this.pageIndex * this.pageSize;
    }

    public void handlePagingList(List<?> list, int totalCount) {
        this.list = list;
        this.totalCount = totalCount;
        this.startPage = ((pageIndex - 1) / this.pageSize) * this.pageSize + 1;
        this.endPage = Math.min(startPage + this.pageSize - 1, this.totalCount);
    }
}
