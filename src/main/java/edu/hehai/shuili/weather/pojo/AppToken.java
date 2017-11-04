package edu.hehai.shuili.weather.pojo;

/**
 * Created by yangyue
 *
 * @Date: 30/10/2017
 * @Time: 8:44 PM
 * @package_name: edu.hehai.shuili.weather.util
 * @Description:
 */
public class AppToken {
    private String appId;
    private String appSecret;

    public AppToken() {
    }

    public AppToken(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
