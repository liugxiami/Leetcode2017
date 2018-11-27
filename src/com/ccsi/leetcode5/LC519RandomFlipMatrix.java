package com.ccsi.leetcode5;

import java.util.*;

public class LC519RandomFlipMatrix {
    public static void main(String[] args) {
        LC519RandomFlipMatrix solution=new LC519RandomFlipMatrix(2,3);
        List<int[]> list=new ArrayList<>();
        list.add(solution.flip());
        list.add(solution.flip());
        list.add(solution.flip());
        list.add(solution.flip());
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).length==0)continue;
            System.out.printf("the coordinate is %d and %d",list.get(i)[0],list.get(i)[1]);
            System.out.println();
        }
        solution.reset();
    }
    //开始的时候还声明了这个matrix，以及一个list来存储flip过的坐标，其实没必要，set里面的每一个数都对应相应的坐标，相当于
    //已经记录过了。
    private Random random;
    private int len; //Multiply rows with columns. Then i is randomNumber/Columns and j is randomNumber%Columns
    private int r;
    private int c;
    private Set<Integer> set;//用set来保持已经出现过的随机数
    public LC519RandomFlipMatrix(int n_rows,int n_cols){
        r=n_rows;
        c=n_cols;
        len=n_rows*n_cols;
        random=new Random();
        set=new HashSet<>();
    }
    public int[] flip(){
        if(set.size()==len)return new int[0];
        int ran=random.nextInt(len);
        while(!set.add(ran))ran=random.nextInt(len); //但如果所有的数都出现过了，会出现死循环。
        return new int[]{ran/c,ran%c};
    }
    public void reset(){
        set.clear();
    }
}
