package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/14.
 */
public class LC041FirstMissingPositive {
    public static int firstMissingPositive(int[] nums){
        if(nums==null||nums.length==0)return 1;
        int len=nums.length;
        //思路，利用同个一个数组，对数组进行排序，nums[0]==1,nums[1]==2,...如果存在的话，条件是这个数是>0并且小于数组长度，而且这个不等于
        //index+1，否则就和nums[nums[i]-1]进行交换，目的是将这个数放到合适的位置上去，因为交换过来的这个数还可能符合上面这个条件，需要继续
        //交换，所以用一个while-loop来做直到不符合条件，注意，loop里面还要判断一下是否会是两个个相同的数在交换，如果是则果断break，否则会
        //陷入死循环。

        //等结束了循环，重新检查一下是否index+1就等于当前的元素，不是的话就是返回index+1，这就是missing 的数，如果循环正常结束，就是说没有
        //missing任何数，那么就返回这个数组长度+1，也就是说这个数组是连续的，missing的就是这个数组元素最大值+1了。

        for (int i = 0; i < len; i++) {
            while(nums[i]>0&&nums[i]<len&&i!=nums[i]-1){
                int temp=nums[nums[i]-1];
                if(temp==nums[i])break;
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }

        for (int i = 0; i < len; i++) {
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        int[] array={1,2,3,0,-1,4};
        System.out.println(firstMissingPositive(array));
    }
}
