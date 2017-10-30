package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/10/29.
 */
public class LC120Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle=new ArrayList<>();

        List<Integer> first=new ArrayList<>(Arrays.asList(2));
        List<Integer> second=new ArrayList<>(Arrays.asList(3,4));
        List<Integer> third=new ArrayList<>(Arrays.asList(6,5,7));
        List<Integer> forth=new ArrayList<>(Arrays.asList(4,1,8,3));
        triangle.add(first);
        triangle.add(second);
        triangle.add(third);
        triangle.add(forth);

        System.out.println(minimumTotal(triangle));
    }
    public static int minimumTotal(List<List<Integer>> triangle){
        if(triangle==null||triangle.size()==0)return 0;
        for (int row = triangle.size()-2; row >=0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                triangle.get(row).set(col,Math.min(triangle.get(row).get(col)+triangle.get(row+1).get(col),
                        triangle.get(row).get(col)+triangle.get(row+1).get(col+1)));
            }
        }

        return triangle.get(0).get(0);
    }
}
