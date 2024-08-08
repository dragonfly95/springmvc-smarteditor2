package com.system.blog.config;

public class PageVO {
    public int page = 1;
    public int size = 10;
    public int offset;
    private int total;
    private int groupSize = 10;

    private int begin;
    private int end;

    private boolean firstGroupPage = false;
    private boolean lastGroupPage = false;

    private int lastPage = 1;

    /**
     * 결과건수
     */
    private int resultCount = 0;

    private int startOffset = 0;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public boolean isFirstGroupPage() {
        // groupPage가 첫페이지인지 계산
        return this.getOffset() / this.getGroupSize() < this.getGroupSize();
    }
    public boolean isLastGroupPage() {
        // groupPage가 마지막페이지인지 계산
        int diff = this.getEnd() - this.getBegin();
        return !((this.groupSize -1) == diff);
    }

    public int getLastPage() {
        return
        (int)Math.ceil(new Double(1)* total/groupSize) == 0
                ? 1
                : (int)Math.ceil(new Double(1)* total/groupSize);
    }

    public int getBegin() {
        int calc = ((page / size) * groupSize) + 1;
        if (page % groupSize == 0) {
            calc = calc - groupSize;
        }
        return calc;
    }

    public int getEnd() {
        int calc = (page / size + 1) * groupSize;
        if (page % groupSize == 0) {
            calc = calc - groupSize;
        }

        int end1 = calc * size;
        if (end1 >= total) {
            if(total % end1 == 0) {
                calc = total / size;
            } else {
                calc = (total / size) + 1;
            }
        }

        return calc;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getOffset() {
        return (page-1) * size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "page=" + page +
                ", size=" + size +
                ", offset=" + this.getOffset() +
                ", total=" + this.getTotal() +
                ", groupSize=" + groupSize +
                ", begin=" + this.getBegin() +
                ", end=" + this.getEnd() +
                ", firstGroupPage=" + this.isFirstGroupPage() +
                ", lastGroupPage=" + this.isLastGroupPage() +
                ", lastpage=" + this.getLastPage() +
                ", resultCount=" + resultCount +
                ", startOffset=" + startOffset +
                '}';
    }
}