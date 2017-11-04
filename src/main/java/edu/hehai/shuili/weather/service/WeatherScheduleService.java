package edu.hehai.shuili.weather.service;

import edu.hehai.shuili.weather.sdk.HeWeatherJdSDK;
import edu.hehai.shuili.weather.pojo.City;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class WeatherScheduleService {

    @Autowired
    private CityService cityService;
    @Autowired
    private WeatherService weatherService;

    Logger logger = Logger.getLogger(WeatherScheduleService.class);

    /**
     * 定时执行天气采集任务
     * 每天10点执行
     */
    @Scheduled(cron="0 0 10 * * ?") //每天10点定时执行
//    @Scheduled(cron="0/60 * * * * ? ") //间隔5秒执行  测试
    public void init() {
        for (City city : cityService.findAll()){
            try {
                weatherService.add(HeWeatherJdSDK.getWeather(city.getCityName()));
                logger.warn("天气采集成功: 【" + city.getCityName() + "】");
            } catch (Exception e) {
                logger.error("天气采集失败！城市名【" + city.getCityName() + "】 错误信息: " + e.getMessage());
                //发送邮件给管理员
            }
        }
    }

}