package OnlineJudge.qunaer;
import java.util.*;
public class diyiti{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        String[] dicts=scan.nextLine().split(" ");
        Set<String> wordset=new HashSet<String>();
        for(String w:dicts){
            wordset.add(w.toLowerCase());
        }
        StringBuffer stringbuffer=new StringBuffer(str);
        String last=stringbuffer.reverse().toString();
        System.out.print(getLength(str,last,wordset));
    }

    public static int getLength(String first, String last, Set<String> wordset) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = first.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(first);
        endSet.add(last);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordset.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }
}