package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/5/11.
 */
public class LC401BinaryWatch {
    private int[] hours={1,2,4,8};
    private int[] minutes={1,2,4,8,16,32};
    public List<String> readBinaryWatch(int num){
        List<String> result=new ArrayList<>();
        if(num<0||num>=9)return result;
        List<Integer> h=new ArrayList<>();
        List<Integer> m=new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            if(i<4&&num-i<=6){ //限制一下条件，因为小时的个数不可能超过3个（4个时大于12了），分钟的个数不能超过5个（6个时大于60了）
                //bt小时
                backtracking(h,new ArrayList<Integer>(),hours,0,0,i,12);
                //bt分钟，注意：小时和分钟LED灯的总个数是num
                backtracking(m,new ArrayList<Integer>(),minutes,0,0,num-i,60);
                if(i!=0&&h.isEmpty())continue;
                if(num-i!=0&&m.isEmpty())continue;//有可能出现纯进去num-i个数（非0），但返回空的情况

                if(h.isEmpty()&&m.isEmpty()){
                    result.add("0:00");
                }else if(h.isEmpty()){
                    for(Integer mins:m){
                        result.add(0+":"+(mins<10?"0"+mins:mins));
                    }
                }else if(m.isEmpty()){
                    for(Integer hr:h){
                        result.add(hr+":"+"00");
                    }
                }else{
                    for(Integer hr:h){
                        for(Integer mins:m){
                            result.add(hr+":"+(mins<10?"0"+mins:mins));
                        }
                    }
                }
                h.clear();
                m.clear();
            }
        }
        return result;
    }
    //backtracking来找组合，条件是组合元素个数是固定的，其元素之和小于12小时或60分钟。
    private void backtracking(List<Integer> bag,List<Integer> path,int[] array,int index,int curr,int number,int max){
        if(path.size()>number||curr>=max)return; //个数超过目标个数或当前值大于最大值时就直接返回
        if(path.size()==number){ //如果个数是目标个数并且小于max时，做点事
            bag.add(curr);
        }else{
            for (int i = index; i < array.length; i++) {//否则就再加入下一个元素，递归来实现
                path.add(i);
                curr+=array[i];
                backtracking(bag,path,array,i+1,curr,number,max);
                path.remove(path.size()-1);  //递归完之后要去除最后加进去这个元素，bt典型的写法。
                curr-=array[i];
            }
        }
    }

    public static void main(String[] args) {
        LC401BinaryWatch watch=new LC401BinaryWatch();
        List<String> res=watch.readBinaryWatch(2);
        for (String time:res) {
            System.out.println(time);
        }
    }
}
