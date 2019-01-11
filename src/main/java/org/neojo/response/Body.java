package org.neojo.response;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Body {

    private final InputStream inputStream;
    private final String      charset;
    private       String      bodyString;

    public Body(InputStream inputStream, String charset) {
        this.inputStream = inputStream;
        this.charset = charset;
    }

    @Override
    public String toString() {
        if (null == this.bodyString) {
            StringBuilder html = new StringBuilder(100);
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset));
                String         temp;
                while ((temp = br.readLine()) != null) {
                    html.append(temp).append("\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.bodyString = html.toString();
        }
        return this.bodyString;
    }
}
