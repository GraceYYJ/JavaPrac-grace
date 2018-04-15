package leetcode;

import java.util.HashSet;

/**
 * Created by Administrator on 2018/3/25.
 */
public class lengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        int length=s.length();
        HashSet<Character> set=new HashSet<>();
        int i=0,j=0,ans=0;
        while(i<length&&j<length){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans=ans>j-i?ans:j-i;
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new lengthOfLongestSubstring3().lengthOfLongestSubstring("abcabcbb"));
    }
}
