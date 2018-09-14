package com.ipudong.test.util;



import com.ipudong.test.enums.Msg;

import java.io.Serializable;

public class MsgException implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7123926047243427392L;


    //消息code
    private String errorCode;
    //消息内容
    private String errorInfo;

    public MsgException() {
        this.errorCode = Msg.SYSTEM_ERROR.getMsgCode();
        this.errorInfo = Msg.SYSTEM_ERROR.getMsgInfo();
    }

    public MsgException(Exception e) {
        this.errorCode = Msg.SYSTEM_ERROR.getMsgCode();
        this.errorInfo = e.getMessage();
    }


    public MsgException(String errorInfo) {
        this.errorCode = Msg.BUSINESS_ERROR.getMsgCode();
        this.errorInfo = errorInfo;
    }

    public MsgException(Result<?> result) {
        this.errorCode = result.getMsgCode();
        this.errorInfo = result.getMsgInfo();
    }

    public MsgException(Msg msg) {
        this.errorCode = msg.getMsgCode();
        this.errorInfo = msg.getMsgInfo();
    }


    public MsgException(String errorCode, String errorInfo) {
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
    }

    public MsgException(Msg errorCode, String errorInfo) {
        this.errorCode = errorCode.getMsgCode();
        this.errorInfo = errorInfo;
    }

    public String getErrorCode() {
        return errorCode;
    }


    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


    public String getErrorInfo() {
        return errorInfo;
    }


    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }


}
