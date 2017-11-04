package edu.hehai.shuili.weather.controller;

import edu.hehai.shuili.weather.api.ApiStatus;
import edu.hehai.shuili.weather.api.ReturnPureNotifyApi;
import edu.hehai.shuili.weather.api.ReturnWithResultApi;
import edu.hehai.shuili.weather.exception.NotExistedException;
import edu.hehai.shuili.weather.intercepter.Permission;
import edu.hehai.shuili.weather.pojo.City;
import edu.hehai.shuili.weather.pojo.Privilege;
import edu.hehai.shuili.weather.service.CityService;
import edu.hehai.shuili.weather.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by yangyue
 *
 * @Date: 27/10/2017
 * @Time: 10:21 AM
 * @package_name: edu.hehai.shuili.weather.controller
 * @Description:
 */
@RestController
@RequestMapping(value = MappingURL.CITY_BASE_URL)
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 分页查询city的信息
     * @param pageNum 页码
     * @method GET
     * @return city的分页信息
     */
    @Permission(value = {Privilege.ADMIN, Privilege.USER})
    @RequestMapping(value = MappingURL.CITY_FIND, method = RequestMethod.GET)
    public ReturnWithResultApi<Page<City>> findPage(
            @PathVariable int pageNum
            ){
        ReturnWithResultApi<Page<City>> returnWithResultApi = new ReturnWithResultApi<Page <City>>();
        Page<City> result = cityService.findPage(pageNum);
        if (result.getList().isEmpty()) {
            returnWithResultApi.setApiStatus(ApiStatus.EMPTY);
        } else {
            returnWithResultApi.setApiStatus(ApiStatus.SUCCESS);
        }
        returnWithResultApi.setResult(result);
        return returnWithResultApi;
    }


    /**
     * 增加城市
     * @param regionId 区域id
     * @return 是否成功
     */
    @Permission(value = {Privilege.ADMIN})
    @RequestMapping(value = MappingURL.CITY_ADD, method = RequestMethod.GET)
    public ReturnPureNotifyApi add(
            @PathVariable int regionId
    ){
        if (!cityService.isExist(regionId)){
            throw new NotExistedException("regionId", regionId);
        }
        cityService.add(regionId);
        return new ReturnPureNotifyApi(ApiStatus.SUCCESS);
    }

    /**
     * 删除城市
     * @param regionId 城市id
     * @return 是否成功
     */
    @Permission(value = {Privilege.ADMIN})
    @RequestMapping(value = MappingURL.CITY_DELETE, method = RequestMethod.DELETE)
    public ReturnPureNotifyApi delete(
            @PathVariable int regionId
    ){
        if (!cityService.isExist(regionId)){
            throw new NotExistedException("regionId", regionId);
        }
        cityService.delete(regionId);
        return new ReturnPureNotifyApi(ApiStatus.SUCCESS);
    }

}
