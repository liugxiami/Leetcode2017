package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/5/11.
 */
public class LC401BinaryWatch {
    //method 1 backtracking

    public List<String> readBinaryWatch(int num){
        List<String> result=new ArrayList<>();
        if(num<0||num>=9)return result;

        int[] hours={1,2,4,8};
        int[] minutes={1,2,4,8,16,32};
        for (int i = 0; i <= num; i++) {
            List<Integer> h=new ArrayList<>();
            List<Integer> m=new ArrayList<>();

            if(i<4&&num-i<=6){ //限制一下条件，因为小时的个数不可能超过3个（4个时大于12了），分钟的个数不能超过5个（6个时大于60了）
                //bt小时
                backtracking(h,new ArrayList<Integer>(),hours,0,0,i);
                //bt分钟，注意：小时和分钟LED灯的总个数是num
                backtracking(m,new ArrayList<Integer>(),minutes,0,0,num-i);
                for(Integer hour:h){
                    if(hour>11)continue;
                    for(Integer minute:m){
                        if(minute>60)continue;
                        result.add(hour+":"+(minute<10?"0"+minute:minute));
                    }
                }
            }
        }
        return result;
    }
    //backtracking来找组合，条件是组合元素个数是固定的，其元素之和小于12小时或60分钟。
    private void backtracking(List<Integer> bag,List<Integer> path,int[] array,int index,int curr,int number){
        if(path.size()>number)return; //个数超过目标个数或当前值大于最大值时就直接返回
        if(path.size()==number){ //如果个数是目标个数并且小于max时，做点事
            bag.add(curr);
        }else{
            for (int i = index; i < array.length; i++) {//否则就再加入下一个元素，递归来实现
                path.add(i);
                curr+=array[i];
                backtracking(bag,path,array,i+1,curr,number);
                path.remove(path.size()-1);  //递归完之后要去除最后加进去这个元素，bt典型的写法。
                curr-=array[i];
            }
        }
    }

    public static void main(String[] args) {
        LC401BinaryWatch watch=new LC401BinaryWatch();
        List<String> res=watch.readBinaryWatch(8);
        for (String time:res) {
            System.out.println(time);
        }
    }
    //method 2 bitmap,通过二进制位中1的个数来判断是否符合，超时。
    public List<String> readBinaryWatch1(int num){
        List<String> result=new ArrayList<>();
        if(num<0||num>9)return result;

        int[] bitMap=new int[60];
        for (int i = 0; i < 60; i++) {
            int curr=i;
            int count=0;
            while(curr>0){
                if((curr&1)==1)count++;
                curr>>=1;
            }
            bitMap[i]=count;
        }

        for (int hour = 0; hour < 12; hour++) {
            int currHourCount=bitMap[hour]; //0到11中每个数看一下二进制位中1的个数
            for (int minute = 0; minute < 60; minute++) {
                int currMinuteCount=bitMap[minute]; //0到60二进制中1的个数
                if(currHourCount+currMinuteCount==num){ //如果两种个数总和等于num，那么这个时间就符合题目要求的
                    result.add(hour+":"+(minute<10?"0"+minute:minute));
                }
            }
        }
        return result;
    }
}
