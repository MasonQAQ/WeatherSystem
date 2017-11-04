package edu.hehai.shuili.weather.controller;

import edu.hehai.shuili.weather.api.ApiStatus;
import edu.hehai.shuili.weather.api.ReturnPureNotifyApi;
import edu.hehai.shuili.weather.exception.BaseRestException;
import edu.hehai.shuili.weather.exception.NoPermissionException;
import edu.hehai.shuili.weather.exception.error.RestError;
import org.apache.log4j.Logger;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;


/**
 * Created by yangyue
 *
 * @Date: 27/10/2017
 * @Time: 10:23 AM
 * @package_name: edu.hehai.shuili.weather.controller
 * @Description: controller优化，所有的异常在此处统一处理
 */
@RestControllerAdvice
public class ExceptionAdvice {


    private static Logger logger = Logger.getLogger(ExceptionAdvice.class);

    /**
     * 400 - Bad Request
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ReturnPureNotifyApi handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ReturnPureNotifyApi(ApiStatus.BAD_REQUEST);
    }

    /**
     * 403 - 无权访问
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(NoPermissionException.class)
    public ReturnPureNotifyApi handleNoPermissionException(NoPermissionException e){
        return new ReturnPureNotifyApi(ApiStatus.NO_PERMISSION);
    }

    /**
     * 405 - Method Not Allowed
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ReturnPureNotifyApi handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("[METHOD NOT ALLOWED] " + e.getMessage());
        return new ReturnPureNotifyApi(ApiStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * 415 - Unsupported Media Type
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ReturnPureNotifyApi handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        return new ReturnPureNotifyApi(ApiStatus.UNSUPPORTED_MEDIA_TYPE);
    }



    /**
     * 类型转换异常
     * @param e
     * @return
     */
    @ExceptionHandler(ClassCastException.class)
    public ReturnPureNotifyApi classCastExceptionHandler(ClassCastException e) {
        return new ReturnPureNotifyApi(ApiStatus.CLASS_CAST_ERROR);
    }

    /**
     * 参数不匹配异常
     * @param e
     * @return
     */
    @ExceptionHandler({TypeMismatchException.class})
    public ReturnPureNotifyApi requestTypeMismatch(TypeMismatchException e){
        return new ReturnPureNotifyApi(ApiStatus.REQUEST_TYPE_MISMATCH);
    }

    /**
     * 400 - Bad Request 参数缺失异常
     * @param e
     * @return
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ReturnPureNotifyApi requestMissingServletRequest(MissingServletRequestParameterException e){
        return new ReturnPureNotifyApi(ApiStatus.REQUEST_MISSING_PARAM);
    }

    /**
     * 业务自定义
     * @param e
     * @return
     */
    @ExceptionHandler(BaseRestException.class)
    public ResponseEntity<RestError> baseRestException(BaseRestException e) {
        e.printStackTrace();
        return new ResponseEntity<RestError>(new RestError(e.getCode(), e.getErrors()), e.getStatus());
    }

    /**
     * 500 - Internal Server Error
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ReturnPureNotifyApi handleException(Exception e) {
        e.printStackTrace();
        return new ReturnPureNotifyApi(ApiStatus.INTERNAL_SERVER_ERROR);
    }
}