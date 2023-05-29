package com.lk.modules.utils;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author lk
 * @Date
 */
@Data
@Accessors(chain = true)
public class RPage<T> implements Serializable {
    private long code;
    private T data;
    private String message;
    private Integer page;
    private Integer limit;
    private Long total;

    public RPage() {

    }

    public RPage(long code, T data, String message, Integer page, Integer limit, Long total) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.page = page;
        this.limit = limit;
        this.total = total;
    }


    public static <T> RPage<T> ok(T data, Integer page, Integer limit, Long total) {
        return restResult(data, ApiErrorCode.SUCCESS, page, limit, total);
    }

    public static <T> RPage<T> error(T data) {
        ApiErrorCode aec = ApiErrorCode.FAILED;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            aec = ApiErrorCode.FAILED;
        }
        return restResult(data, aec);
    }


    public static <T> RPage<T> failed(String msg) {
        return restResult(null, ApiErrorCode.FAILED.getCode(), msg);
    }

    public static <T> RPage<T> restResult(T data, IErrorCode errorCode) {
        return restResult(data, errorCode.getCode(), errorCode.getMsg());
    }

    public static <T> RPage<T> restResult(T data, IErrorCode errorCode, Integer page, Integer limit, Long total) {
        return restResult(data, errorCode.getCode(), errorCode.getMsg(), page, limit, total);
    }

    private static <T> RPage<T> restResult(T data, long code, String msg) {
        RPage<T> result = new RPage<>();
        result.setCode(code);
        result.setData(data);
        result.setMessage(msg);
        return result;
    }

    private static <T> RPage<T> restResult(T data, long code, String msg, Integer page, Integer limit, Long total) {
        RPage<T> result = new RPage<>();
        result.setCode(code);
        result.setData(data);
        result.setMessage(msg);
        result.setLimit(limit);
        result.setPage(page);
        result.setTotal(total);
        return result;
    }


}
