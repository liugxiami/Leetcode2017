package com.ccsi.leetcode5;

import java.util.*;

public class LC539MinimumTimeDifference {
    public static void main(String[] args) {
        List<String> timePoints=new ArrayList<>();
        timePoints.add("00:00");
        timePoints.add("12:51");
        timePoints.add("14:50");
        //timePoints.add("01:30");
        System.out.println(findMinDifference1(timePoints));
    }
    //method1 sorting + Math.min
    public static int findMinDifference(List<String> timePoints){
        if(timePoints==null||timePoints.size()<2)return 0;
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o1hour=Integer.valueOf(o1.substring(0,2));
                int o1mins=Integer.valueOf(o1.substring(3,5));
                int o2hour=Integer.valueOf(o2.substring(0,2));
                int o2mins=Integer.valueOf(o2.substring(3,5));
                if(o1hour<o2hour)return -1;
                else if(o1hour>o2hour)return 1;
                else{
                    if(o1mins<o2mins)return -1;
                    else if(o1mins>o2mins)return 1;
                }
                return 0;
            }
        });

        int min=Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            if(i==0)min=Math.min(min,getDifference(timePoints.get(0),timePoints.get(timePoints.size()-1)));
            else min=Math.min(min,getDifference(timePoints.get(i-1),timePoints.get(i)));
        }
        return min;
    }
    private static int getDifference(String time1,String time2){
        int time1mins=Integer.valueOf(time1.substring(0,2))*60+Integer.valueOf(time1.substring(3,5));
        int time2mins=Integer.valueOf(time2.substring(0,2))*60+Integer.valueOf(time2.substring(3,5));
        int difference=time2mins-time1mins;
        return difference>720?1440-difference:difference;
    }
    //method2 bitMap
    public static int findMinDifference1(List<String> timePoints){
        if(timePoints==null||timePoints.size()<2)return 0;
        boolean[] timeP=new boolean[24*60];
        int result=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            String[] strs=timePoints.get(i).split(":");
            int hour=Integer.parseInt(strs[0]);
            int minute=Integer.parseInt(strs[1]);
            int mins=hour*60+minute;
            if(timeP[mins])return 0; //repeat timePoints
            timeP[mins]=true;
            min=Math.min(min,mins);
            max=Math.max(max,mins);

        }
        int pre=0;
        for (int i = min; i <=max ; i++) {
            if(timeP[i]){
                if(i==min){
                    result=Math.min(result,min+24*60-max);
                }else{
                    result=Math.min(result,i-pre);
                }
                pre=i;
            }
        }
        return result;
    }
}
