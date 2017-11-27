package jianzhiOffer;

/**
 * Created by Administrator on 2017/11/16.
 */
public class Power {
    public double power1(double base,int exponent){
        double product=1.0;
        if(exponent==0)
            return 1;
        if(exponent>0){
            for(int i=1;i<=exponent;i++){
                product*=base;
            }
        }
        if(exponent<0){
            exponent=-1*exponent;
            for(int i=1;i<=exponent;i++){
                product*=base;
            }
            product=1/product;
        }
        return product;
    }

    public double power2(double base,int exponent){
        double product=1.0;
        double temp=1.0;
        if(exponent==0)
            return 1;
        if(exponent==1)
            return base;
        else{
            int newexponent=Math.abs(exponent);
            if(newexponent%2==0){
                temp=power2(base,newexponent>>1);
                product*=temp*temp;
            }
            else{
                temp=power2(base,newexponent>>1);
                product*=base*temp*temp;
            }
        }

        if(exponent>0) return product;
        else return 1/product;
    }

    public static void main(String[] args) {
        Power test=new Power();
        System.out.println(test.power2(2,4));
    }
}
