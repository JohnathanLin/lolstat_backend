package com.windypath.lolstat.commons;

import java.io.Serializable;

/**
 * @author 乔纳森先生
 * @description ResponseData
 * @date 2020/1/28 11:48
 */
public class ResponseData<T> implements Serializable {

    /**
     * 响应编码
     */
    private int code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    private ResponseData(int code) {
        this.code = code;
    }

    private ResponseData(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private ResponseData(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    private ResponseData(int code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    /************************ 响应成功返回对象 ***************************/
    public static <T> ResponseData<T> success() {
        return new ResponseData<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseData<T> success(T data) {
        return new ResponseData<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ResponseData<T> success(String message, T data) {
        return new ResponseData<T>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ResponseData<T> successMessage(String message) {
        return new ResponseData<T>(ResponseCode.SUCCESS.getCode(), message);
    }
    /************************ 响应成功返回对象 ***************************/


    /************************ 响应错误异常返回对象 ***************************/
    public static <T> ResponseData<T> error() {
        return new ResponseData<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ResponseData<T> error(ResponseCode responseCode) {
        return new ResponseData<T>(responseCode.getCode(), responseCode.getDesc());
    }

    public static <T> ResponseData<T> error(String message, T data) {
        return new ResponseData<T>(ResponseCode.ERROR.getCode(), message, data);
    }

    public static <T> ResponseData<T> errorMessage(String message) {
        return new ResponseData<T>(ResponseCode.ERROR.getCode(), message);
    }
    /************************ 响应错误异常返回对象 ***************************/


    /************************ 响应其他异常返回对象 ***************************/
    public static <T> ResponseData<T> error(int code, String message) {
        return new ResponseData<T>(code, message);
    }
    /************************ 响应其他异常返回对象 ***************************/
}
