package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/6.
 */
public class LC202HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(1001));
    }
    public static boolean isHappy(int n){
        if(n<1)return false;
        Set<Integer> set=new HashSet<>();
        set.add(n);
        while(true){
            int sum=0;
            while(n!=0){
                sum+=(n%10)*(n%10);
                n/=10;
            }
            if(sum==1)return true;
            if(set.contains(sum))return false;
            set.add(sum);
            n=sum;
        }
    }
}
