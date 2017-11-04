package edu.hehai.shuili.weather.api;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by yangyue
 *
 * @Date: 28/10/2017
 * @Time: 9:33 AM
 * @package_name: edu.hehai.shuili.weather.util
 * @Description: 纯净版提示api
 */
public class ReturnPureNotifyApi implements Serializable {
    // API 请求状态code
    @JSONField(ordinal = 1)
    private int code;
    // API 请求状态
    @JSONField(ordinal = 2)
    private String message;

    public ReturnPureNotifyApi() {
    }

    public ReturnPureNotifyApi(ApiStatus apiStatus) {
        this.code = apiStatus.getCode();
        this.message = apiStatus.getMessage();
    }

    public void setApiStatus(ApiStatus apiStatus){
        this.code = apiStatus.getCode();
        this.message = apiStatus.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":")
                .append(code);
        sb.append(",\"message\":\"")
                .append(message).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
