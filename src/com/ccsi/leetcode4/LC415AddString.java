package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/5/29.
 */
public class LC415AddString {
    public static void main(String[] args) {
        String num1="1234";
        String num2="43210000";
        System.out.println(addStrings1(num1,num2));
    }
    //method1 format to same length.
    public static String addStrings(String num1,String num2){
        if(num1==null||num1.length()==0)return num2;
        if(num2==null||num2.length()==0)return num1;

        int len1=num1.length();
        int len2=num2.length();
        int len=Math.max(len1,len2);

        num1=format(num1,len);
        num2=format(num2,len);

        int flag=0;
        StringBuilder sb=new StringBuilder();
        for (int i = len-1; i >=0; i--) {
            int temp=num1.charAt(i)-'0'+num2.charAt(i)-'0'+flag;
            sb.append(temp%10);
            flag=temp/10;
        }
        if(flag!=0)sb.append(flag);
        return sb.reverse().toString();
    }
    public static String format(String num,int len){
        int delta=len-num.length();
        StringBuilder sb=new StringBuilder();
        while(delta-->0){
            sb.append('0');
        }
        sb.append(num);
        return sb.toString();
    }
    //method2
    public static String addStrings1(String num1,String num2){
        if(num1==null||num1.length()==0)return num2;
        if(num2==null||num2.length()==0)return num1;
        StringBuilder sb=new StringBuilder();
        int flag=0;
        for (int i = num1.length()-1,j=num2.length()-1; i >=0||j>=0||flag>0 ; i--,j--) {
            int x=i<0?0:num1.charAt(i)-'0';
            int y=j<0?0:num2.charAt(j)-'0';
            sb.append((x+y+flag)%10);
            flag=(x+y+flag)/10;
        }
        return sb.reverse().toString();
    }
}
