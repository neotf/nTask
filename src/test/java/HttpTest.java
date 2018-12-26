import io.github.biezhi.request.Request;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTest {
    @Test
    public void main() throws Exception {
        String url1 = "http://cf.mora.jp/contents/package/0000/00000031/0012/876/924/packageMeta.json";

        URL url = new URL(url1);
        //得到connection对象。
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //设置请求方式
        connection.setRequestMethod("GET");
        //连接
        connection.connect();
        //得到响应码
        int responseCode = connection.getResponseCode();

        String body = Request.get(url1).message();
        System.out.println(body);
    }
}
