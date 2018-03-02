package jianzhiOffer;

/**
 * Created by GraceYang on 2018/3/1.
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
public class MaxInWindows59 {
    public ArrayList<Integer> maxInWindows2(int num[],int size){
        ArrayList<Integer> results=new ArrayList<>();
        if(num.length<size||size<=0)
            return results;
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<num.length;i++){
            if(!deque.isEmpty()&&(i-deque.peekFirst()==size))
                deque.pollFirst();
            while(!deque.isEmpty()&&num[i]>=num[deque.peekLast()]){
                deque.pollLast();
            }
            deque.add(i);
            if(i>=size-1){
                results.add(num[deque.peekFirst()]);
            }
        }
        return results;
    }




















    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (num == null || num.length < size || size == 0) {
            return result;
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < num.length; i++) {
            if (!deque.isEmpty() && (i - deque.peekFirst()) == size) {
                // 如果队列头部的元素已经超出滑动窗口的范围，就将头部元素退出
                deque.pollFirst();
            }
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                // 如果新来的元素比队列最后一个元素大，则将最后一个元素退出
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= (size - 1)) {
                // 如果遍历的元素已经达到一个滑动窗口的大小，就开始提取窗口的最大值了
                result.add(num[deque.peekFirst()]);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int num[]={2,3,4,2,6,2,5,1};
        System.out.println(new MaxInWindows59().maxInWindows2(num,3));
    }
}
