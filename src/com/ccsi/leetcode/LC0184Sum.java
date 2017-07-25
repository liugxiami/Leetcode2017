package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/7/24.
 */
public class LC0184Sum {
    public static void main(String[] args) {
        int[] nums={1,0,-1,0,-2,2};
        List<List<Integer>> result=fourSum(nums,0);
        for (int i = 0; i < result.size(); i++) {
            result.get(i).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }

    public static List<List<Integer>> fourSum(int[] nums,int target){
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null||nums.length<4)return result;
        int len=nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            while(i!=0&&i<len-3&&nums[i]==nums[i-1])i++;
            for (int j = i+1; j < len-2; j++) {
                while(j!=i+1&&j<len-2&&nums[j]==nums[j-1])j++;
                int left=j+1;
                int right=len-1;
                twoSum(nums,nums[i],nums[j],left,right,target,result);
            }
        }
        return result;
    }
    private static void twoSum(int[] nums,int num1,int num2,int left,int right,int target,List<List<Integer>> result){
        while(left<right){
            int sum=num1+num2+nums[left]+nums[right];
            if(sum==target){
                List<Integer> curr=new ArrayList<>();
                curr.add(num1);
                curr.add(num2);
                curr.add(nums[left]);
                curr.add(nums[right]);
                result.add(curr);
                left++;
                right--;

                while(left<right&&nums[left]==nums[left-1])left++;
                while(left<right&&nums[right]==nums[right+1])right--;
            }else if(target>sum)left++;
            else right--;
        }
    }
}
