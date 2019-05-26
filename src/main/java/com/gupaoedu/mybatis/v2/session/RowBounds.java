package com.gupaoedu.mybatis.v2.session;

public class RowBounds {
    private final int offset;
    private final int limit;
    public static final RowBounds DEFAULT = new RowBounds();

    public RowBounds() {
        this.offset = 0;
        this.limit = 2147483647;
    }

    public RowBounds(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getLimit() {
        return this.limit;
    }

    @Override
    public String toString() {
        return "RowBounds{" +
                "offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
