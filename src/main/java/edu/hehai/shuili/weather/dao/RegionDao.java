package edu.hehai.shuili.weather.dao;

import edu.hehai.shuili.weather.pojo.Region;
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
 * @Time: 7:39 PM
 * @package_name: edu.hehai.shuili.weather.dao
 * @Description:
 */
@Repository
public class RegionDao {

    /**
     * field name list in region table
     */
    private final static String REGION_ID_FIELD_NAME        = "region_id";
    private final static String REGION_CODE_FIELD_NAME      = "region_code";
    private final static String REGION_NAME_FIELD_NAME      = "region_name";
    private final static String PARENT_ID_FIELD_NAME        = "parent_id";
    private final static String REGION_LEVEL_FIELD_NAME     = "region_level";
    private final static String REGION_ORDER_FIELD_NAME     = "region_order";
    private final static String REGION_NAME_EN_FIELD_NAME   = "region_name_en";
    private final static String REGION_SHORT_NAME_EN_FIELD_NAME    = "region_short_name_en";


    /**
     * sql
     */
    private final static String SQL_FIND_REGION_BY_ID           = "SELECT * FROM region WHERE region_id = ?";
    private final static String SQL_FIND_ALL_PROVINCE           = "SELECT * FROM region WHERE parent_id = 1";
    private final static String SQL_FIND_ALL_CITY_OF_PROVINCE   = "SELECT * FROM region WHERE parent_id = ?";
    private final static String SQL_FIND_PAGE_REGION            = "SELECT * FROM region LIMIT ?,?";
    private final static String SQL_COUNT_REGION                = "SELECT count(1) FROM region";

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public RegionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 根据区域id查找区域
     * @param regionId
     * @return
     */
    public Region find(int regionId){
        Object[] params = new Object[]{regionId};
        List<Region> list =  this.jdbcTemplate.query(SQL_FIND_REGION_BY_ID, params, new RegionRowMapper());
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * 查询所有的省份列表
     * @return
     */
    public List<Region> findAllProvince(){
        return this.jdbcTemplate.query(SQL_FIND_ALL_PROVINCE, new RegionRowMapper());
    }

    /**
     * 查询某个省份的所有城市
     * @param provinceId
     * @return
     */
    public List<Region> findAllCityOfProvince(int provinceId){
        Object[] params = new Object[]{provinceId};
        int[] types = new int[]{Types.INTEGER};
        return this.jdbcTemplate.query(SQL_FIND_ALL_CITY_OF_PROVINCE, params, types, new RegionRowMapper());
    }

    /**
     * 分页返回城市信息
     * @param pageNum
     * @return
     */
    public Page<Region> findPage(int pageNum){
        Page<Region> page = new Page <Region>();

        Object[] params = new Object[]{(pageNum - 1) * page.getPageSize(), page.getPageSize()};
        int[] types = new int[]{Types.INTEGER, Types.INTEGER};
        List<Region> regions = this.jdbcTemplate.query(SQL_FIND_PAGE_REGION, params, types, new RegionRowMapper());

        page.setList(regions);
        page.setCurrentPage(pageNum);
        page.setCurrentSize(regions.size());

        int itemCount = count();
        page.setTotalCount(itemCount);
        page.setTotalPage(itemCount / page.getPageSize() + 1);

        return page;
    }


    /**
     * 返回总记录数
     * @return 总记录数
     */
    public int count(){
        return this.jdbcTemplate.queryForObject(SQL_COUNT_REGION, Integer.class);
    }


    class RegionRowMapper implements RowMapper<Region>{
        public Region mapRow(ResultSet resultSet, int i) throws SQLException {
            Region region = new Region();
            region.setRegionId(resultSet.getInt(REGION_ID_FIELD_NAME));
            region.setRegionCode(resultSet.getInt(REGION_CODE_FIELD_NAME));
            region.setRegionName(resultSet.getString(REGION_NAME_FIELD_NAME));
            region.setParentId(resultSet.getInt(PARENT_ID_FIELD_NAME));
            region.setRegionLevel(resultSet.getInt(REGION_LEVEL_FIELD_NAME));
            region.setRegionOrder(resultSet.getInt(REGION_ORDER_FIELD_NAME));
            region.setRegionNameEn(resultSet.getString(REGION_NAME_EN_FIELD_NAME));
            region.setRegionShortNameEn(resultSet.getString(REGION_SHORT_NAME_EN_FIELD_NAME));
            return region;
        }
    }
}
