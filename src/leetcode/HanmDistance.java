package leetcode;

/**
 * Created by GraceYang on 2017/8/24.
 */
public class HanmDistance {
    public int hammingDistance(int x, int y) {
        int z=x^y;
        int count=0;
        while(z>0){
            if(z%2==1){
                count++;
            }
            z=z/2;
        }
        return count;
    }
    public static void main(String args[]){
        System.out.println(new HanmDistance().hammingDistance(1,4));
    }
}
