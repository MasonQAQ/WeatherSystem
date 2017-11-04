package weather;

/**
 * Created by yangyue
 *
 * @Date: 27/10/2017
 * @Time: 9:29 AM
 * @package_name: weather
 * @Description:
 */

import edu.hehai.shuili.weather.dao.WeatherDao;
import edu.hehai.shuili.weather.sdk.HeWeatherJdSDK;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:mvc-dispatcher.xml"})
public class TestDao {
    @Autowired
    WeatherDao weatherDao;

    @Test
    public void test1(){
        weatherDao.add(HeWeatherJdSDK.getWeather("泸州市"));
    }



}
