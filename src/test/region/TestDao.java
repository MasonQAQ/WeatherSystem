package region;

import edu.hehai.shuili.weather.dao.RegionDao;
import edu.hehai.shuili.weather.pojo.Region;
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
 * @Time: 8:28 PM
 * @package_name: region
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:mvc-dispatcher.xml"})
public class TestDao {

    @Autowired
    RegionDao regionDao;

    @Test
    public void test1(){
        List<Region> regions = regionDao.findAllProvince();
        for (Region region : regions){
            System.out.println(region);
        }
    }

    @Test
    public void test2(){
        List<Region> regions = regionDao.findAllCityOfProvince(16);
        for (Region region : regions){
            System.out.println(region);
        }
    }

    @Test
    public void test3(){
        System.out.println(regionDao.find(170));
    }


    @Test
    public void test4(){
        System.out.println(regionDao.findPage(1));
    }
}
