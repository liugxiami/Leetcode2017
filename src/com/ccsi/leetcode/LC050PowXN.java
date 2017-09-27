package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/24.
 */
public class LC050PowXN {
    public static void main(String[] args) {
        System.out.println(myPow(3,14));
    }

    public static double myPow(double x,int n){
        if(x==0)return 0;
        if(n==0)return 1;

        int recipretical=1;
        if(n<0){
            recipretical=-1;
            n=-(n+1);
        }

        double result=helper(x,n);
        return(recipretical==-1)?1/(result*x):result;
    }
    //runtime error 超时
    private static double helper(double x,int n){
        if(n==1)return x;
        int half=n/2;
        double temp=helper(x,half);
        if(n%2==0)return temp*temp;
        else return temp*temp*x;
    }

    private static double helper1(double x,int n){
        int temp=n;
        double res=1;
        double p=x;
        while(temp>0){
            if((temp&1)==1)res*=p;
            p*=p;
            temp>>=1;
        }
        return res;
    }
}
