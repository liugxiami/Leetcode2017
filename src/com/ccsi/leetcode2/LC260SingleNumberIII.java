package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/29.
 */
public class LC260SingleNumberIII {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,2,3};
        int[] res=singleNumber1(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    //method1,用一个set来做，如果没碰到过，就入set，如果在set里面，就出set，最后剩下的就是single nums。
    //但这个方法明显不符题目要求（constant place）
    public static int[] singleNumber(int[] nums){
        if(nums==null||nums.length==0||nums.length==1)return nums;

        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
             if(!set.contains(nums[i])){
                 set.add(nums[i]);
             }else set.remove(nums[i]);
        }

        int index=0;
        int[] result=new int[set.size()];
        Iterator<Integer> iterator=set.iterator();
        while(iterator.hasNext()){
            result[index++]=iterator.next();
        }

        return result;
    }
    //method2：类似#136 singleNumber，用bit manipulation异或
    public static int[] singleNumber1(int[] nums){
        if(nums==null||nums.length==0||nums.length==1)return nums;
        int[] result=new int[2];

        int AXORB=0;
        for(Integer num:nums){
            AXORB^=num;  //对数组中的每一个数进行异或，其结果就是 A XOR B，相同的两个数异或的结果都变成0了。
            //而两个数异或的结果在2进制上就是，相同位都为0，不同位为1.
        }
        //找出AXORB2进制上的某一个为1的位作为flag，利用这个flag将nums分成两组，一组是在这个为啥为1的所有的数，一组为在这个
        //位上为0的所有的数，那么这两个single的数必定分属于这两组，用136相同的方法，还是异或，就可以求出single number了。
        int flag=AXORB&(-AXORB); //找flag的其中一种方法就是对相反数求与，必定得到一个1位。

        for(Integer num:nums){
            if((flag&num)==0){ //迭代一遍，将这个数组分成两组
                result[0]^=num; //第一组的每个数之间异或，结果就是第一个single Number
            }else result[1]^=num; //第二组的每个数进行异或，得到第二个single number
        }
        return result;
    }
}
