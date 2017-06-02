package com.srsj.shop.controller;

/**
 * Created by weichen on 2017/6/1.
 */
public class AjaxResult {
    private boolean success;
    private String message;
    private Object data;

    public AjaxResult(Object data) {
        this(true, (String)null, data);
    }

    public AjaxResult(boolean success, String message) {
        this(success, message, (Object)null);
    }

    public AjaxResult(boolean success, String message, Object data) {
        this.success = true;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
