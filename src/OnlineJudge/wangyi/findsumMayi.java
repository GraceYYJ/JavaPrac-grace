package OnlineJudge.wangyi;

/**
 * Created by Administrator on 2018/3/15.
 */
public class findsumMayi {
    public int[] findsum(int array[],int target){
        int result[]=new int[2];
        try{
            for(int i=0;i<array.length;i++){
                for(int j=i+1;j<array.length;j++){
                    if(array[i]+array[j]==target){
                        result[0]=i;
                        result[1]=j;
                        System.out.println(i+","+j);
                        return result;
                    }
                }
            }
            throw new Exception();
        }
        catch (Exception e){
            System.out.println("ddd");
            //e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        int array[]={3,10,17,9};
        new findsumMayi().findsum(array,6);
    }
}
