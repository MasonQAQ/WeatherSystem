package edu.hehai.shuili.weather.service;

import edu.hehai.shuili.weather.dao.CityDao;
import edu.hehai.shuili.weather.pojo.City;
import edu.hehai.shuili.weather.pojo.Region;
import edu.hehai.shuili.weather.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyue
 *
 * @Date: 27/10/2017
 * @Time: 12:46 AM
 * @package_name: edu.hehai.shuili.weather.service
 * @Description:
 */
@Service
public class CityService {

    /**
     * 直辖市属于省级，但是没有下属的市，需要特殊处理
     */
    private static final ArrayList<String> ZHI_XIA_SHI = new ArrayList <String>();
    static {
        ZHI_XIA_SHI.add("北京市");
        ZHI_XIA_SHI.add("上海市");
        ZHI_XIA_SHI.add("天津市");
        ZHI_XIA_SHI.add("重庆市");
    }
    @Autowired
    private CityDao cityDao;
    @Autowired
    private RegionService regionService;


    /**
     * 返回所有城市信息
     * @return 所有需要采集的城市
     */
    public List<City> findAll(){
        return cityDao.findAll();
    }


    /**
     * 判断城市是否存在
     * @param regionId
     * @return
     */
    public boolean isExist(int regionId){
        return cityDao.isExist(regionId);
    }
    /**
     * 分页返回城市信息
     * @param pageNum 页码
     * @return 分页城市信息
     */
    public Page<City> findPage(int pageNum){
        return cityDao.findPage(pageNum);
    }

    /**
     * 增加城市
     * @param regionId 区域id
     * @return 是否成功
     */
    public boolean add(int regionId){
        Region region = regionService.find(regionId);
        City city = new City();
        city.setRegionId(regionId);
        String regionName = region.getRegionName();
        city.setCityName(regionName);

        if (ZHI_XIA_SHI.contains(regionName)){
            city.setProvince(regionName);
        }else {
            if (regionService.find(region.getParentId()).getParentId() != 1){
                return false;
            }
            city.setProvince(regionService.find(region.getParentId()).getRegionName());
        }
        return cityDao.add(city);
    }

    /**
     * 根据城市id删除城市
     * @param regionId 城市id
     * @return 是否成功
     */
    public boolean delete(int regionId){
        return cityDao.delete(regionId);
    }



}
