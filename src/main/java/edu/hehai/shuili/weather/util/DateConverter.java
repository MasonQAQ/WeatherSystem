package edu.hehai.shuili.weather.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by yangyue
 *
 * @Date: 27/10/2017
 * @Time: 7:44 PM
 * @package_name: edu.hehai.shuili.weather.util
 * @Description: 前端传入字符串转日期
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String stringDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}