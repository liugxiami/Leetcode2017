package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/16.
 * DP解题
 * 其实就是爬楼梯的变种，就是在前一位是1或前一位是2并且当前小于等于6时(也就是大于等于10小于等于26)，相
 * 当于fibonacci数列的递推方程式，f(i+1)=f(i)+f(i-1);
 * 当前位为1到9的话就是f(i+1)=f(i)
 */
public class LC091DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("103"));
    }
    public static int numDecodings(String s){
        if(s==null||s.length()==0)return 0;
        int len=s.length();
        //声明一个缓存数组
        int[] cache=new int[len+1]; //cache的index==字符串index+1
        //初始化，注意如果第一位是个0，没法解码，就是0.
        cache[0]=1;
        cache[1]=s.charAt(0)=='0'?0:1;//检测头字母是否为0
        //从s的index==1开始循环
        for (int i = 1; i < len; i++) {
            int oneDigit=s.charAt(i)-'0'; //当前位是1到9的话
            int twoDigits=(s.charAt(i-1)-'0')*10+s.charAt(i)-'0';//当前位很前一位合起来是10到26的话

            if(oneDigit>=1&&oneDigit<=9){
                cache[i+1]=cache[i];
            }

            if(twoDigits>=10&&twoDigits<=26){
                cache[i+1]+=cache[i-1];
            }
        }

        return cache[len];
    }
}
