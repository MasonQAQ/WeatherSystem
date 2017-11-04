package edu.hehai.shuili.weather.pojo;

/**
 * Created by yangyue
 *
 * @Date: 30/10/2017
 * @Time: 11:27 PM
 * @package_name: edu.hehai.shuili.weather.pojo
 * @Description: 权限表
 */
public enum Privilege {

    ADMIN(0, "超级管理员"),
    USER(1, "普通用户");


    private int code;
    private String description;


    Privilege(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":")
                .append(code);
        sb.append(",\"description\":\"")
                .append(description).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
