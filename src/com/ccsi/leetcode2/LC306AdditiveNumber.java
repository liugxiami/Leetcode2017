package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2018/1/17.
 */
public class LC306AdditiveNumber {
    public static void main(String[] args) {
        String num="112";
        System.out.println(isAdditiveNumber(num));
    }
    public static boolean isAdditiveNumber(String num){
        if(num==null||num.length()<3)return false;
        for (int i = 1; i <= num.length()/2; i++) {
            for (int j = i+1; j < num.length(); j++) {
                String pre1=num.substring(0,i);
                String pre2=num.substring(i,j);
                String next=num.substring(j);
                if(isAdditiveNumber(pre1,pre2,next))return true;
            }
        }
        return false;
    }
    private static boolean isAdditiveNumber(String pre1,String pre2,String next){
        if(next.length()==0)return true;

        if(pre1.length()>1&&pre1.charAt(0)=='0'||pre2.length()>1&&pre2.charAt(0)=='0')return false;

        String sum=getSum(pre1,pre2);
        if(next.length()<sum.length()||!sum.equals(next.substring(0,sum.length())))return false;
        else{
            return isAdditiveNumber(pre2,sum,next.substring(sum.length()));
        }
    }
    private static String getSum(String pre1,String pre2){
        int len=Math.max(pre1.length(),pre2.length());
        pre1=formatStr(pre1,len);
        pre2=formatStr(pre2,len);
        int carry=0;
        StringBuilder result=new StringBuilder();

        for (int i = len-1; i >=0 ; i--) {
            int curr=pre1.charAt(i)-'0'+pre2.charAt(i)-'0'+carry;
            result.append(curr%10);
            carry=curr/10;
        }
        if(carry==1)result.append(carry);
        return result.reverse().toString();
    }
    private static String formatStr(String str,int len){
        StringBuilder sb=new StringBuilder();
        int delta=len-str.length();
        while(delta-->0){
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }
}
