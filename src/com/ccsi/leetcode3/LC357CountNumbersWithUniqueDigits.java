package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/3/25.
 */
public class LC357CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits1(2));
    }
    //method1 brute-force,下面方法只适用i小于Integer.MAX_VALUE的情况。
    public static int countNumbersWithUniqueDigits(int n){
        if(n<0)return 0;
        int count=0;
        for (int i = 0; i < Math.pow(10,n); i++) {
            if(isUnique(i))count++;
        }
        return count;
    }
    private static boolean isUnique(int n){
        int[] digits=new int[10];
        while(n>0){
            digits[n%10]++;
            if(digits[n%10]>1)return false;
            n/=10;
        }
        return true;
    }
    //method2 bt+visited
    private static int count=0;
    public static int countNumbersWithUniqueDigits1(int n){
        if(n<0)return 0;
        if(n==0)return 1;
        int[] bitMap={0,1,2,3,4,5,6,7,8,9};
        boolean[] used=new boolean[10]; //应用一个used可以提速很多。
        helper(new StringBuilder(),bitMap,used,n);
        return count;
    }
    private static void helper(StringBuilder sb,int[] bitMap,boolean[] used,int n){
        if(sb.length()>n)return;
        else{
            if(isUnique(sb.toString()))count++;
            for (int i = 0; i < 10; i++) {
                if(!used[i]){
                    sb.append(bitMap[i]);
                    used[i]=true;
                    helper(sb,bitMap,used,n);
                    sb.deleteCharAt(sb.length()-1);
                    used[i]=false;
                }
            }
        }
    }
    private static boolean isUnique(String str){
        if(str==null||str.length()==0)return false;
        char[] chars=str.toCharArray();
        int[] digits=new int[10];
        for (int i = 0; i < chars.length; i++) {
            if(chars[0]=='0'&&chars.length>1)return false;//如果字符数大于1，那么头字符不能为0
            digits[chars[i]-'0']++;
            if(digits[chars[i]-'0']>1)return false;
        }
        return true;
    }
}
