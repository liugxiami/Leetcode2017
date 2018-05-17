package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/5/16.
 */
public class LC405ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        System.out.println(toHex1(-2));
    }
    //method1 最土的方法就是对num不断取余
    private static char[] map={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public static String toHex(int num){
        int flag=1;
        if(num<0){
            num=-num;
            flag=-1;
        }

        StringBuilder sb=new StringBuilder();
        while(num>0){
            sb.append(map[num%16]);
            num/=16;
        }

        String result=sb.reverse().toString();
        if(flag==-1){
            result=getNegative(result);
        }
        return result;
    }
    private static String getNegative(String str){
        int len=8-str.length();
        StringBuilder strFormat=new StringBuilder();
        while(len-->0){
            strFormat.append('0');
        }
        strFormat.append(str);

        char[] cs=new char[8];
        for (int i = 0; i < 8; i++) {
            char c=strFormat.charAt(i);
            int curr=0;
            if(c>='a'&&c<='f')curr=c-'a'+10;
            else curr=c-'0';

            cs[i]= map[15-curr];
        }

        int index=7;
        while(index>=0&&cs[index]=='f'){
            cs[index]='0';
            index--;
        }
        if(index>=0){
            char c=cs[index];
            int curr=0;
            if(c>='a'&&c<'f')curr=c-'a'+10;
            else curr=c-'0';
            cs[index]= map[curr+1];
        }

        String result=new String(cs);
        return result;
    }
    //method2 其实有更好的方法，16进制在二进制上占4个bit，不断对15取与，然后无符号右移4位
    //直接将num当做二进制的数字去处理，然后每4位映射一次就好,然后逻辑位移就好
    public static String toHex1(int num){
        if(num==0)return "0";
        StringBuilder sb=new StringBuilder();
        while(num!=0){ //这个判断是不等于0，因为有可能是负数
            sb.append(map[num&15]); //二进制上最右边4位，根据map，将这个字符append到sb上去，其实就是对16取余。
            num=(num>>>4); //相当于除以16.
        }
        return sb.reverse().toString();
    }
}
