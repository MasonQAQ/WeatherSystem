package edu.hehai.shuili.weather.dao;

import edu.hehai.shuili.weather.pojo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

/**
 * Created by yangyue
 *
 * @Date: 26/10/2017
 * @Time: 5:03 PM
 * @package_name: edu.hehai.shuili.weather.dao
 * @Description:
 */
@Repository
public class WeatherDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public WeatherDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    final private static String ID_FIELD_NAME           = "weather_id";         //id
    final private static String CITY_NAME_FIELD_NAME    = "city_name";          //城市名
    final private static String DATE_NAME_FIELD_NAME    = "insert_date";        //采集日期

    /**
     * 未来1-7天天气情况
     */
    final private static String WEATHER_1_FIELD_NAME    = "weather_1";
    final private static String WEATHER_2_FIELD_NAME    = "weather_2";
    final private static String WEATHER_3_FIELD_NAME    = "weather_3";
    final private static String WEATHER_4_FIELD_NAME    = "weather_4";
    final private static String WEATHER_5_FIELD_NAME    = "weather_5";
    final private static String WEATHER_6_FIELD_NAME    = "weather_6";
    final private static String WEATHER_7_FIELD_NAME    = "weather_7";

    /**
     * 未来七天最高温度
     */
    final private static String MAX_TEMP_1_FIELD_NAME   = "max_temp_1";
    final private static String MAX_TEMP_2_FIELD_NAME   = "max_temp_2";
    final private static String MAX_TEMP_3_FIELD_NAME   = "max_temp_3";
    final private static String MAX_TEMP_4_FIELD_NAME   = "max_temp_4";
    final private static String MAX_TEMP_5_FIELD_NAME   = "max_temp_5";
    final private static String MAX_TEMP_6_FIELD_NAME   = "max_temp_6";
    final private static String MAX_TEMP_7_FIELD_NAME   = "max_temp_7";

    /**
     * 未来七天最低温度
     */
    final private static String MIN_TEMP_1_FIELD_NAME   = "min_temp_1";
    final private static String MIN_TEMP_2_FIELD_NAME   = "min_temp_2";
    final private static String MIN_TEMP_3_FIELD_NAME   = "min_temp_3";
    final private static String MIN_TEMP_4_FIELD_NAME   = "min_temp_4";
    final private static String MIN_TEMP_5_FIELD_NAME   = "min_temp_5";
    final private static String MIN_TEMP_6_FIELD_NAME   = "min_temp_6";
    final private static String MIN_TEMP_7_FIELD_NAME   = "min_temp_7";

    /**
     * 未来七天风力
     */
    final private static String WIND_1_FIELD_NAME       = "wind_1";
    final private static String WIND_2_FIELD_NAME       = "wind_2";
    final private static String WIND_3_FIELD_NAME       = "wind_3";
    final private static String WIND_4_FIELD_NAME       = "wind_4";
    final private static String WIND_5_FIELD_NAME       = "wind_5";
    final private static String WIND_6_FIELD_NAME       = "wind_6";
    final private static String WIND_7_FIELD_NAME       = "wind_7";


    /**
     * sql
     */
    final private static String SQL_FIND_WEATHER = "SELECT * FROM weather WHERE city_name=? AND insert_date BETWEEN ? AND ?";
    final private static String SQL_ADD_WEATHER = "INSERT INTO weather(" +
            "city_name, insert_date, " +
            "weather_1, weather_2, weather_3, weather_4, weather_5, weather_6, weather_7," +
            "max_temp_1, max_temp_2, max_temp_3, max_temp_4, max_temp_5, max_temp_6, max_temp_7," +
            "min_temp_1, min_temp_2, min_temp_3, min_temp_4, min_temp_5, min_temp_6, min_temp_7," +
            "wind_1, wind_2, wind_3, wind_4, wind_5, wind_6, wind_7) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";



    /**
     * 根据日期范围查找天气记录
     * @param dateBegin
     * @param dateEnd
     * @return
     */
    public List<Weather> find(Date dateBegin, Date dateEnd, String cityName){
        Object[] params = new Object[]{cityName, dateBegin, dateEnd};
        int[] types = new int[]{Types.VARCHAR, Types.DATE, Types.DATE};
        return this.jdbcTemplate.query(SQL_FIND_WEATHER, params, types, new WeatherRowMapper());
    }


    /**
     * 添加一条天气记录
     * @param weather
     * @return
     */
    public boolean add(Weather weather){
        Object[] params = new Object[]{weather.getCityName(), weather.getInsertDate(),
                weather.getWeather1(), weather.getWeather2(), weather.getWeather3(), weather.getWeather4(),
                weather.getWeather5(), weather.getWeather6(), weather.getWeather7(),
                weather.getMaxTemp1(), weather.getMaxTemp2(), weather.getMaxTemp3(), weather.getMaxTemp4(),
                weather.getMaxTemp5(), weather.getMaxTemp6(), weather.getMaxTemp7(),
                weather.getMinTemp1(), weather.getMinTemp2(), weather.getMinTemp3(), weather.getMinTemp4(),
                weather.getMinTemp5(), weather.getMinTemp6(), weather.getMinTemp7(),
                weather.getWind1(), weather.getWind2(), weather.getWind3(), weather.getWind4(),
                weather.getWind5(), weather.getWind6(), weather.getWind7()};

        int[] types = new int[]{Types.VARCHAR, Types.DATE,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER,
                Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,};

        return this.jdbcTemplate.update(SQL_ADD_WEATHER, params, types) > 0;
    }
    //查询


    class WeatherRowMapper implements RowMapper<Weather>{
        public Weather mapRow(ResultSet resultSet, int i) throws SQLException {
            Weather weather = new Weather();

            weather.setWeatherId(resultSet.getLong(ID_FIELD_NAME));
            weather.setCityName(resultSet.getString(CITY_NAME_FIELD_NAME));
            weather.setInsertDate(resultSet.getDate(DATE_NAME_FIELD_NAME));

            weather.setWeather1(resultSet.getString(WEATHER_1_FIELD_NAME));
            weather.setWeather2(resultSet.getString(WEATHER_2_FIELD_NAME));
            weather.setWeather3(resultSet.getString(WEATHER_3_FIELD_NAME));
            weather.setWeather4(resultSet.getString(WEATHER_4_FIELD_NAME));
            weather.setWeather5(resultSet.getString(WEATHER_5_FIELD_NAME));
            weather.setWeather6(resultSet.getString(WEATHER_6_FIELD_NAME));
            weather.setWeather7(resultSet.getString(WEATHER_7_FIELD_NAME));

            weather.setMaxTemp1(resultSet.getInt(MAX_TEMP_1_FIELD_NAME));
            weather.setMaxTemp2(resultSet.getInt(MAX_TEMP_2_FIELD_NAME));
            weather.setMaxTemp3(resultSet.getInt(MAX_TEMP_3_FIELD_NAME));
            weather.setMaxTemp4(resultSet.getInt(MAX_TEMP_4_FIELD_NAME));
            weather.setMaxTemp5(resultSet.getInt(MAX_TEMP_5_FIELD_NAME));
            weather.setMaxTemp6(resultSet.getInt(MAX_TEMP_6_FIELD_NAME));
            weather.setMaxTemp7(resultSet.getInt(MAX_TEMP_7_FIELD_NAME));

            weather.setMinTemp1(resultSet.getInt(MIN_TEMP_1_FIELD_NAME));
            weather.setMinTemp2(resultSet.getInt(MIN_TEMP_2_FIELD_NAME));
            weather.setMinTemp3(resultSet.getInt(MIN_TEMP_3_FIELD_NAME));
            weather.setMinTemp4(resultSet.getInt(MIN_TEMP_4_FIELD_NAME));
            weather.setMinTemp5(resultSet.getInt(MIN_TEMP_5_FIELD_NAME));
            weather.setMinTemp6(resultSet.getInt(MIN_TEMP_6_FIELD_NAME));
            weather.setMinTemp7(resultSet.getInt(MIN_TEMP_7_FIELD_NAME));

            weather.setWind1(resultSet.getString(WIND_1_FIELD_NAME));
            weather.setWind2(resultSet.getString(WIND_2_FIELD_NAME));
            weather.setWind3(resultSet.getString(WIND_3_FIELD_NAME));
            weather.setWind4(resultSet.getString(WIND_4_FIELD_NAME));
            weather.setWind5(resultSet.getString(WIND_5_FIELD_NAME));
            weather.setWind6(resultSet.getString(WIND_6_FIELD_NAME));
            weather.setWind7(resultSet.getString(WIND_7_FIELD_NAME));

            return weather;
        }
    }

}
