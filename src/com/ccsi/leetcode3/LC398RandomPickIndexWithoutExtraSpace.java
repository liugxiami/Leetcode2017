package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/5/7.
 */
public class LC398RandomPickIndexWithoutExtraSpace {
    public static void main(String[] args) {
        int[] nums={1,2,3,3,3};
        LC398RandomPickIndexWithoutExtraSpace resultion=new LC398RandomPickIndexWithoutExtraSpace(nums);
        System.out.println(resultion.pick(3));
    }
    private int[] numbers;
    private Random ran;
    public LC398RandomPickIndexWithoutExtraSpace(int[] nums){
        numbers=nums;
        ran=new Random();
    }
    //水池抽样,求random的一个经典算法，一点要理解。
    public int pick(int target){
        int result=-1;
        int count=0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]!=target)continue;
            //每次碰到等于target这个数之后，做一次随机取0（在0到count之间随机取，必定包含了0这个）
            if(ran.nextInt(++count)==0){ //== 0是随机取0，nextInt至少包含0这个数，所以取0算概率。
                result=i;
            }
        }
        return result;
    }
}
