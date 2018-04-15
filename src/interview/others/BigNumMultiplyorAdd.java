package interview.others;

/**
 * Created by Administrator on 2018/4/9.
 */
public class BigNumMultiplyorAdd {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                result[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        for (int i = result.length - 1; i > 0; i--) {
            if (result[i] >= 10) {
                result[i-1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        String ans = "";
        boolean flag = false;
        for (int i = 0; i < result.length; i++) {
            if (flag || result[i] != 0) {
                flag = true;
                ans += result[i];
            }
        }
        return ans.equals("") ? "0" : ans;
    }
    public String Add(String num1, String num2){
        return "";
    }
}
