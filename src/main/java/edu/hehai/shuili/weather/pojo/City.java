package edu.hehai.shuili.weather.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by yangyue
 *
 * @Date: 26/10/2017
 * @Time: 2:37 PM
 * @package_name: edu.hehai.shuili.weather.pojo
 * @Description: 要采集的城市列表
 */
public class City {
    //城市id
    private int cityId;
    //城市所在省份
    private String province;
    //城市名称
    private String cityName;
    //添加城市日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date insertDate;
    //区域id
    private int regionId;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"cityId\":")
                .append(cityId);
        sb.append(",\"province\":\"")
                .append(province).append('\"');
        sb.append(",\"cityName\":\"")
                .append(cityName).append('\"');
        sb.append(",\"insertDate\":\"")
                .append(insertDate).append('\"');
        sb.append(",\"regionId\":")
                .append(regionId);
        sb.append('}');
        return sb.toString();
    }
}
