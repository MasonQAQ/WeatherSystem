package edu.hehai.shuili.weather.api;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by yangyue
 *
 * @Date: 27/10/2017
 * @Time: 10:23 AM
 * @package_name: edu.hehai.shuili.weather.pojo
 * @Description:
 */
public class ReturnWithResultApi<T> implements Serializable {

    // API 请求状态code
    @JSONField(ordinal = 1)
    private int code;
    // API 请求状态
    @JSONField(ordinal = 2)
    private String message;
    // 返回的结果集
    @JSONField(ordinal = 3)
    private T result;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setApiStatus(ApiStatus code){
        this.code = code.getCode();
        this.message = code.getMessage();
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":")
                .append(code);
        sb.append(",\"message\":\"")
                .append(message).append('\"');
        sb.append(",\"api\":")
                .append(result);
        sb.append('}');
        return sb.toString();
    }
}
