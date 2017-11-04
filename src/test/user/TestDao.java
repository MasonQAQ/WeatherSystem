package user;

import edu.hehai.shuili.weather.pojo.User;
import edu.hehai.shuili.weather.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yangyue
 *
 * @Date: 28/10/2017
 * @Time: 12:39 AM
 * @package_name: user
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:mvc-dispatcher.xml"})
public class TestDao {

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        User user = new User();
        user.setUsername("lihua");
        user.setNickname("李华");
        user.setPassword("yy201314");
        user.setPhone("13222222222");
        user.setPrivilege(1);
        userService.add(user);
    }

    @Test
    public void test2(){
        System.out.println(userService.find("lihua", "yy201314"));
    }

    @Test
    public void test3(){
        userService.delete(2);
    }

    @Test
    public void test4(){
        User user = new User();
        user.setUserId(3);
        user.setUsername("liming");
        user.setNickname("李明");
        user.setPassword("yy201314");
        user.setPhone("13233334444");
        user.setPrivilege(1);
        userService.update(user);
    }

    @Test
    public void test5(){
        System.out.println(userService.isExist("yangyue"));
    }

}
