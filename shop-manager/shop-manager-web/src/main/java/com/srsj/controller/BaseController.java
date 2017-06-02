package com.srsj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.srsj.common.utils.HttpUtil;
import com.srsj.common.utils.JsonUtils;

/**
 * Created by weichen on 2017/6/1.
 */
public class BaseController {
    protected Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected HttpServletRequest request;
//    @Autowired
//    protected HttpServletResponse response;
    @Autowired
    protected HttpSession session;
    @Autowired
    protected ServletContext application;

    public BaseController() {
    }

//    protected Long getCurrentUserId() {
//        return this.getSSOToken().getId();
//    }

//    protected SSOToken getSSOToken() {
//        SSOToken tk = (SSOToken)SSOHelper.attrToken(this.request);
//        if(tk == null) {
//            throw new WebException("-1", "The user does not exist, please relogin.");
//        } else {
//            return tk;
//        }
//    }

    protected boolean isPost() {
        return HttpUtil.isPost(this.request);
    }

    protected boolean isGet() {
        return HttpUtil.isGet(this.request);
    }

    protected String redirectTo(String url) {
        StringBuffer rto = new StringBuffer("redirect:");
        rto.append(url);
        return rto.toString();
    }

    protected String toJson(Object object) {
//        return JSON.toJSONString(object, new SerializerFeature[]{SerializerFeature.BrowserCompatible});
        String str = JsonUtils.objectToJson(object);
        return str;
    }

    protected String toJson(Object object, String format) {
        if (format == null) {
            String str = JsonUtils.objectToJson(object);
            return str;
        }
        //todo:未利用格式化参数；
        String str = JsonUtils.objectToJson(object);
        return str;
    }

    protected String callback(AjaxResult object) {
        return this.callback(object, (String)null);
    }

    protected String callback(AjaxResult object, String format) {
        String callback = this.request.getParameter("callback");
        if(callback == null) {
            return this.toJson(object, format);
        } else {
            StringBuffer json = new StringBuffer();
            json.append(callback);
            json.append("(").append(this.toJson(object, format)).append(")");
            return json.toString();
        }
    }

    protected String callbackSuccess(Object obj) {
        return this.callback(new AjaxResult(obj));
    }

    protected String callbackFail(String message) {
        return this.callback(new AjaxResult(false, message));
    }
}
