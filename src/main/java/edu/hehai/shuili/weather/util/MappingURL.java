package edu.hehai.shuili.weather.util;

import org.springframework.stereotype.Component;

/**
 * Created by yangyue
 *
 * @Date: 27/10/2017
 * @Time: 1:56 PM
 * @package_name: edu.hehai.shuili.weather.util
 * @Description: 所有的url都在这儿了
 */
@Component
public class MappingURL {

    /**
     * base url
     */
    public final static String ROOT_URL                             = "/";
    public final static String INDEX_URL                            = "/index";
    public final static String CITY_BASE_URL                        = "/city";
    public final static String USER_BASE_URL                        = "/user";
    public final static String REGION_BASE_URL                      = "/region";
    public final static String WEATHER_BASE_URL                     = "/weather";

    /**
     * common crud url
     */
    public final static String COMMON_ADD_URL                       = "/add";
    public final static String COMMON_DELETE_URL                    = "/delete";
    public final static String COMMON_FIND_URL                      = "/find";
    public final static String COMMON_UPDATE_URL                    = "/update";

    /**
     *  city url
     */
    public final static String CITY_FIND                            = "/page/{pageNum}";
    public final static String CITY_ADD                             = "/add/{regionId}";
    public final static String CITY_DELETE                          = "/delete/{regionId}";

    /**
     * region url
     */
    public final static String REGION_FIND                          = "/find/{regionId}";
    public final static String REGION_FIND_ALL_PROVINCE_URL         = "/findAllProvince";
    public final static String ENGION_FIND_ALL_CITY_OF_PROVINCE_URL = "/findAllCityOfProvince/{provinceId}";


    /**
     * user url
     */
    public final static String USER_LOGIN_URL                       = "/login";
    public final static String USER_REGISTER_URL                    = "/register";
    public final static String USER_DELETE_URL                      = "/delete/{userId}";
    public final static String USER_IS_EXIST_URL                    = "/isExist";
    public final static String USER_PROFILE_UPDATE                  = "/update/profile";
    public final static String USER_PASSWORD_UPDATE                 = "/update/password";
}
