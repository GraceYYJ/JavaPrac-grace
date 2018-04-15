package leetcode;

import java.util.*;

/**
 * Created by Administrator on 2018/4/11.
 */
public class KNum {
    public static int[] twosum(int array[],int target){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int result[]=new int[2];
        for(int i=0;i<array.length;i++){
            if(hashMap.containsKey(target-array[i])){
                result[0]=i;
                result[1]=hashMap.get(target-array[i]);
            }
            else{
                hashMap.put(array[i],i);
            }
        }
        return result;
    }

    public static List<List<Integer>> threesum(int array[],int target){
        List<List<Integer>> lists=new LinkedList<>();
        Arrays.sort(array);
        int n=array.length;
        for(int i=0;i<n-2;i++){
            int newtarget=target-array[i];
            int left=i+1;
            int right=n-1;
            while(left<right){
                if(array[left]+array[right]==newtarget){
                    List<Integer> temp=new LinkedList<>();
                    temp.add(array[i]);
                    temp.add(array[left]);
                    temp.add(array[right]);
                    lists.add(temp);
                    left++;
                    right--;
                }
                if(array[left]+array[right]<newtarget)
                    left++;
                if(array[left]+array[right]>newtarget)
                    right--;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int array[]={3,2,3,4,6,2,2};
        List<List<Integer>> lists=threesum(array,8);
        System.out.println(lists);
    }
}
