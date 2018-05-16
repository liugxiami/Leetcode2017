package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/5/14.
 * example:[0,1,2,3,4,5,6,12]
 * last step:1->2->3
 * next step:[1,2]->[1,3]->[2,4]
 */
public class LC403FrogJump {
    public static void main(String[] args) {
        int[] stones={0,1,3,5,6,8,12,17};
        System.out.println(canCross1(stones));
    }
    //HashMap
    public static boolean canCross1(int[] stone){
        if(stone==null||stone.length==0)return true;
        Map<Integer,Set<Integer>> map=new HashMap<>(); //key：stone[i]，value：上次跳到当前stone的步数
        int len=stone.length;
        for (int i = 0; i < len; i++) {
            map.put(stone[i],new HashSet<>()); //初始化这个map
        }
        map.get(stone[0]).add(0); //一开始石头0，跳0步

        for (int i = 0; i < len; i++) { //从第一个石头开始迭代
            Set<Integer> lastSteps=map.get(stone[i]); //先取出前面跳到当前石头的步数
            for (Integer lastStep:lastSteps) { //对每一种情况进行分别迭代
                for (int nextStep = lastStep-1; nextStep <=lastStep+1; nextStep++) { //接下来跳的步数
                    int nextStone=stone[i]+nextStep; //下一个可能的石头
                    if(nextStep>0&&map.containsKey(nextStone)){ //因为是往后跳，所以先判断大于0；下一个石头存在不存在
                        map.get(nextStone).add(nextStep); //存在的化，就在下个石头上记录到这个石头的步数
                    }
                }
            }
        }
        return !map.get(stone[len-1]).isEmpty(); //返回最后一个石头是否有跳到的情况
    }
    //backtrack,Limit time exceeded.
    public static boolean canCross(int[] stone){
        if(stone==null||stone.length==0)return true;
        if(stone[0]!=0||stone[1]!=1)return false;
        return backTracking(stone,0,1,0);
        //return helper(stone,0,0);
    }
    private static boolean backTracking(int[] stone,int preIndex,int currIndex,int k){
        if(currIndex>=stone.length)return false;

        int steps=stone[currIndex]-stone[preIndex];
        boolean canCross=false;
        if((steps>=k-1)&&(steps<=k+1)){
            if(currIndex==stone.length-1)return true;
            for (int i = currIndex+1; i <stone.length; i++) {
                canCross|=backTracking(stone,currIndex,i,steps);
                if(canCross)break;
            }
        }
        return canCross;
    }
    //recursion, time limit exceeded
    public static boolean helper(int[] stone,int index,int k){
        if(index==stone.length-1)return true;//目前已经达到了

        boolean canCross=false;
        for (int i = k-1; i <= k+1; i++) { //选择k的步伐，范围k-1到k+1
            int nextJump=i+stone[index];
            //看接下来有没有合适的石头可以跳过去，从接下来的位置中查找有没有nextJump的位置，有的话返回石头的编号
            int nextIndex= Arrays.binarySearch(stone,index+1,stone.length,nextJump);
            if(nextIndex>0){
                canCross|=helper(stone,nextIndex,i);
            }
        }
        return canCross;
    }
}
