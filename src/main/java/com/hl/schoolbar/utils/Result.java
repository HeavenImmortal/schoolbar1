package com.hl.schoolbar.utils;
import java.util.HashMap;

/**
 * author: huangLong
 * date:2021/2/3 15:11
 * describe:结果返回处理类
 */

public class Result extends HashMap<String, Object> {

    private Result(int code, String message) {
        super.put("code", code);
        super.put("msg", message);
    }
    public static com.hl.schoolbar.utils.Result ok(String message) {
        return new com.hl.schoolbar.utils.Result(200, message);
    }
    public static com.hl.schoolbar.utils.Result ok() {
        return new com.hl.schoolbar.utils.Result(200, "success");
    }
    public static com.hl.schoolbar.utils.Result ok(int code) {
        return new com.hl.schoolbar.utils.Result(code, "success");
    }

    public static com.hl.schoolbar.utils.Result error(int code, String message) {
        return new com.hl.schoolbar.utils.Result(code, message);
    }

    public static com.hl.schoolbar.utils.Result error(String message) {
        return com.hl.schoolbar.utils.Result.error(500, message);
    }

    @Override
    public com.hl.schoolbar.utils.Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}