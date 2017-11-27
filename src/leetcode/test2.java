package leetcode;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/10.
 */
public class test2 {
    public static void main(String args[]){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(1,3);
        map.put(2,4);
        if(map.get(4)!=1){
            System.out.println("true");
        }
    }
}


