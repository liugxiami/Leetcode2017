package com.ccsi.leetcode4;

public class LC468ValidateIPAddress {
    public static void main(String[] args) {
        String IP="2001:0db8:85a3::0:8A2E:0370:7334";
        System.out.println(validIPAddress(IP));
    }
    //先判断字符串大小，最小的ipv4也有7位（4个数+3个点），最大的ipv6是39位（32个数+7个冒号）。然后根据字符串中是含'.'
    //还是':'来判断ipv4还是ipv6，还是都不是。因此需要两个函数来判断。
    public static String validIPAddress(String IP){
        if(IP==null||IP.length()<7||IP.length()>39)return "Neither";
        for (int i = 0; i < IP.length(); i++) {
            if(IP.charAt(i)=='.')return isIPv4(IP)?"IPv4":"Neither";
            if(IP.charAt(i)==':')return isIPv6(IP)?"IPv6":"Neither";
        }
        return "Neither";
    }
    //第一个函数判断ipv4
    private static boolean isIPv4(String IP){
        int start=0; //记录每部分数字在字符串中的起始位置
        int sum=0;   //数字的大小（0到255）
        int count=0; //有几个数字（ipv4是4个数字）
        for (int i = 0; i <= IP.length(); i++) {
            //当碰到'.'或者结束时，要对数字进行判断，需要注意字符串结束的情况
            if(i==IP.length()||IP.charAt(i)=='.'){
                if(sum>255)return false; //首先，这个数字肯定是小于256的。
                if(i-start>1&&IP.charAt(start)=='0'||start-i==0)return false; //如果这个数包括两位数以上，那么开头不能为0,并且不能为空.
                start=i+1; //更新新一个数字的开头位置
                count++; //找到了一个符合条件的数字
                sum=0;   //新数字更新为0
                if(count==4)return i==IP.length(); //如果已经4个了，那看看是否迭代到字符串结尾了
            }else{
                if(IP.charAt(i)<'0'||IP.charAt(i)>'9')return false; //不是'.'的话，那么看是否是0到9的数
                sum=sum*10+IP.charAt(i)-'0'; //是数字的话就开始累加这个数
            }
        }
        return false;
    }
    //第二个函数判断ipv6
    private static boolean isIPv6(String IP){
        int digitCount=0; //当前这个数的位数
        int count=0; //找到了几个数（共8个）
        for (int i = 0; i <= IP.length(); i++) {
            //碰到了‘:’或结尾
            if(i==IP.length()||IP.charAt(i)==':'){
                if(digitCount>4||digitCount==0)return false; //位数大于4或为0
                count++; //找到了一个数
                digitCount=0; //新数的开始是空的
                if(count==8)return i==IP.length();
            }else if((IP.charAt(i)>='0'&&IP.charAt(i)<='9')||(IP.charAt(i)>='a'&&IP.charAt(i)<='f')
                    ||(IP.charAt(i)>='A'&&IP.charAt(i)<='F')){ //0到9，a到f，A到F的字符才满足条件
                digitCount++;
            }else return false; //如果碰上其他字符，返回false
        }
        return false;
    }
}
