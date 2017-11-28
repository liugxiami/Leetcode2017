package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/27.
 */
public class LC165CompareVersionNumbers {
    public static void main(String[] args) {
        String v1="12.305";
        String v2="12.305.8";
        System.out.println(compareVersion1(v1,v2));
    }
    //method1,这题最简单的做法就是用split函数，然后将每一个string数组里面的string parseInt，比较大小一直到比较出
    //大小或到结尾。
    //method2，不借用现成的函数，直接用循环，从头到尾一一看，如果碰到'.'或==len就开始比较，一直到结束。
    public static int compareVersion(String version1,String version2){
        if(version1.equals(version2))return 0;

        int len1=version1.length();
        int len2=version2.length();
        int index1=0;
        int index2=0;
        while(index1!=len1||index2!=len2){  //这个循环结束的条件，假假为假，循环中断，否则都是继续。
            int num1=0;
            while(index1!=len1&&version1.charAt(index1)!='.'){
                num1=num1*10+version1.charAt(index1++)-'0';
            }

            int num2=0;
            while(index2!=len2&&version2.charAt(index2)!='.'){
                num2=num2*10+version2.charAt(index2++)-'0';
            }

            if(num1>num2)return 1;
            else if(num1<num2)return -1;
            else{
                if(index1!=len1)index1++;   //这里需要注意，容易漏掉判断。
                if(index2!=len2)index2++;
            }
        }
        return 0;
    }
    //method3 divide&conquer recursion,用了substring和parseInt，速度应该比上一个慢。
    public static int compareVersion1(String version1,String version2){
        if(version1.equals(version2))return 0;

        int len1=version1.length();
        int len2=version2.length();

        int index1=0;
        int index2=0;

        while(index1!=len1&&version1.charAt(index1)!='.')index1++;
        while(index2!=len2&&version2.charAt(index2)!='.')index2++;

        int num1=index1==0?0:Integer.parseInt(version1.substring(0,index1));
        int num2=index2==0?0:Integer.parseInt(version2.substring(0,index2));

        if(num1>num2)return 1;
        else if(num1<num2)return -1;
        else{
            if(index1!=len1)index1++;
            if(index2!=len2)index2++;
            return compareVersion1(version1.substring(index1),version2.substring(index2));
        }
    }
}
