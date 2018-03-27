package genericity;

import java.util.HashMap;

/**
 * Created by GraceYang on 2018/2/27.
 */
public class testadd {
    public static void main(String[] args) {
//        int i=0;
//        boolean b=true?false:false?false:true;
//        System.out.println(b);
        HashMap map=new HashMap();
        map.put("name",null);
        map.put("name","Jack");
        System.out.println(map.size());

    }
}
