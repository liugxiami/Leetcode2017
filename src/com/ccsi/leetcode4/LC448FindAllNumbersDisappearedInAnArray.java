package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/7/26.
 */
public class LC448FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> res=findDisappearedNumbers(nums);
        res.forEach(a-> System.out.println(a));
    }
    //数组内排序，nums[i]存i+1这个数。
    public static List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;
        for (int i = 0; i < nums.length; ) {
            int curr=nums[i];
            if(curr==i+1||curr==0)i++; //如果index里面存的正好是index+1或0，i++
            else{  //否则就看nums[curr-1]里面是啥，两种情况
                if(nums[curr-1]!=curr){ //一种是正好curr-1里面不是curr，说明还没排好序，那么交换
                    int temp=nums[curr-1];
                    nums[curr-1]=curr;
                    nums[i]=temp;
                }else nums[i++]=0;//第二种情况是curr-1里面是curr，说明是排好序的了，那么i++
            }
        }
        for (int i = 0; i < nums.length; i++) { //完了之后在迭代一遍，看哪些位上是0，那么这个位上的就是missing的数。
            if(nums[i]==0)result.add(i+1);
        }
        return result;
    }
}
