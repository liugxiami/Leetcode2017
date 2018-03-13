package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/3/11.
 */
public class LC335SelfCrossing {
    public static void main(String[] args) {
        int[] x={1,1,2,1,1};
        System.out.println(isSelfCrossing(x));
    }
    public static boolean isSelfCrossing(int[] x){
        if(x==null||x.length<4)return false;
        int len=x.length;

        boolean increasing=x[2]>x[0];
        for (int i = 3; i < len; i++) {
            if(!increasing&&x[i]>=x[i-2])return true;

            if(increasing&&x[i]<=x[i-2]){
                increasing=false;
                x[i-1]=(x[i]+(i>3?x[i-4]:0))<x[i-2]?x[i-1]:(x[i-1]-x[i-3]);
            }
        }
        return false;
    }
}
