package com.ccsi.leetcode4;

import java.util.*;

public class LC491IncreasingSubsequences {
    public static void main(String[] args) {
        int[] nums={4,6,7,7};
        List<List<Integer>> result=findSubsequences1(nums);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> temp=result.get(i);
            temp.forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
    //其实这就是一道全子序列的题，用bitmanipulation来做挺合适。
    //不能这么做，测试中如果[4,3,2,1]返回为空，而不是[,2,3,4]的全组合。
    //那么只能用BT来做了。
    public static List<List<Integer>> findSubsequences(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();//用set来排除重复

        if(nums==null||nums.length==0)return result;
        Arrays.sort(nums); //必须排序，否则不能保证升序排列
        int len=nums.length;
        //用bit manipulation来做。
        int n=(int)Math.pow(2,len);

        for (int i = 2; i <n; i++) {
            List<Integer> list=new ArrayList<>();
            int index=0;
            int temp=i;
            while(temp>0){
                if((temp&1)==1)list.add(nums[index]);
                index++;
                temp>>=1;
            }
            if(list.size()>=2)set.add(list);
        }
        result.addAll(set);
        return result;
    }

    public static List<List<Integer>> findSubsequences1(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        backTracking(nums,0,result,new ArrayList<>());
        return result;
    }
    private static void backTracking(int[] nums,int index,List<List<Integer>> result,List<Integer> list){
        if(list.size()>1)result.add(new ArrayList<>(list));
        Set<Integer> visited=new HashSet<>();//排除重复访问同一个元素
        for (int i = index; i < nums.length; i++) {
            if(!list.isEmpty()&&nums[i]<list.get(list.size()-1))continue; //保证result里面的list都是升序排列的
            if(!visited.contains(nums[i])){
                visited.add(nums[i]);
                list.add(nums[i]); //bt的典型写法
                backTracking(nums,i+1,result,list);
                list.remove(list.size()-1);
                //注意：此处不能在多此一举visited.remove（nums[i]），否则就不能起到排除重复访问同一元素的效果了。
                //替代写法是用一个Set<List<Integer>>记录result，排除重复结果。
            }
        }
    }
}
