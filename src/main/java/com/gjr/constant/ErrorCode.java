package com.gjr.constant;

/**
 * Created by geng
 * on 2017/3/19.
 */
public enum ErrorCode{
    BAD_REQUEST(400, "bad request"),
    FORBIDDEN(403, "禁止访问"),
    NO_AUTH(4030, "没有权限");
    private Integer index;
    private String name;

    ErrorCode(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public ErrorCode[] getValues() {
        return ErrorCode.values();
    }
}