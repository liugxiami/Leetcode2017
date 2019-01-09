package com.ccsi.leetcode5;

import java.util.*;

public class LC554BrickWall {
    public static void main(String[] args) {
        List<List<Integer>> wall=new ArrayList<>();
        Integer[] r1={1,2,2,1};
        List<Integer> w1=Arrays.asList(r1);
        wall.add(w1);
        Integer[] r2={3,1,2};
        List<Integer> w2=Arrays.asList(r2);
        wall.add(w2);
        Integer[] r3={1,3,2};
        List<Integer> w3=Arrays.asList(r3);
        wall.add(w3);
        Integer[] r4={2,4};
        List<Integer> w4=Arrays.asList(r4);
        wall.add(w4);
        Integer[] r5={3,1,2};
        List<Integer> w5=Arrays.asList(r5);
        wall.add(w5);
        Integer[] r6={1,3,1,1};
        List<Integer> w6=Arrays.asList(r6);
        wall.add(w6);
        System.out.println(leastBricks(wall));
    }
    //题目是要从上往下画一条线，这条线要经过的最少砖块数，看例题的意思是：可以通过砖与砖之间的缝隙，除了两侧（因为左右两侧的话，明显就不用过砖了），
    //那么我们就换一下思路，看看这条线最多过几个缝隙，如果缝隙过的越多，那么画过砖的砖数就必定越少。
    //因此要做的就非常简单了，将每一行的砖的缝隙的位置找出来，位置其实就是对砖宽带的累加。
    //我们再用一个hashmap来存储缝隙位置（key）及其出现的次数（value）。本来想用数组来做更简单，但考虑到最长可能位10，000，这个数组就有点太长了。
    //最好迭代map，找到最多的gap次数，用总曾是减去gap就是crossed bricks数了。
    //下面的code做了稍微改进，最后的map迭代其实在上面的循环就可以同时做了。
    public static int leastBricks(List<List<Integer>> wall){
        if(wall==null||wall.size()==0)return 0;
        int height=wall.size();
        int length=0;
        for(int b:wall.get(0))length+=b;
        Map<Integer,Integer> map=new HashMap<>();
        int gaps=0;
        for (int i = 0; i < height; i++) {
            List<Integer> curr=wall.get(i);
            int gapLocation=0;
            for(int j=0;j<curr.size()-1;j++){ //最后一块砖不加，那么最右边的edge就不会算在里面了。
                gapLocation+=curr.get(j);
                map.put(gapLocation,map.getOrDefault(gapLocation,0)+1);
                gaps=Math.max(gaps,map.get(gapLocation));
            }
        }
        return height-gaps;
    }
}
