package edu.hehai.shuili.weather.service;

import edu.hehai.shuili.weather.dao.RegionDao;
import edu.hehai.shuili.weather.pojo.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangyue
 *
 * @Date: 26/10/2017
 * @Time: 9:37 PM
 * @package_name: edu.hehai.shuili.weather.service
 * @Description:
 */
@Service
public class RegionService {

    @Autowired
    private RegionDao regionDao;

    /**
     * 根据区域id查找区域
     * @param regionId
     * @return
     */
    public Region find(int regionId){
        return regionDao.find(regionId);
    }

    /**
     * 查询所有的省份列表
     * @return
     */
    public List<Region> findAllProvince(){
        return regionDao.findAllProvince();
    }

    /**
     * 查询某个省份的所有城市
     * @param provinceId
     * @return
     */
    public List<Region> findAllCityOfProvince(int provinceId){
        Region province = this.find(provinceId);
        if (province == null || province.getParentId() != 1){ //防止输入的不是省份id
            return null;
        }
        return regionDao.findAllCityOfProvince(provinceId);
    }
}
