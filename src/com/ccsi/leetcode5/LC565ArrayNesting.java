package com.ccsi.leetcode5;

public class LC565ArrayNesting {
    public static void main(String[] args) {
        int[] nums={5,4,0,3,1,6,2};
        System.out.println(arrayNesting(nums));
    }

    public static int arrayNesting(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int max=0; //用来记录子array最大长度
        boolean[] visited=new boolean[len]; //将访问过的标记一下
        for (int i = 0; i < len; i++) { //迭代一遍
            if(visited[i])continue; //如果访问过了就直接略过
            int j=i; //否则将其记录为第一个，并开始找子array
            int count=0; //个数初始化为0
            while(!visited[j]){
                count++; //每访问一个自增
                visited[j]=true; //并标记为已经访问过
                j=nums[j]; //按题目的条件找子array
            }
            max=Math.max(max,count); //记录最大长度值
        }
        return max;
    }
}
