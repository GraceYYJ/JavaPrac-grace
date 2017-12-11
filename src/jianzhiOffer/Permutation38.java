package jianzhiOffer;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/9.
 */
public class Permutation38 {
    ArrayList<String> arrayList=new ArrayList<String>();
    StringBuffer buffer;
    public ArrayList<String> Permutation(String str) {
        if(str==null||str.length()<=0)
            return arrayList;
        int index=0;
        buffer=new StringBuffer(str);
        PermutationCore(0);
        return arrayList;
    }
    public void PermutationCore(int index){
        if(index==buffer.length()-1){
            arrayList.add(buffer.toString());
        }
        else {
            for(int i=index;i<buffer.length();i++){
                swap(i,index);
                PermutationCore(index+1);
                swap(i,index);
            }
        }
    }
    public void swap(int i,int j){
        char a=buffer.charAt(i);
        char b=buffer.charAt(j);
        buffer.setCharAt(i,b);
        buffer.setCharAt(j,a);
    }

    public static void main(String[] args) {
        String str1=null;
        Permutation38 test=new Permutation38();
        ArrayList<String> lists=test.Permutation(str1);
        for(int i=0;i<lists.size();i++){
            System.out.println(lists.get(i));
        }
    }
}
