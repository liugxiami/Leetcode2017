package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/9/27.
 */
public class LC054SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},
                {4,5,6},
                {7,8,9}};
        List<Integer> res=spiralOrder(matrix);
        res.forEach(x-> System.out.print(x+" "));
    }
    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> result=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)return result;
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        while(true){
            for (int i = left; i <=right; i++) {
                result.add(matrix[top][i]);
            }
            if(++top>bottom)break;
            for (int i = top; i <=bottom; i++) {
                result.add(matrix[i][right]);
            }
            if(--right<left)break;
            for (int i = right; i >=left ; i--) {
                result.add(matrix[bottom][i]);
            }
            if(--bottom<top)break;
            for (int i = bottom; i >=top ; i--) {
                result.add(matrix[i][left]);
            }
            if(++left>right)break;
        }
        return result;
    }
}
