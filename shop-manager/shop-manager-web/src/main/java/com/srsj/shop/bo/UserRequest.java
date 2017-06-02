package com.srsj.shop.bo;

import com.srsj.common.bo.PageRequest;

/**
 * Created by weichen on 2017/6/2.
 */
public class UserRequest extends PageRequest {

    // 登录名称
    private String loginName;
    // 邮箱
    private String email;

    public void setLoginName(String value) {
        this.loginName = value;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getEmail() {
        return this.email;
    }

}