package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/4/24.
 */
public class LC391PerfectRectangle {
    public static void main(String[] args) {
        /*int[][] rectangels={
                {1,1,3,3},
                {3,1,4,2},
                {3, 2, 4, 4},
                {1,3,2,4},
                {2,3,3,4}
        };*/
        int[][] rectangels={
                {1,1,3,3},
                {3,1,4,2},
                {1,3,2,4},
                {2,2,4,4}
        };
        System.out.println(isRectangleCover(rectangels));
    }
    /*解题思路：
    * 核心思想就是:能够正好围成一个矩形的情况就是:
    * 有且只有:
    *   - 最左下 最左上 最右下 最右上 的四个点只出现过一次,其他肯定是成对出现的(保证完全覆盖)
    *   - 上面四个点围成的面积,正好等于所有子矩形的面积之和(保证不重复)
    * 那么我们就用一个set来保存每一个点矩形的4个点，考虑到上面说的除了最外面4个点，其他的都是成对出现，那么在
       * 保存的时候，如果set里面有，就删除，如果没有就进set，到了最后剩下的，如果是矩形，那么就只剩4个点。
       * 小技巧：
       * 为了set中的唯一性，将点坐标转成string来保存。
    * */
    public static boolean isRectangleCover(int[][] rectangles){
        if(rectangles==null||rectangles.length==0||rectangles[0]==null||rectangles[0].length==0)return false;
        int numbers=rectangles.length;

        int bottom=Integer.MAX_VALUE;
        int left=Integer.MAX_VALUE;
        int top=Integer.MIN_VALUE;
        int right=Integer.MIN_VALUE;

        int totalArea=0;
        Set<String> set=new HashSet<>();

        for (int i = 0; i < numbers; i++) {
            bottom=Math.min(bottom,rectangles[i][0]);
            left=Math.min(left,rectangles[i][1]);
            top=Math.max(top,rectangles[i][2]);
            right=Math.max(right,rectangles[i][3]);

            totalArea+=(rectangles[i][2]-rectangles[i][0])*(rectangles[i][3]-rectangles[i][1]);

            String vertex_l_b=rectangles[i][1]+" "+rectangles[i][0];
            String vertex_l_t=rectangles[i][1]+" "+rectangles[i][2];
            String vertex_r_b=rectangles[i][3]+" "+rectangles[i][0];
            String vertex_r_t=rectangles[i][3]+" "+rectangles[i][2];

            if(set.contains(vertex_l_b))set.remove(vertex_l_b);
            else set.add(vertex_l_b);

            if(set.contains(vertex_l_t))set.remove(vertex_l_t);
            else set.add(vertex_l_t);

            if(set.contains(vertex_r_b))set.remove(vertex_r_b);
            else set.add(vertex_r_b);

            if(set.contains(vertex_r_t))set.remove(vertex_r_t);
            else set.add(vertex_r_t);
        }

        int area=(top-bottom)*(right-left);

        if(totalArea==area&&set.size()==4&&set.contains(left+" "+bottom)&&set.contains(right+" "+top))return true;
        return false;
    }
}
