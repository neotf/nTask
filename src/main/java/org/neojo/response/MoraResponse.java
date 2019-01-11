package org.neojo.response;

import lombok.Getter;

import java.io.InputStream;

@Getter
public class MoraResponse {
    private InputStream is;
    private int code;
    private int id;
    private String charset;

    public MoraResponse(int code, int id, InputStream is, String charset) {
        this.code = code;
        this.id = id;
        this.is = is;
        this.charset = charset;
    }
}
