package OnlineJudge.qita;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/8.
 */
public class dengpao {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int kaiguannum=scanner.nextInt();
        int kongzhinum;
        HashSet<Integer> hashSet=new HashSet<>();
        for(int i=0;i<kaiguannum;i++){
            kongzhinum=scanner.nextInt();
            for(int j=0;j<kongzhinum;j++){
                hashSet.add(scanner.nextInt());
            }
        }
        System.out.println(hashSet.size());
    }
}
