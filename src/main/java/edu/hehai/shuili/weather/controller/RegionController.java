package edu.hehai.shuili.weather.controller;

import edu.hehai.shuili.weather.intercepter.Permission;
import edu.hehai.shuili.weather.pojo.Privilege;
import edu.hehai.shuili.weather.pojo.Region;
import edu.hehai.shuili.weather.service.RegionService;
import edu.hehai.shuili.weather.api.ApiStatus;
import edu.hehai.shuili.weather.util.MappingURL;
import edu.hehai.shuili.weather.api.ReturnWithResultApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yangyue
 *
 * @Date: 27/10/2017
 * @Time: 2:24 PM
 * @package_name: edu.hehai.shuili.weather.controller
 * @Description: region相关api
 */
@RestController
@RequestMapping(value = MappingURL.REGION_BASE_URL)
public class RegionController {

    @Autowired
    private RegionService regionService;

    /**
     * 根据区域id查找区域
     * @param regionId 区域id
     * @return 区域详细信息
     */
    @Permission(value = {Privilege.ADMIN})
    @RequestMapping(value = MappingURL.REGION_FIND, method = RequestMethod.GET)
    public ReturnWithResultApi<Region> findRegion(
            @PathVariable int regionId
    ){
        ReturnWithResultApi<Region> returnWithResultApi = new ReturnWithResultApi<Region>();
        Region region = regionService.find(regionId);
        if (region != null){
            returnWithResultApi.setApiStatus(ApiStatus.SUCCESS);
        }else {
            returnWithResultApi.setApiStatus(ApiStatus.EMPTY);
        }
        returnWithResultApi.setResult(region);
        return returnWithResultApi;
    }

    /**
     * 查询所有的省份列表
     * @return 所有的省份列表
     */
    @Permission(value = {Privilege.ADMIN})
    @RequestMapping(value = MappingURL.REGION_FIND_ALL_PROVINCE_URL, method = RequestMethod.GET)
    public ReturnWithResultApi<List <Region>> findAllProvince(){
        ReturnWithResultApi<List <Region>> returnWithResultApi = new ReturnWithResultApi<List <Region>>();
        returnWithResultApi.setApiStatus(ApiStatus.SUCCESS);
        returnWithResultApi.setResult(regionService.findAllProvince());
        return returnWithResultApi;
    }


    /**
     * 获取省份下的所有城市id
     * @param provinceId 省份id
     * @return 省份下的所有城市id
     */
    @Permission(value = {Privilege.ADMIN})
    @RequestMapping(value = MappingURL.ENGION_FIND_ALL_CITY_OF_PROVINCE_URL, method = RequestMethod.GET)
    public ReturnWithResultApi<List <Region>> findAllCityOfProvince(
            @PathVariable int provinceId
    ){
        ReturnWithResultApi<List <Region>> returnWithResultApi = new ReturnWithResultApi<List <Region>>();
        List<Region> regionList = regionService.findAllCityOfProvince(provinceId);
        if (!regionList.isEmpty()){
            returnWithResultApi.setApiStatus(ApiStatus.SUCCESS);
        }else {
            returnWithResultApi.setApiStatus(ApiStatus.EMPTY);
        }
        returnWithResultApi.setResult(regionList);
        return returnWithResultApi;
    }
}
