package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/5.
 */
public class LC128LongestConsecutiveSequeue {
    public static void main(String[] args) {
        //int[] nums={1,2,0,1};
        int[] nums={100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
    //method 1:union-find,如果两个数的差的绝对值等于1就union
    private static Map<Integer,UFElement> UFElements=new HashMap<>();

    public static int longestConsecutive(int[] nums){
        if(nums==null||nums.length==0)return 0;
        makeSet(nums);
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int curr=nums[i];
            if(set.contains(curr+1))union(curr,curr+1);
            if(set.contains(curr-1))union(curr,curr-1);
        }

        Map<Integer,List<Integer>> res=getSet();

        int maxLen=Integer.MIN_VALUE;
        for(Integer num:res.keySet()){
            if(res.get(num).size()>maxLen){
                maxLen=res.get(num).size();
            }
        }
        return maxLen;
    }
    private static Map<Integer, List<Integer>> getSet(){
        Map<Integer, List<Integer>> res=new HashMap<>();
        for(Map.Entry<Integer,UFElement> entry: UFElements.entrySet()){
            int parent=find(entry.getValue().val);
            if(res.containsKey(parent)){
                res.get(parent).add(entry.getValue().val);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(entry.getValue().val);
                res.put(parent,list);
            }
        }
        return res;
    }
    private static void makeSet(int[] nums){
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            UFElements.put(nums[i],new UFElement(nums[i],nums[i]));
        }
    }
    private static void union(Integer num1,Integer num2){
        int parent1=find(num1);
        int parent2=find(num2);
        if(Math.abs(num1-num2)==1){ //外面已经做了判断，其实这样判断是多余的了。
            UFElement p1=UFElements.get(parent1);
            UFElement p2=UFElements.get(parent2);
            if(p1.height<p2.height){
                p1.parent=parent2;
            }else if(p1.height>p2.height){
                p2.parent=parent1;
            }else{
                p1.parent=parent2;
                p2.height++;
            }
        }
    }
    private static Integer find(Integer num){
        UFElement curr= UFElements.get(num);
        while(true){
            int parent=curr.parent;
            if(parent==curr.val)return curr.val;
            curr= UFElements.get(parent);
        }
    }
    private static class UFElement{
        int val;
        int parent;
        int height;

        public UFElement(int val, int parent) {
            this.val = val;
            this.parent = parent;
            this.height=0;
        }
    }
    //method2 利用一个set来做
    public static int longestConsecutive1(int[] nums){
        if(nums==null||nums.length==0)return 0;
        Set<Integer> set=new HashSet<>();
        for(Integer num:nums){
            set.add(num);
        }

        int longest=0;
        for (int i = 0; i < nums.length; i++) {
            int curr=nums[i];
            set.remove(curr);

            int pre=curr-1;
            int last=curr+1;
            while(set.contains(pre)){
                set.remove(pre);
                pre--;
            }
            while(set.contains(last)){
                set.remove(last);
                last++;
            }
            longest=Math.max(longest,last-pre-1);
        }
        return longest;
    }
}
