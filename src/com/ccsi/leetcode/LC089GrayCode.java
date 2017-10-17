package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/15.
 */
public class LC089GrayCode {
    public static void main(String[] args) {
        List<Integer> res=grayCode(4);
        res.forEach(x-> System.out.println(x));
    }
    //关键：找规律
    //一位就是简单的：0,1
    //两位是：00,01,11,10
    //三位是：000,001,011,010,110,111,101,100
    //我们把一位的两个数，前面加上0，就是二位的头两个数，前面加上1再反序，就是二位的后两个数。
    //把二位的前面加上0，就是三位的头四个数，把二位的前面加上1再反过来，就是三位的后四个数。
    public static List<Integer> grayCode(int n){
        List<Integer> result=new ArrayList<>();
        if(n<0)return result;
        if(n==0){
            result.add(0);
            return result;
        }
        result.add(0);
        result.add(1);
        if(n==1)return result;

        for (int i = 1; i < n; i++) {
            List<Integer> rightHalf=new ArrayList<>();
            for (int j = result.size()-1; j >=0 ; j--) {
                int temp=result.get(j);
                int p=1<<i;
                rightHalf.add(temp+p);
            }
            result.addAll(rightHalf);
        }
        return result;
    }
}
