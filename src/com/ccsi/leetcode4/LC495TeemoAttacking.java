package com.ccsi.leetcode4;

public class LC495TeemoAttacking {
    public static void main(String[] args) {
        int[] timeSeries={0,4,6};
        System.out.println(findPoisonedDuration1(timeSeries,3));
    }
    //method1 two pointers
    public static int findPoisonedDuration(int[] timeSeries,int duration){
        if(timeSeries==null||timeSeries.length==0||duration==0)return 0;
        int sum=0;
        int start=0;
        int end=0;
        for(int i=0;i<timeSeries.length;i++){
            int time=timeSeries[i];
            if(i==0){
                start=time;
                end=time+duration-1;
            }else if(time<=end){
                end=time+duration-1;
            }else{
                sum+=end-start+1;
                start=time;
                end=time+duration-1;
            }

            if(i==timeSeries.length-1){
                sum+=end-start+1;
            }
        }
        return sum;
    }
    //method2 greedy
    public static int findPoisonedDuration1(int[] timeSeries,int duration){
        if(timeSeries==null||timeSeries.length==0||duration==0)return 0;
        int sum=0;
        for (int i = 1; i < timeSeries.length; i++) {
            int diff=timeSeries[i]-timeSeries[i-1]; //后一个时间点与前一个时间点的差
            sum+=Math.min(diff,duration); //攻击总时间加上diff与duration小的那个。
        }
        return sum+duration; //到最后一个时间点的时候，其最长就是duration，要加到sum里面去
    }
}
