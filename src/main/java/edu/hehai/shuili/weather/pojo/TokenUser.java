package edu.hehai.shuili.weather.pojo;

/**
 * Created by yangyue
 *
 * @Date: 30/10/2017
 * @Time: 11:11 PM
 * @package_name: edu.hehai.shuili.weather.pojo
 * @Description: 用户token显示的
 */
public class TokenUser {
    private int userId;
    private String username;
    private int privilege;

    public TokenUser() {
    }

    public TokenUser(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.privilege = user.getPrivilege();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userId\":")
                .append(userId);
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"privilege\":")
                .append(privilege);
        sb.append('}');
        return sb.toString();
    }
}
