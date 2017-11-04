package edu.hehai.shuili.weather.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by yangyue
 *
 * @Date: 26/10/2017
 * @Time: 2:50 PM
 * @package_name: edu.hehai.shuili.weather.pojo
 * @Description: 天气内容表
 */
public class Weather {
    //记录id
    private long weatherId;
    //城市id
    private String cityName;
    //查询日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date insertDate;

    //未来一天天气情况、最高温度、最低温度、风速
    private String weather1;
    private int maxTemp1;
    private int minTemp1;
    private String wind1;

    //未来二天天气情况、最高温度、最低温度、风速
    private String weather2;
    private int maxTemp2;
    private int minTemp2;
    private String wind2;

    //未来三天天气情况、最高温度、最低温度、风速
    private String weather3;
    private int maxTemp3;
    private int minTemp3;
    private String wind3;

    //未来四天天气情况、最高温度、最低温度、风速
    private String weather4;
    private int maxTemp4;
    private int minTemp4;
    private String wind4;

    //未来五天天气情况、最高温度、最低温度、风速
    private String weather5;
    private int maxTemp5;
    private int minTemp5;
    private String wind5;

    //未来六天天气情况、最高温度、最低温度、风速
    private String weather6;
    private int maxTemp6;
    private int minTemp6;
    private String wind6;

    //未来七天天气情况、最高温度、最低温度、风速
    private String weather7;
    private int maxTemp7;
    private int minTemp7;
    private String wind7;

