package edu.hehai.shuili.weather.service;

import edu.hehai.shuili.weather.dao.UserDao;
import edu.hehai.shuili.weather.pojo.User;
import edu.hehai.shuili.weather.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yangyue
 *
 * @Date: 28/10/2017
 * @Time: 12:26 AM
 * @package_name: edu.hehai.shuili.weather.service
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    final private static String MD5_SALT = "Hehai_University";


    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    public boolean isExist(String username){
        return userDao.isExist(username);
    }

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User find(String username, String password){
        return userDao.find(username, MD5Util.getMD5(password + MD5_SALT));
    }

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    public User find(int userId){
        return userDao.find(userId);
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    public boolean add(User user){
        User userNew = (User) user.clone(); //不改变原来的对象，后面需要用到原对象里面的username和password
        userNew.setPassword(MD5Util.getMD5(userNew.getPassword() + MD5_SALT));
        userNew.setPrivilege(1); //默认设置成普通用户
        return userDao.add(userNew);
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    public boolean delete(int userId){
        return userDao.delete(userId);
    }


    /**
     * 更新用户基本属性：昵称，电话，邮箱
     * @param user
     * @return
     */
    public boolean update(User user){
        return userDao.update(user);
    }

    /**
     * 更新用户基本属性：昵称，电话，邮箱，权限
     * @param user
     * @return
     */
    public boolean superUpdate(User user){
        return userDao.superUpdate(user);
    }

    /**
     * 更新用户密码
     * @param user
     * @return
     */
    public boolean updatePassword(User user){
        user.setPassword(MD5Util.getMD5(user.getPassword() + MD5_SALT));
        return userDao.updatePassword(user);
    }
}
