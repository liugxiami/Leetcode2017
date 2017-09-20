package com.ccsi.tests;

/**
 * Created by gxliu on 2017/9/19.
 */
public class fibo {
    public static void main(String[] args) {
        System.out.println(fibo3(10));
    }
    public static int count=0;

    public static int fibo(int num){
        System.out.println(++count);
        if(num<0)return 0;
        if(num<=1)return num;

        return fibo(num-1)+fibo(num-2);
    }

    public static int fibo1(int num){
        if(num<0)return 0;
        if(num<=1)return num;
        int[] cache=new int[num+1];
        cache[0]=0;
        cache[1]=1;
        for (int i = 2; i <=num; i++) {
            cache[i]=cache[i-1]+cache[i-2];
        }
        return cache[num];
    }

    public static int fibo3(int num){
        if(num<0)return 0;
        if(num<=1)return num;
        int a=0,b=1;
        for (int i = 2; i <= num; i++) {
            int c=a+b;
            a=b;
            b=c;
        }
        return b;
    }

    public static int fibo2(int num,int[] cache){
        if(num<0)return 0;
        if(num<=1)return num;
        cache[0]=0;
        cache[1]=1;
        if(cache[num]!=0)return cache[num];
        else {
            System.out.println(++count);
            cache[num]=fibo2(num-1,cache)+fibo2(num-2,cache);
            return cache[num];
        }
    }


}
