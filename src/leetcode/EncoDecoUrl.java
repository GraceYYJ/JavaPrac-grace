package leetcode;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/8/6.
 */
public class EncoDecoUrl {
    HashMap<String,String> URL=new HashMap<String, String>();
    public String encode(String longUrl){
        String tinyUrl="http://tinyurl.com/"+longUrl.hashCode();
        URL.put(tinyUrl,longUrl);
        return tinyUrl;
    }
    public String decode(String tinyUrl){
        String longUrl=URL.get(tinyUrl);
        return longUrl;
    }
    public static void main(String args[]){
        EncoDecoUrl url=new EncoDecoUrl();
        String longUrl="https://leetcode.com/problems/design-tinyurl";
        String tinyUrl=url.encode(longUrl);
        System.out.println(tinyUrl);
        System.out.println(url.decode((tinyUrl)));
        //System.out.println();
    }

}
