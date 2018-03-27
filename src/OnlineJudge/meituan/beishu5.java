package OnlineJudge.meituan;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2018/3/16.
 * 数组中连续几个数之和是5的倍数，请问最小几个数？
 */
public class beishu5 {
    public int getleastnum(int array[]){
        int sum1=0;
        int sum2=0;
        int result=111111111;
        for(int i=0;i<array.length;i++){
            sum1+=array[i];
            sum2=sum1;
            for(int j=i+1;j<array.length;j++){
                sum2+=array[j];
                if((sum2-sum1)%5==0)
                    if(j-i<result)
                        result=j-i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int array[]={2,4,3,3,8,6,7,6,1};
        System.out.println(new beishu5().getleastnum(array));
    }
}
