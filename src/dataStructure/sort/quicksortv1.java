package dataStructure.sort;

/**
 * Created by Administrator on 2017/11/2.
 */
public class quicksortv1 {
    //public int array[];
    public void quicksort(int x,int y,int array[]){
        int i=x;
        int j=y;
        int flag=array[x];
        int temp;
        if(x>y)
            return;
        while(i!=j){
            while(array[j]>=flag&&i<j){
                j--;
            }
            while(array[i]<=flag&&i<j){
                i++;
            }
            if(i<j){
                temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        array[x]=array[i];
        array[i]=flag;
        if(i>0&&i<array.length-1) {
            quicksort(x, i - 1,array);
            quicksort(i + 1, y,array);
        }
    }

    public static void main(String[] args) {
        quicksortv1 test=new quicksortv1();
        int array[]=new int[]{7,3,9,8,5,2,1,6};
        test.quicksort(0,7,array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
        }
    }
}
