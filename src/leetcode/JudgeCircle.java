package leetcode;

/**
 * Created by GraceYang on 2017/8/24.
 */
public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int result=0;
        for(int i=0;i<moves.length();i++){
            switch (moves.charAt(i)) {
                case 'L':
                    result=result-1;
                    break;
                case 'R':
                    result=result+1;
                    break;
                case 'D':
                    result=result-1;
                    break;
                case 'U':
                    result=result+1;
                    break;
            }
        }
        if(result==0){
            return true;
        }
        else
            return false;
    }
    public static void main(String args[]){
        System.out.println(new JudgeCircle().judgeCircle("UDLRRL"));
    }
}
