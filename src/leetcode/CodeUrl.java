package leetcode;

import java.util.HashMap;
public class CodeUrl {
    HashMap<String,String> URL=new HashMap<String,String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl="http://tinyurl.com/"+longUrl.hashCode();
        URL.put(shortUrl,longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String longUrl=URL.get(shortUrl);
        return longUrl;
    }

    public static void main(String args[]){
        String longurl="https://leetcode.com/problems/design-tinyurl";
        CodeUrl codec = new CodeUrl();
        String shorturl=codec.encode(longurl);
        String result=codec.decode(shorturl);
        System.out.println(shorturl);
        System.out.println(result);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));