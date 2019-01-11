package org.neojo.response;

import lombok.Getter;

import java.io.InputStream;

public class MoraResponse {
    @Getter
    private InputStream is;
    private int code;
    private int id;

    public MoraResponse(int code, int id, InputStream is) {
        this.code = code;
        this.id = id;
        this.is = is;
    }
}
