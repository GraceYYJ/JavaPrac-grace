package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/13.
 */
public class EncoandDecoTinyURL {
    Map<String, String> index = new HashMap<String, String>();
    Map<String, String> revIndex = new HashMap<String, String>();
    static String BASE_HOST = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (revIndex.containsKey(longUrl)) return BASE_HOST + revIndex.get(longUrl);
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = (int) (Math.random() * charSet.length());
                sb.append(charSet.charAt(r));
            }
            key = sb.toString();
        } while (index.containsKey(key));
        index.put(key, longUrl);
        revIndex.put(longUrl, key);
        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return index.get(shortUrl.replace(BASE_HOST, ""));
    }
    public static void main(String[] args) {
        EncoandDecoTinyURL test=new EncoandDecoTinyURL();
        System.out.println(test.encode("https://leetcode.com/problems/design-yyjlemon"));
        System.out.println(test.decode(test.encode("https://leetcode.com/problems/design-yyjlemon")));
    }

}
