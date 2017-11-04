package edu.hehai.shuili.weather.controller;

import edu.hehai.shuili.weather.intercepter.Permission;
import edu.hehai.shuili.weather.pojo.Privilege;
import edu.hehai.shuili.weather.pojo.Weather;
import edu.hehai.shuili.weather.service.WeatherService;
import edu.hehai.shuili.weather.api.ApiStatus;
import edu.hehai.shuili.weather.util.MappingURL;
import edu.hehai.shuili.weather.api.ReturnWithResultApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by yangyue
 *
 * @Date: 27/10/2017
 * @Time: 5:07 PM
 * @package_name: edu.hehai.shuili.weather.controller
 * @Description:
 */
@RestController
@RequestMapping(value = MappingURL.WEATHER_BASE_URL)
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    /**
     * 查询指定区间的天气信息
     * @param startDate 开启时期
     * @param endDate 结束日期
     * @return 区间内所有天气
     */
    @Permission(value = {Privilege.ADMIN, Privilege.USER})
    @RequestMapping(value = MappingURL.COMMON_FIND_URL, method = RequestMethod.GET)
    public ReturnWithResultApi<List<Weather>> find(
            @RequestParam(value = "startDate" )Date startDate,
            @RequestParam(value = "endDate") Date endDate,
            @RequestParam(value = "cityName") String cityName
            ){
        List<Weather> weathers = weatherService.find(startDate, endDate, cityName);
        ReturnWithResultApi<List<Weather>> returnWithResultApi = new ReturnWithResultApi<List <Weather>>();
        if (!weathers.isEmpty()){
            returnWithResultApi.setApiStatus(ApiStatus.SUCCESS);
        }else {
            returnWithResultApi.setApiStatus(ApiStatus.EMPTY);
        }
        returnWithResultApi.setResult(weathers);
        return returnWithResultApi;

    }
}
