package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/4/25.
 */
public class LC393UTF8Validation {
    public static void main(String[] args) {
        int[] data={248,130,130,130};
        System.out.println(validUtf81(data));
        //System.out.println(getBinary(248));
    }
    //方法1，将每个数的二进制变成string，然后看开头的1的个数，这个数决定了后面应该有几个10开的数，用一个循环来判断。
    public static boolean validUtf8(int[] data){
        if(data==null||data.length==0)return false;
        int len=data.length;
        int step=1;
        for (int i = 0; i < len; i+=step) {
            String curr=getBinary(data[i]);
            if(curr.charAt(0)=='0'){
                step=1;
                continue;
            }
            int index=0;
            while(index<8&&curr.charAt(index)!='0')index++;
            if(index==1)return false; //不能以10开头，10开头的是skip的数。

            step=index;
            if(len<i+index)return false; //i之后必须有足够都的数，并且都是以10开头。
            for (int j = i+1; j <i+index ; j++) {
                String temp=getBinary(data[j]);
                if(!temp.startsWith("10"))return false;
            }
        }
        return true;
    }

    private static String getBinary(int num){
        if(num<0||num>255)return null;
        StringBuilder sb=new StringBuilder();
        int count=8;
        while(num>1){
            sb.append(num&1);
            num>>=1;
            count--;
        }
        sb.append(num);
        count--;
        while(count-->0){
            sb.append(0);
        }
        return sb.reverse().toString();
    }
    //方法2，参考了网上的讨论，用二进制mask更方便。
    public static boolean validUtf81(int[] data){
        if(data==null||data.length==0)return false;
        int len=data.length;
        int skip=0b10000000;
        int check=0;
        for (int i = 0; i < len; i++) {
            if(check>0){
                if((data[i]&skip)==skip)check--;
                else return false;
            }else{
                check=getHeadType(data[i]);
                if(check<0)return false;
            }
        }
        return check==0;
    }
    private static int getHeadType(int data){
        if(data<0||data>255)return -1;
        if((data&0b11111000)==0b11110000)return 3;
        if((data&0b11110000)==0b11100000)return 2;
        if((data&0b11100000)==0b11000000)return 1;
        if((data&0b11000000)==0b10000000)return -1;
        else return 0;
    }
}
