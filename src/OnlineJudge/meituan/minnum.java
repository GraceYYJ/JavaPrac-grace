package OnlineJudge.meituan;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Administrator on 2018/3/22.
 */
public class minnum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int[] nums = new int[10];
        for(int i = 0; i < input.length(); i++){
            nums[input.charAt(i)-'0'] ++;
        }
//        System.out.println(nums.toStri123ng());

        int mix_index = 0;
        int mix_value = 100000;
        for(int i = 1; i <= 9; i++){
            if(nums[i] < mix_value){
                mix_value = nums[i];
                mix_index = i;
            }
        }

        boolean judge = false;
        for(int i = 1; i <= 9; i++){
            if(nums[i] == 0){
                System.out.println(i);
                judge = true;
                break;
            }
        }
        if(judge == false){
            if (nums[0] == 0 || mix_value - nums[0] >= 1) {
                System.out.print(1);
                for (int i = 0; i < nums[0] + 1; i++) {
                    System.out.print(0);
                }
                System.out.println();
            } else {
                for (int i = 0; i < mix_value + 1; i++) {
                    System.out.print(mix_index);
                }
            }
        }

    }

}
