package jianzhiOffer;

/**
 * Created by Administrator on 2017/11/16.
 */
public class cutString_dongtaiguihua {
    public int maxOfcutString(int length){
        if(length<2) return 0;
        if(length==2) return 1;
        if(length==3) return 2;

        int array[]=new int[length+1];
        //如果length>3,剪绳子时遇到2/3，不剪的乘积比剪大
        array[0]=0;
        array[1]=1;
        array[2]=2;
        array[3]=3;

        int max=0;
        for(int i=4;i<=length;i++){
            for(int j=1;j<=i/2;j++){
                int temp=array[j]*array[i-j];
                if(temp>max)
                    max=temp;
            }
            array[i]=max;
        }
        max=array[length];
        return max;
    }
    public int maxOfcutString2(int length){
        int mod=0;
        int result=0;

        if(length<2) return 0;
        if(length==2) return 1;
        if(length==3||length==4) return 2;
        else {
            if(length%3==1) {
                result=(int)(4*Math.pow(3,(length-4)/3));
            }
            if(length%3==0) {
                result=(int)(Math.pow(3,(length/3)));
            }
            else{
                mod=length%3;
                result=(int)(mod*Math.pow(3,(length-mod)/3));
            }
            return result;
        }



    }
    public static void main(String[] args) {
        cutString_dongtaiguihua rope=new cutString_dongtaiguihua();
        System.out.println(rope.maxOfcutString2(8));
        System.out.println(rope.maxOfcutString2(6));
        System.out.println(rope.maxOfcutString2(50));
    }
}
