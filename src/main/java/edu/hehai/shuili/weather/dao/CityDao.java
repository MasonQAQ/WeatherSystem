package edu.hehai.shuili.weather.dao;

import edu.hehai.shuili.weather.pojo.City;
import edu.hehai.shuili.weather.util.Page;
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
 * @Time: 4:56 PM
 * @package_name: edu.hehai.shuili.weather.dao
 * @Description:
 */
@Repository
public class CityDao {

    final private static String CITY_ID_FIELD_NAME      = "city_id";
    final private static String CITY_NAME_FIELD_NAME    = "city_name";
    final private static String PROVINCE_FIELD_NAME     = "province";
    final private static String INSERT_DATE_FIELD_NAME  = "insert_date";
    final private static String REGION_ID_FIELD_NAME    = "region_id";

    final private static String SQL_IS_CITY_EXIST       = "SELECT count(1) FROM city WHERE region_id=?";
    final private static String SQL_FIND_ALL_CITY       = "SELECT * FROM city";
    final private static String SQL_FIND_PAGE_CITY      = "SELECT * FROM city LIMIT ?,?";
    final private static String SQL_ADD_CITY            = "INSERT INTO city(city_name,province,region_id, insert_date) VALUES(?,?,?,now())";
    final private static String SQL_DELETE_CITY         = "DELETE FROM city WHERE region_id = ?";
    final private static String SQL_COUNT_CITY          = "SELECT count(1) FROM city";

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 返回所有城市信息
     * @return
     */
    public List<City> findAll(){
        return this.jdbcTemplate.query(SQL_FIND_ALL_CITY, new CityRowMapper());
    }


    /**
     * 判断城市是否存在
     * @param regionId
     * @return
     */
    public boolean isExist(int regionId){
        Object[] params = new Object[]{regionId};
        int[] types = new int[]{Types.INTEGER};
        return this.jdbcTemplate.queryForObject(SQL_IS_CITY_EXIST, params, types, Integer.class) > 0;
    }

    /**
     * 分页返回城市信息
     * @param pageNum
     * @return
     */
    public Page<City> findPage(int pageNum){
        Page<City> page = new Page <City>();

        Object[] params = new Object[]{(pageNum - 1) * page.getPageSize(), page.getPageSize()};
        int[] types = new int[]{Types.INTEGER, Types.INTEGER};
        List<City> cities = this.jdbcTemplate.query(SQL_FIND_PAGE_CITY, params, types, new CityRowMapper());

        page.setList(cities);
        page.setCurrentPage(pageNum);
        page.setCurrentSize(cities.size());

        int itemCount = count();
        page.setTotalCount(itemCount);
        page.setTotalPage(itemCount / page.getPageSize() + 1);

        return page;
    }

    /**
     * 增加城市
     * @param city
     * @return
     */
    public boolean add(City city){
        Object[] params = new Object[]{city.getCityName(), city.getProvince(), city.getRegionId()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.INTEGER};
        return this.jdbcTemplate.update(SQL_ADD_CITY, params, types) > 0;
    }

    /**
     * 根据城市id删除城市
     * @param regionId
     * @return
     */
    public boolean delete(int regionId){
        Object[] params = new Object[]{regionId};
        int[] types = new int[]{Types.INTEGER};
        return this.jdbcTemplate.update(SQL_DELETE_CITY, params, types) > 0;
    }


    /**
     * 返回总记录数
     * @return 总记录数
     */
    public int count(){
        return this.jdbcTemplate.queryForObject(SQL_COUNT_CITY, Integer.class);
    }


    class CityRowMapper implements RowMapper<City>{
        public City mapRow(ResultSet resultSet, int i) throws SQLException {
            City city = new City();
            city.setCityId(resultSet.getInt(CITY_ID_FIELD_NAME));
            city.setCityName(resultSet.getString(CITY_NAME_FIELD_NAME));
            city.setProvince(resultSet.getString(PROVINCE_FIELD_NAME));
            city.setInsertDate(resultSet.getDate(INSERT_DATE_FIELD_NAME));
            city.setRegionId(resultSet.getInt(REGION_ID_FIELD_NAME));
            return city;
        }
    }

}
