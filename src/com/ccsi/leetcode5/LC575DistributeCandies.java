package com.ccsi.leetcode5;

import java.util.*;

public class LC575DistributeCandies {
    public static void main(String[] args) {
        int[] candies={1,1,2,2,2,3,3,3};
        System.out.println(distributeCandies(candies));
    }
    public static int distributeCandies(int[] candies){
        int len=candies.length;
        Set<Integer> kinds=new HashSet<>();
        for(Integer candy:candies){
            kinds.add(candy);
        }
        int candyKinds=kinds.size();
        return candyKinds<=len/2?candyKinds:len/2;
    }
}
