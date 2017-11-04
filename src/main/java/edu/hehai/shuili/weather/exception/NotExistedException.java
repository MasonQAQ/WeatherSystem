package edu.hehai.shuili.weather.exception;

import edu.hehai.shuili.weather.api.ApiStatus;
import org.springframework.http.HttpStatus;


/**
 * Created by yangyue
 *
 * @Date: 30/10/2017
 * @Time: 3:47 PM
 * @package_name: edu.hehai.shuili.weather.exception
 * @Description: 资源不存在异常
 */
public class NotExistedException extends BaseRestException {

    private static final long serialVersionUID = 1330458349080010936L;
    private static final HttpStatus STATUS = HttpStatus.CONFLICT;
    private static final int CODE = ApiStatus.USER_NOT_EXIST.getCode();


    public NotExistedException(String fieldName, Object fieldValue) {
        super(STATUS, CODE, fieldName, fieldValue);
    }

}
