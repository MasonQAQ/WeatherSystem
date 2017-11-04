package city;

import edu.hehai.shuili.weather.pojo.City;
import edu.hehai.shuili.weather.service.CityService;
import edu.hehai.shuili.weather.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by yangyue
 *
 * @Date: 26/10/2017
 * @Time: 11:21 PM
 * @package_name: city
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:mvc-dispatcher.xml"})
public class TestDao {

    @Autowired
    CityService cityService;


    @Test
    public void test1(){
        cityService.add(24);
    }

    @Test
    public void test2(){
        if (cityService.delete(2)){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void test3(){
        List<City> list = cityService.findAll();
        for (City city: list){
            System.out.println(city);
        }
    }

    @Test
    public void test4(){
        Page<City> cityPage = cityService.findPage(1);
        System.out.println(cityPage);
    }
}
