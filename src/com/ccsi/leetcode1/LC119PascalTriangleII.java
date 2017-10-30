package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/10/29.
 */
public class LC119PascalTriangleII {
    public static void main(String[] args) {
        List<Integer> res=getRow(3);
        res.forEach(x-> System.out.print(x+" "));
    }
    public static List<Integer> getRow(int rowIndex){
        List<Integer> result=new ArrayList<>();
        if(rowIndex<0) return result;
        result.add(1);
        for (int row = 1; row <= rowIndex; row++) {
            for (int col = row-1; col > 0; col--) {
                result.set(col,result.get(col)+result.get(col-1));
            }
            result.add(1);
        }
        return result;
    }
}
