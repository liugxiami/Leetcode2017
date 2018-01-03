package com.ccsi.leetcode2;

import java.util.Map;

/**
 * Created by gxliu on 2018/1/1.
 */
public class LC273IntegerToEnglishWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(50868));
    }
    static String[] lessThan20={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine",
    "Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static String[] tens={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    static String[] thousands={"","Thousand","Million","Billion","Trillion","Zillion"};
    public static String numberToWords(int num){
        if(num<0)return "";

        String result="";
        int count=0; //根据这个count来决定是thousands
        while(num>0){
           int curr=num%1000; //三位三位的来直到结束。
           String temp=helper(curr);
           if(temp!=""){
               result=helper(curr)+thousands[count]+" "+result;
           }
           count++;
           num/=1000;
        }
        return result.trim();//最后要将两侧的空格去掉。
    }
    //对应1000以下的数，用一个递归函数来做。
    private static String helper(Integer number){
        if(number==0)return ""; //如果这个数是0，直接返回一个空值
        else if(number<20)return lessThan20[number]+" "; //如果是小于20的，在map里面找到20以内的数返回string
        else if(number<100)return tens[number/10]+" "+helper(number%10); //如果是小于100的，
        //这里已经排除了20以内的，找到tens，以及末尾。
        else return lessThan20[number/100]+" Hundred "+helper(number%100); //剩下的就是小于1000
        //的数了，找到百位数，递归百位以为的。
    }
}
