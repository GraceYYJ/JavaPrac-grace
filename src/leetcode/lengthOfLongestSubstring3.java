package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/3/25.
 */
public class lengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<String,Integer> hashMap=new HashMap();
        int maxlength=0;
        int length=0;
        if(s.length()==0)   return 0;
        hashMap.put(String.valueOf(s.charAt(0)),1);
        maxlength++;
        length++;
        for(int i=1;i<s.length();i++){
            if(hashMap.containsKey(String.valueOf(s.charAt(i)))){
                length=1;
                hashMap.clear();
                hashMap.put(String.valueOf(s.charAt(i)),1);
                continue;
            }
            hashMap.put(String.valueOf(s.charAt(i)),1);
            length++;
            if(length>maxlength)
                maxlength=length;
        }
        return maxlength;
    }
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Set<Integer> set1=new HashSet();
        System.out.println(new lengthOfLongestSubstring3().lengthOfLongestSubstring2("dvdfd"));
    }
}
