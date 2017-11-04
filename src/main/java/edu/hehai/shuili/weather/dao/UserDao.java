package edu.hehai.shuili.weather.dao;

import edu.hehai.shuili.weather.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Created by yangyue
 *
 * @Date: 26/10/2017
 * @Time: 4:31 PM
 * @package_name: edu.hehai.shuili.weather.dao
 * @Description:
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * field name
     */
    final private static String USER_ID_FIELD_NAME      =   "user_id";
    final private static String USERNAME_FIELD_NAME     =   "username";
    final private static String NICKNAME_FIELD_NAME     =   "nickname";
    final private static String PASSWORD_FIELD_NAME     =   "password";
    final private static String PHONE_FIELD_NAME        =   "phone";
    final private static String EMAIL_FIELD_NAME        =   "email";
    final private static String PRIVILEGE_FIELD_NAME    =   "privilege";

    /**
     * sql
     */
    final private static String SQL_IS_USER_EXIST                       = "SELECT count(1) FROM user WHERE username=?";
    final private static String SQL_FIND_USER_BY_USERNAME_AND_PASSWORD  = "SELECT * FROM user WHERE username=? AND password=?";
    final private static String SQL_FIND_USER_BY_ID                     = "SELECT * FROM user WHERE user_id=?";
    final private static String SQL_ADD_USER                            = "INSERT INTO user(username, nickname, password, phone, email, privilege) VALUES(?,?,?,?,?,?)";
    final private static String SQL_DELETE_USER                         = "DELETE FROM user WHERE user_id=?";
    final private static String SQL_UPDATE_PROFILE_USER                 = "UPDATE user SET nickname=?,phone=?, email=? WHERE user_id=?";
    final private static String SQL_UPDATE_PROFILE_SUPER                = "UPDATE user SET nickname=?,phone=?,email=?,privilege=? WHERE user_id=?";
    final private static String SQL_UPDATE_PASSWORD_USER                = "UPDATE user SET password=? WHERE user_id=?";

    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    public boolean isExist(String username){
        Object[] params = new Object[]{username};
        int[] types = new int[]{Types.VARCHAR};
        return this.jdbcTemplate.queryForObject(SQL_IS_USER_EXIST, params, types, Integer.class)>0;
    }

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User find(String username, String password){
        Object[] params = new Object[]{username, password};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR};
        List<User> users = this.jdbcTemplate.query(SQL_FIND_USER_BY_USERNAME_AND_PASSWORD, params, types, new UserRowMapper());
        return users.isEmpty()?null:users.get(0);
    }

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    public User find(int userId){
        Object[] params = new Object[]{userId};
        int[] types = new int[]{Types.INTEGER};
        List<User> users = this.jdbcTemplate.query(SQL_FIND_USER_BY_ID, params, types, new UserRowMapper());
        return users.isEmpty()?null:users.get(0);
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    public boolean add(User user){
        Object[] params = new Object[]{user.getUsername(), user.getNickname(), user.getPassword(),
                user.getPhone(), user.getEmail(), user.getPrivilege()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TINYINT};
        return this.jdbcTemplate.update(SQL_ADD_USER, params, types) > 0;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    public boolean delete(int userId){
        Object[] params = new Object[]{userId};
        int[] types = new int[]{Types.INTEGER};
        return this.jdbcTemplate.update(SQL_DELETE_USER, params, types) > 0;
    }

    /**
     * 更新用户基本属性：昵称，电话，邮箱
     * @param user
     * @return
     */
    public boolean update(User user){
        Object[] params = new Object[]{user.getNickname(), user.getPhone(), user.getEmail(), user.getUserId()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER};
        return this.jdbcTemplate.update(SQL_UPDATE_PROFILE_USER, params, types) > 0;
    }

    /**
     * 管理员更新用户基本属性： 昵称，电话，邮箱，权限
     * @param user
     * @return
     */
    public boolean superUpdate(User user){
        Object[] params = new Object[]{user.getNickname(), user.getPhone(), user.getEmail(), user.getPrivilege(), user.getUserId()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TINYINT, Types.INTEGER};
        return this.jdbcTemplate.update(SQL_UPDATE_PROFILE_SUPER, params, types) > 0;
    }

    /**
     * 修改用户密码
     * @param user
     * @return
     */
    public boolean updatePassword(User user){
        Object[] params = new Object[]{user.getPassword(), user.getUserId()};
        int[] types = new int[]{Types.VARCHAR, Types.INTEGER};
        return this.jdbcTemplate.update(SQL_UPDATE_PASSWORD_USER, params, types) > 0;
    }

    class UserRowMapper implements RowMapper<User>{
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setUserId(resultSet.getInt(USER_ID_FIELD_NAME));
            user.setUsername(resultSet.getString(USERNAME_FIELD_NAME));
            user.setNickname(resultSet.getString(NICKNAME_FIELD_NAME));
            user.setPassword(resultSet.getString(PASSWORD_FIELD_NAME));
            user.setPhone(resultSet.getString(PHONE_FIELD_NAME));
            user.setEmail(resultSet.getString(EMAIL_FIELD_NAME));
            user.setPrivilege(resultSet.getInt(PRIVILEGE_FIELD_NAME));
            return user;
        }
    }
}