    public long getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(long weatherId) {
        this.weatherId = weatherId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getWeather1() {
        return weather1;
    }

    public void setWeather1(String weather1) {
        this.weather1 = weather1;
    }

    public int getMaxTemp1() {
        return maxTemp1;
    }

    public void setMaxTemp1(int maxTemp1) {
        this.maxTemp1 = maxTemp1;
    }

    public int getMinTemp1() {
        return minTemp1;
    }

    public void setMinTemp1(int minTemp1) {
        this.minTemp1 = minTemp1;
    }

    public String getWind1() {
        return wind1;
    }

    public void setWind1(String wind1) {
        this.wind1 = wind1;
    }

    public String getWeather2() {
        return weather2;
    }

    public void setWeather2(String weather2) {
        this.weather2 = weather2;
    }

    public int getMaxTemp2() {
        return maxTemp2;
    }

    public void setMaxTemp2(int maxTemp2) {
        this.maxTemp2 = maxTemp2;
    }

    public int getMinTemp2() {
        return minTemp2;
    }

    public void setMinTemp2(int minTemp2) {
        this.minTemp2 = minTemp2;
    }

    public String getWind2() {
        return wind2;
    }

    public void setWind2(String wind2) {
        this.wind2 = wind2;
    }

    public String getWeather3() {
        return weather3;
    }

    public void setWeather3(String weather3) {
        this.weather3 = weather3;
    }

    public int getMaxTemp3() {
        return maxTemp3;
    }

    public void setMaxTemp3(int maxTemp3) {
        this.maxTemp3 = maxTemp3;
    }

    public int getMinTemp3() {
        return minTemp3;
    }

    public void setMinTemp3(int minTemp3) {
        this.minTemp3 = minTemp3;
    }

    public String getWind3() {
        return wind3;
    }

    public void setWind3(String wind3) {
        this.wind3 = wind3;
    }

    public String getWeather4() {
        return weather4;
    }

    public void setWeather4(String weather4) {
        this.weather4 = weather4;
    }

    public int getMaxTemp4() {
        return maxTemp4;
    }

    public void setMaxTemp4(int maxTemp4) {
        this.maxTemp4 = maxTemp4;
    }

    public int getMinTemp4() {
        return minTemp4;
    }

    public void setMinTemp4(int minTemp4) {
        this.minTemp4 = minTemp4;
    }

    public String getWind4() {
        return wind4;
    }

    public void setWind4(String wind4) {
        this.wind4 = wind4;
    }

    public String getWeather5() {
        return weather5;
    }

    public void setWeather5(String weather5) {
        this.weather5 = weather5;
    }

    public int getMaxTemp5() {
        return maxTemp5;
    }

    public void setMaxTemp5(int maxTemp5) {
        this.maxTemp5 = maxTemp5;
    }

    public int getMinTemp5() {
        return minTemp5;
    }

    public void setMinTemp5(int minTemp5) {
        this.minTemp5 = minTemp5;
    }

    public String getWind5() {
        return wind5;
    }

    public void setWind5(String wind5) {
        this.wind5 = wind5;
    }

    public String getWeather6() {
        return weather6;
    }

    public void setWeather6(String weather6) {
        this.weather6 = weather6;
    }

    public int getMaxTemp6() {
        return maxTemp6;
    }

    public void setMaxTemp6(int maxTemp6) {
        this.maxTemp6 = maxTemp6;
    }

    public int getMinTemp6() {
        return minTemp6;
    }

    public void setMinTemp6(int minTemp6) {
        this.minTemp6 = minTemp6;
    }

    public String getWind6() {
        return wind6;
    }

    public void setWind6(String wind6) {
        this.wind6 = wind6;
    }

    public String getWeather7() {
        return weather7;
    }

    public void setWeather7(String weather7) {
        this.weather7 = weather7;
    }

    public int getMaxTemp7() {
        return maxTemp7;
    }

    public void setMaxTemp7(int maxTemp7) {
        this.maxTemp7 = maxTemp7;
    }

    public int getMinTemp7() {
        return minTemp7;
    }

    public void setMinTemp7(int minTemp7) {
        this.minTemp7 = minTemp7;
    }

    public String getWind7() {
        return wind7;
    }

    public void setWind7(String wind7) {
        this.wind7 = wind7;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"weatherId\":")
                .append(weatherId);
        sb.append(",\"cityName\":\"")
                .append(cityName).append('\"');
        sb.append(",\"insertDate\":\"")
                .append(insertDate).append('\"');
        sb.append(",\"weather1\":\"")
                .append(weather1).append('\"');
        sb.append(",\"maxTemp1\":")
                .append(maxTemp1);
        sb.append(",\"minTemp1\":")
                .append(minTemp1);
        sb.append(",\"wind1\":\"")
                .append(wind1).append('\"');
        sb.append(",\"weather2\":\"")
                .append(weather2).append('\"');
        sb.append(",\"maxTemp2\":")
                .append(maxTemp2);
        sb.append(",\"minTemp2\":")
                .append(minTemp2);
        sb.append(",\"wind2\":\"")
                .append(wind2).append('\"');
        sb.append(",\"weather3\":\"")
                .append(weather3).append('\"');
        sb.append(",\"maxTemp3\":")
                .append(maxTemp3);
        sb.append(",\"minTemp3\":")
                .append(minTemp3);
        sb.append(",\"wind3\":\"")
                .append(wind3).append('\"');
        sb.append(",\"weather4\":\"")
                .append(weather4).append('\"');
        sb.append(",\"maxTemp4\":")
                .append(maxTemp4);
        sb.append(",\"minTemp4\":")
                .append(minTemp4);
        sb.append(",\"wind4\":\"")
                .append(wind4).append('\"');
        sb.append(",\"weather5\":\"")
                .append(weather5).append('\"');
        sb.append(",\"maxTemp5\":")
                .append(maxTemp5);
        sb.append(",\"minTemp5\":")
                .append(minTemp5);
        sb.append(",\"wind5\":\"")
                .append(wind5).append('\"');
        sb.append(",\"weather6\":\"")
                .append(weather6).append('\"');
        sb.append(",\"maxTemp6\":")
                .append(maxTemp6);
        sb.append(",\"minTemp6\":")
                .append(minTemp6);
        sb.append(",\"wind6\":\"")
                .append(wind6).append('\"');
        sb.append(",\"weather7\":\"")
                .append(weather7).append('\"');
        sb.append(",\"maxTemp7\":")
                .append(maxTemp7);
        sb.append(",\"minTemp7\":")
                .append(minTemp7);
        sb.append(",\"wind7\":\"")
                .append(wind7).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
