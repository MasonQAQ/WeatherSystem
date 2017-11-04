package edu.hehai.shuili.weather.exception;

import com.sun.corba.se.spi.ior.ObjectKey;
import edu.hehai.shuili.weather.api.ApiStatus;
import org.springframework.http.HttpStatus;

/**
 * Created by yangyue
 *
 * @Date: 30/10/2017
 * @Time: 1:58 PM
 * @package_name: edu.hehai.shuili.weather.exception
 * @Description: 资源已经存在异常
 */
public class ExistedException extends BaseRestException {
    private static final long serialVersionUID = 6915629262486503046L;

    private static final HttpStatus STATUS = HttpStatus.CONFLICT;
    private static final int CODE = ApiStatus.USER_EXIST.getCode();

    public ExistedException(String fieldName, Object fieldValue) {
        super(STATUS, CODE, fieldName, fieldValue);
    }

}
