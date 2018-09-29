package com.ccsi.leetcode4;

public class LC479LargestPalindromeProduct {
    public static void main(String[] args) {
        System.out.println(largestPalindrome(4));
    }
    public static int largestPalindrome(int n){
        if(n==1)return 9;
        long upperBound= (long)Math.pow(10,n)-1; //最大的n位数的数值
        long lowerBound= upperBound/10+1; //最小的n位数
        long half=upperBound*upperBound/(long)Math.pow(10,n); //利用最大的n位数找到可能组成回文数的前一半。

        boolean foundPalindrome=false;
        long palindrome=0;
        while(!foundPalindrome){
            //回文数从大到小试，先生产可能的回文数
            palindrome=Long.valueOf(half+new StringBuilder().append(half).reverse().toString());
            for (long i = upperBound; i >=lowerBound ; i--) { //在upper和lower之间试，找能被整除的回文数
                if(i*i<palindrome)continue; //加快寻找
                if(palindrome%i==0){  //如果能被当前的i整除，那么说就是找到了
                    foundPalindrome=true;
                    break;
                }
            }
            half--;  //否则的话，将half减1，继续生成新的可能的回文数进行检测。
        }
        return (int)palindrome%1337; //一旦找到了，就对1337取模。
    }
}
