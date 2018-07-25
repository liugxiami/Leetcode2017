package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/7/19.
 */
public class LC446ArithmeticSliceIISubsequence {
    public static void main(String[] args) {
        int[] A={2,2,3,4};
        System.out.println(numberOfArithmeticSlices(A));
    }
    //DP题，但这个DP有点特殊，用HashMap来当元素，其中key为A[i]-A[j]的差值，value为出现这个差值的次数。
    /*
     2     4     6     8     10
           2->1  4->1  6->1  8->1
                 2->2  4->1  6->1
                       2->3  4->2
                             2->4
     */
    public static int numberOfArithmeticSlices(int[] A){
        if(A==null||A.length<3)return 0;
        int result=0;
        List<HashMap<Long,Integer>> dp=new ArrayList<>(); //本想用array，但声明不成功，只能用list，其index
        //为0到n（A数组的大小），这个list当array用。
        for (int i = 0; i < A.length; i++) {
            HashMap<Long,Integer> diffMap=new HashMap<>(); //没往后看一个，要初始化一下dp里面的HashMap
            dp.add(i,diffMap);//并将其放入dp中
            for (int j = 0; j < i; j++) { //迭代0到i-1的元素，并计算差值
                long diff=(long)A[i]-A[j]; // 需要用long类型来表示差值，否则有可能越界
                if(diff<Integer.MIN_VALUE||diff>Integer.MAX_VALUE)continue;
                //先判断一下，如果出现整形极值之外的差值，那么就不可能出现arithmethics。
                int count=(dp.get(i).containsKey(diff))?(dp.get(i).get(diff)):0; //先看看当前i位上有无key 为diff，有的话取出

                if(dp.get(j).containsKey(diff)){ //如果dp[j]中包含这个差值，可以组成Arithmetics，
                    result+=dp.get(j).get(diff);//不太理解的在这，如果前面出现过，那么将次数累加到result中去。
                    dp.get(i).put(diff,dp.get(j).get(diff)+count+1);//那么出现次数++，并加上本有的次数
                }else {
                    dp.get(i).put(diff,count+1);
                }
            }

        }
        return result;
    }
}
