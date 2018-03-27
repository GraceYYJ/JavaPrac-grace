package OnlineJudge;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Scanner;
/**
 * Created by GraceYang on 2018/3/7.
 */
public class beautifulBrickwy{
    public static void main(String args[]){
        beautifulBrickwy test=new beautifulBrickwy();
        Scanner sc=new Scanner(System.in);
        String string=sc.next();
        System.out.println(test.getBeautiCount(string));
    }
    //要找出规律：只有0和2两种情况。有两种颜色，就有两种排列可以满足只有一组相邻，一种颜色或者多种颜色都无法满足。
    //所以：判断该字符串是不是有且仅有2种字符，满足则输出2，不满足则输出0。
    Set<String> treeset2=new TreeSet<>();
    public int getBeautifulCount(String str){
        for(int i=0;i<str.length();i++){
            treeset.add(str.substring(i,i+1));
        }
        if(treeset.size()==1)
            return 1;
        else {
            if(treeset.size()==2)
                return 2;
            else
                return 0;
        }
    }

    //这种方法运行时间太长，非常之蠢！
    Set<String> treeset=new TreeSet<>();
    StringBuffer buffer;
    public int getBeautiCount(String str){
        if(str==null)
            return -1;
        buffer=new StringBuffer(str);
        permutationCore(0);
        int count=0;
        Iterator iterator=treeset.iterator();
        while(iterator.hasNext()){
            String nextstr=iterator.next().toString();
            if(isBeautiful(nextstr))
                count++;
        }
        return count;
    }

    public boolean isBeautiful(String string){
        int count=0;
        char charstr[]=string.toCharArray();
        for(int i=0;i<charstr.length-1;i++){
            if(charstr[i]!=charstr[i+1]){
                count++;
                if(count>=2)
                    return false;
            }
        }
        return true;
    }
    public void permutationCore(int index){
        if(index==buffer.length()-1){
            treeset.add(buffer.toString());
        }
        else{
            for(int i=index;i<buffer.length();i++){
                swap(i,index);
                permutationCore(index+1);
                swap(index,i);
            }
        }
    }
    public void swap(int a,int b){
        char aa=buffer.charAt(a);
        char bb=buffer.charAt(b);
        buffer.setCharAt(a,bb);
        buffer.setCharAt(b,aa);
    }
}