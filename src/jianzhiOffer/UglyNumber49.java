package jianzhiOffer;

/**
 * Created by GraceYang on 2018/3/5.
 */
public class UglyNumber49 {
    public int getUglyNumber(int index){
        if(index<=0)
            return 0;
        int uglynumbers[]=new int[index];
        uglynumbers[0]=1;
        int count=1;
        int i2=0,i3=0,i5=0;
        while(count<index){
            int min=Min(uglynumbers[i2]*2,uglynumbers[i3]*3,uglynumbers[i5]*5);
            uglynumbers[count]=min;
            if(uglynumbers[i2]*2==min)  i2++;
            if(uglynumbers[i3]*3==min)  i3++;
            if(uglynumbers[i5]*5==min)  i5++;
            count++;
        }
        return uglynumbers[index-1];
    }
    public int Min(int a,int b,int c){
        int min1=a<b?a:b;
        int min2=min1<c?min1:c;
        return min2;
    }

    public static void main(String[] args) {
        System.out.print(new UglyNumber49().getUglyNumber(5));
    }
}
