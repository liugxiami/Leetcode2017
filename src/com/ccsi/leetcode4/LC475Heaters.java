package com.ccsi.leetcode4;

import java.util.*;

public class LC475Heaters {
    public static void main(String[] args) {
        int[] houses={1,2,3,4};
        int[] heaters={1,4};
        System.out.println(findRadius(houses,heaters));
    }
    public static int findRadius(int[] houses,int[] heaters){
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max=0;
        int index=0;
        for (int i = 0; i < houses.length; i++) {
            int currHouse=houses[i];
            while(index+1<heaters.length&&Math.abs(currHouse-heaters[index])>=Math.abs(currHouse-heaters[index+1]))index++;
            max=Math.max(max,Math.abs(currHouse-heaters[index]));
        }
        return max;
    }
}
