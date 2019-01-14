package org.neojo.config;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Request 请求
 *
 * @author biezhi
 * @date 2018/1/11
 */
@Getter
public class RequestConfig {
    private String method = "GET";
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> cookies = new HashMap<>();
    private String contentType = "text/html; charset=UTF-8";
    private String charset = "UTF-8";

    public RequestConfig() {
        this.header("User-Agent", new Config().userAgent());
    }

    public RequestConfig header(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public RequestConfig cookie(String key, String value) {
        this.cookies.put(key, value);
        return this;
    }

    public String header(String key) {
        return this.headers.get(key);
    }

    public String cookie(String key) {
        return this.cookies.get(key);
    }

    public String contentType() {
        return contentType;
    }

    public RequestConfig contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public String charset() {
        return charset;
    }

    public RequestConfig charset(String charset) {
        this.charset = charset;
        return this;
    }

    public RequestConfig method(String method) {
        this.method = method;
        return this;
    }

    public String method() {
        return this.method;
    }
}
