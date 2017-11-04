package edu.hehai.shuili.weather.api;

/**
 * Created by yangyue
 *
 * @Date: 27/10/2017
 * @Time: 10:24 AM
 * @package_name: edu.hehai.shuili.weather.util
 * @Description: Api状态码统一返回
 */
public enum ApiStatus {


    SHOW_API_VERSION(0, "Weather System API 0.0.1"),

    BAD_REQUEST(400000, "错误请求"),
    NO_PERMISSION(403000, "没有权限"),
    METHOD_NOT_ALLOWED(405000, "请求方法错误"),
    UNSUPPORTED_MEDIA_TYPE(415000, "不支持的媒体类型"),
    CLASS_CAST_ERROR(200416, "类型转换异常"),
    REQUEST_TYPE_MISMATCH(200417, "参数类型不匹配"),
    REQUEST_MISSING_PARAM(200418, "请求参数缺失"),
    INTERNAL_SERVER_ERROR(500000, "服务器内部错误"),
    SUCCESS(200000, "成功"),
    EMPTY(201000, "结果为空"),
    UNKOWN_ERROR(202, "未知错误"),

    /*city 相关错误码*/
    ADD_ERROR(200301, "添加城市失败"),
    DELETE_ERROR(200302, "删除城市失败"),
    CITY_EXIST(200303, "城市已经存在"),

    /*user 相关错误码*/
    LOGIN_ERROR(200501, "用户名或密码错误"),
    REGISTER_ERROR(200502, "注册失败"),
    VALID_ERROR(200503, "校验失败"),
    USER_EXIST(200504, "资源已经存在"),
    USER_NOT_EXIST(200505, "资源不存在"),
    USER_MISS_TOKEN(200506, "缺少token"),
    USER_MODEL_PROPERTY_BIND_ERROR(200507, "数据模型参数缺失")
    ;

    private int code;
    private String  message;

    ApiStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":")
                .append(code);
        sb.append(",\"message\":\"")
                .append(message).append('\"');
        sb.append('}');
        return sb.toString();
    }

    /**
     * 根据code值返回ApiStatus
     * @param code
     * @return
     */
    public static ApiStatus getApiStatus(int code){
        for (ApiStatus apiStatus : ApiStatus.values()){
            if (apiStatus.getCode() == code){
                return apiStatus;
            }
        }
        return null;
    }
}
