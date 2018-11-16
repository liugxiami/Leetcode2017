package com.ccsi.leetcode5;

import java.util.ArrayList;
import java.util.List;

public class LC507PerfectNumber {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            if(checkPerfectNumber1(i))list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static boolean checkPerfectNumber(int num){
        if(num<=1)return false;
        int sum=1;
        for (int i = 2; i <= num/2; i++) {
            if(num%i==0)sum+=i;
        }
        return sum==num;
    }
    public static boolean checkPerfectNumber1(int num){
        if(num<=1)return false;
        int sum=1;
        for (int i = 2; i*i <=num; i++) { //是从2到math.sqrt（x），比从2到x/2快多了。
            if(num%i==0)sum+=(i+num/i); //将相乘等于num的两个数同时都加上
            if(i*i==num)sum-=i; //如果num可以等于一个数的平方，也就是上面的i==num/i，相当于将i加了2次，要减掉一个i。
        }
        return sum==num;
    }
}
