package edu.hehai.shuili.weather.pojo;

/**
 * Created by yangyue
 *
 * @Date: 26/10/2017
 * @Time: 7:34 PM
 * @package_name: edu.hehai.shuili.weather.pojo
 * @Description: 全国所有区域
 */
public class Region {
    //区域id
    private int regionId;
    //区域代码
    private int regionCode;
    //区域名称
    private String regionName;
    //父级区域id
    private int parentId;
    //区域等级
    private int regionLevel;
    //区域排序
    private int regionOrder;
    //区域英文名
    private String regionNameEn;
    //区域简写
    private String regionShortNameEn;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(int regionLevel) {
        this.regionLevel = regionLevel;
    }

    public int getRegionOrder() {
        return regionOrder;
    }

    public void setRegionOrder(int regionOrder) {
        this.regionOrder = regionOrder;
    }

    public String getRegionNameEn() {
        return regionNameEn;
    }

    public void setRegionNameEn(String regionNameEn) {
        this.regionNameEn = regionNameEn;
    }

    public String getRegionShortNameEn() {
        return regionShortNameEn;
    }

    public void setRegionShortNameEn(String regionShortNameEn) {
        this.regionShortNameEn = regionShortNameEn;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"regionId\":")
                .append(regionId);
        sb.append(",\"regionCode\":")
                .append(regionCode);
        sb.append(",\"regionName\":\"")
                .append(regionName).append('\"');
        sb.append(",\"parentId\":")
                .append(parentId);
        sb.append(",\"regionLevel\":")
                .append(regionLevel);
        sb.append(",\"regionOrder\":")
                .append(regionOrder);
        sb.append(",\"regionNameEn\":\"")
                .append(regionNameEn).append('\"');
        sb.append(",\"regionShortNameEn\":\"")
                .append(regionShortNameEn).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
