package com.ipudong.test.util;

import java.io.Serializable;
import java.util.List;

public class Result<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2281372263714858950L;

    // 调用成功/失败
    private boolean success;
    // 消息code
    private String msgCode;
    // 消息内容
    private String msgInfo;
    @Deprecated
    private Long sum;

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    // list条数
    @Deprecated
    private Long count;
    // 总页数
    @Deprecated
    private Long totalPage;
    // 当前页
    @Deprecated
    private Integer currentPage;

    private Integer limit;
    private Integer offset;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    // 模板数据
    private T model;

    public Result() {
        this.success = true;
    }

    public Result(T model) {
        this.success = true;
        this.model = model;
    }

    public Result(T model, Long count) {
        this.success = true;
        this.count = count;
        this.model = model;
    }

    public Result(T model, Integer limit, Integer offset) {
        this.success = true;
        this.model = model;
        if (this.model instanceof List) {
            int size = ((List) this.model).size();
            this.limit = limit;
            this.offset = offset + size;
        }
    }

    public Result(MsgException e) {
        this.success = false;
        this.msgCode = e.getErrorCode();
        this.msgInfo = e.getErrorInfo();
    }

    public Result(MsgException e, boolean isSuccess) {
        this.success = isSuccess;
        this.msgCode = e.getErrorCode();
        this.msgInfo = e.getErrorInfo();
    }

    public Result(String msgInfo, MsgException e) {
        this.success = false;
        this.msgCode = e.getErrorCode();
        this.msgInfo = msgInfo;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", msgCode='" + msgCode + '\'' +
                ", msgInfo='" + msgInfo + '\'' +
                ", sum=" + sum +
                ", count=" + count +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", limit=" + limit +
                ", offset=" + offset +
                ", model=" + model +
                '}';
    }

    public final static Result success(Object object) {
        Result<Object> result = new Result<Object>();
        result.success = true;
        result.msgCode = "0";
        result.msgCode = "成功";
        result.model = object;
        return result;
    }
}
