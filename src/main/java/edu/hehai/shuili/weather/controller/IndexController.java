package edu.hehai.shuili.weather.controller;

import edu.hehai.shuili.weather.api.ApiStatus;
import edu.hehai.shuili.weather.api.ReturnPureNotifyApi;
import edu.hehai.shuili.weather.intercepter.Permission;
import edu.hehai.shuili.weather.pojo.Privilege;
import edu.hehai.shuili.weather.util.MappingURL;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangyue
 *
 * @Date: 30/10/2017
 * @Time: 10:02 AM
 * @package_name: edu.hehai.shuili.weather.controller
 * @Description:
 */
@RestController
public class IndexController {

    /**
     * API welcome page
     * @return
     */
    @Permission(value = {Privilege.ADMIN, Privilege.USER})
    @RequestMapping(value = {MappingURL.ROOT_URL, MappingURL.INDEX_URL})
    public ReturnPureNotifyApi index(){
        return new ReturnPureNotifyApi(ApiStatus.SHOW_API_VERSION);
    }
}
