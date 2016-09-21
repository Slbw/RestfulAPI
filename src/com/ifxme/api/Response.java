package com.ifxme.api;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by abcca on 2016/8/22 0022.
 */
public class Response {
    /**
     * 成功的code
     */
    public static final int CODE_SUCCESS = 1;
    private int code;
    private Object data;
    private String msg;

    public Response(int code, Object data) {
        this.code = code;
        if (code == CODE_SUCCESS) {
            this.data = data;
            msg = "成功";
        } else {
            msg = (String) data;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
