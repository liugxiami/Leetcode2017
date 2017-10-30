package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/10/28.
 */
public class LC118PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> res=generate1(5);
        for (int i = 0; i < res.size(); i++) {
            res.get(i).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
     }
     //method 1
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> result=new ArrayList<>();
        if(numRows<=0)return result;

        List<Integer> init=new ArrayList<>();
        init.add(1);
        result.add(init);

        for (int row = 1; row <numRows ; row++) {
            List<Integer> pre=result.get(result.size()-1);

            List<Integer> curr=new ArrayList<>();
            curr.add(1); //first element

            for (int col = 1; col < row; col++) {
                curr.add(pre.get(col-1)+pre.get(col)); //from 1 to row-1
            }

            curr.add(1); //last element

            result.add(curr);
        }
        return result;
    }
    //method 2
    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        if(numRows<1)return result;
        List<Integer> curr=new ArrayList<>();
        curr.add(1);
        result.add(new ArrayList<>(curr));

        for(int row=1;row<numRows;row++){
            for(int col=row-1;col>0;col--){
                curr.set(col,curr.get(col)+curr.get(col-1));
            }
            curr.add(1);
            result.add(new ArrayList<>(curr));
        }

        return result;
    }
}
