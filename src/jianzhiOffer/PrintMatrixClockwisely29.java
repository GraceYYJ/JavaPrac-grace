package jianzhiOffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2017/12/4.
 */
public class PrintMatrixClockwisely29 {

    public ArrayList<Integer> printMatrixClockwisely(int Matrix[][]) {
        int rows=Matrix.length;
        int coloums=Matrix[0].length;
        int start=0;
        ArrayList<Integer> list=new ArrayList<>();
        if(rows<=0||coloums<=0) return list;
        while(coloums>start*2&&rows>start*2){
            printMatrixinCircle(Matrix,start,list);
            start++;
        }
        return list;
    }

    public void printMatrixinCircle(int Matrix[][],int start,ArrayList<Integer> list){
        int rows=Matrix.length;
        int coloums=Matrix[0].length;
        int endX=coloums-1-start;
        int endY=rows-1-start;
        for(int i=start;i<=endX;i++){
            list.add(Matrix[start][i]);
        }
        if(start<endY){
            for(int i=start+1;i<=endY;i++){
                list.add(Matrix[i][endX]);
            }
        }
        if(start<endX&&start<endY){
            for(int i=endX-1;i>=start;i--){
                list.add(Matrix[endY][i]);
            }
        }
        if(start<endX&&start<endY-1){
            for(int i=endY-1;i>=start+1;i--){
                list.add(Matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        /*int Matrix[][]={{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};*/
        int Matrix[][]={{1},{2},{3},{4},{5}};
        PrintMatrixClockwisely29 test=new PrintMatrixClockwisely29();
        ArrayList<Integer> list=test.printMatrixClockwisely(Matrix);
        Iterator it1 = list.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
    }
}
