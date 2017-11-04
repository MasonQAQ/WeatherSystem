package edu.hehai.shuili.weather.exception;

import edu.hehai.shuili.weather.api.ApiStatus;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * Created by yangyue
 *
 * @Date: 30/10/2017
 * @Time: 11:04 AM
 * @package_name: edu.hehai.shuili.weather.exception
 * @Description: 参数验证异常
 */
public class ValidationException extends BaseRestException {

    private static final long serialVersionUID = 5495053837578511264L;

    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;
    private static final int CODE = ApiStatus.VALID_ERROR.getCode();

    public ValidationException(List<FieldError> errors) {
        super(STATUS, CODE,  toRestFieldErrorList(errors));
    }

}
