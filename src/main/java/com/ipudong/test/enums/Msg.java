package com.ipudong.test.enums;


public enum Msg {

    SUCCESS("0", "调用成功"),
    SYSTEM_ERROR("1", "系统异常"),
    BUSINESS_ERROR("2", "业务异常"),
    LONGIN_FAIL("3", "重新登陆"),
    MOBILE_ERROR("4", "您的手机号不正确，需要完善后再登录"),
    IDCARD_ERROR("5", "您的身份证不正确，需要完善后再登录"),

    PAY_SUCCESS("7", "支付成功"),
    WAIT_BAND("8", "未绑定公众号"),
    LOGIN_SESSION("9", "登录session"),
    LOGOUT_SESSION("10", "删除session"),
    MOBILE_BLANK("11", "手机号码为空"),
    USER_INFO_ERROR("12", "您的用户信息不完善,需要完善后再登录"),


    //开放接口异常
    OPEN_MSG_NO_RECORD_FOUND("11001", "未找到记录"),
    OPEN_MSG_ILLEGAL_REQUEST_PARAM("11002", "非法参数"),
    OPEN_MSG_ILLEGAL_CHANNEL_PARAM("11003", "非法渠道"),
    OPEN_MSG_REPEATED_SUBMIT("11004", "重复提交"),
    OPEN_MSG_COUPON_NOT_EXIST("11005", "优惠劵不存在"),
    OPEN_MSG_FAIL_SUBMIT("11006", "提交数据失败"),
    OPEN_MSG_FAIL_UPDATE_USER("11007", "更新用户信息失败"),
    OPEN_MSG_ERROR_USER_INFO("11008", "错误的用户信息"),
    OPEN_MSG_FAIL_USER_CREATE("11009", "用户创建失败"),
    OPEN_MSG_REPEATED_GAIN_COUPON("11010", "已经领取过优惠劵"),
    OPEN_MSG_FAIL_GAIN_COUPON("11011", "领取优惠劵失败"),
    OPEN_MSG_INVALID_COUPON("11012", "无效的优惠劵"),
    OPEN_MSG_NOT_ENOUGH_COUPON("11013", "优惠劵不足"),

    COUPON_NO_RUSH("201", "非抢劵"),
    COUPON_RUSH_RECORD_FAIL("202", "记录明细失败"),
    COUPON_RUSH_RECORD_SYS_EXCEPTION("203", "记录明细系统异常"),
    COUPON_RUSH_END("204", "已抢光"),
    COUPON_RUSH_SYS_EXCEPTION("205", "减库存失败， 系统异常"),
    COUPON_RUSH_EXTRA("206", "不可多抢"),
    COUPON_RUSH_DATA_EXCEPTION("207", "数据异常"),
    COUPON_RUSH_IS_CODE("208", "不支持优惠码"),

    SYSTEM_MISS_BIZ_PARAM("300000", "缺少业务参数"),
    SYSTEM_ERROR_BIZ_PARAM("300002", "业务参数错误"),
    SYSTEM_PAGE_SIZE_LIMIT("300001", "页码分页超出限制"),

    USER_EXIST_MOBILE("400210", "手机号已被绑定"),
    USER_EXIST_ID_CARD("400211", "身份证号已被绑定"),
    USER_EXIST_TELEPHONE("400212", "固定电话已被绑定"),
    RECOMMEND_BIND("400213", "推荐信息已被绑定"),

    FORMAT_ILLEGAL_MOBILE("401000", "手机号格式不正确"),
    FORMAT_ILLEGAL_ID_CARD("401001", "身份证号格式不正确"),
    FORMAT_ILLEGAL_TELEPHONE("401002", "固定电话格式不正确"),
    FORMAT_ILLEGAL_NAME("401003", "姓名格式不正确"),

    NOT_FOUND_USER("404000", "未查找到用户"),
    NOT_FOUND_USER_INFO("404001", "未查找到用户资料"),
    NOT_FOUND_MEMBER("404002", "未查找到会员"),
    NOT_FOUND_EMPLOYEE("404003", "未查找到雇员"),
    NOT_FOUND_VENDOR("404004", "未查找到合作商"),
    NOT_FOUND_VENDOR_STORE("404005", "未查找到门店"),
    NOT_FOUND_PUSH_ID("404006", "未查找到推送编号"),
    NOT_FOUND("404404", "未查找到数据记录"),


    FROZEN_USER("405000", "用户已被冻结"),


    VENDOR_CARD_EXIST("500000", "会员卡已经被使用"),
    VENDOR_CARD_MULTI_MAPPING("500001", "该会员名下有多张会员卡,请联系客服部处理"),
    VENDOR_CARD_ALLOW_FAIL("500002", "申请会员卡失败"),
    VENDOR_CARD_NOT_SUPPORT_CHANGE("500100", "暂不支持变更会员卡,请联系客服部处理"),
    CLERK_NOT_VALID("500500", "店员身份信息有误,请联系客服部处理"),

    NO_PERMISSION("800000", "您的权限不足"),
    NO_PERMISSION_LOGIN("6", "您的权限不足"),
    SYSTEM_ERROR_ROLE_INIT("800001", "当前系统权限系统未初始化"),;

    Msg(String msgCode, String msgInfo) {
        this.msgCode = msgCode;
        this.msgInfo = msgInfo;
    }

    private String msgCode;
    //消息详情
    private String msgInfo;

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


}

