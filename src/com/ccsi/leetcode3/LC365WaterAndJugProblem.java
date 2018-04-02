package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/4/1.
 */
public class LC365WaterAndJugProblem {
    public static void main(String[] args) {
        System.out.println(canMeasureWater1(3,5,11));
    }
    //自己最开始写的。思路就是用z不停的去量x或y，量完就到掉，一直到z==0或者z在x和y之间，这时再判断，如果
    //只是相差1的话是可以量出来的，否则不行。写法就是DFS。
    public static boolean canMeasureWater(int x,int y,int z){
        if(z==0)return true;
        if(z>x&&z<y){
            if(x+2==y)return true;
            else return false;
        }

        if(z>y&&z<x){
            if(y+2==x)return true;
            else return false;
        }

        boolean canMeas=false;
        if(z>=x)canMeas|=canMeasureWater(x,y,z-x);
        if(z>=y)canMeas|= canMeasureWater(x,y,z-y);
        return canMeas;
    }
    //看了别人的解法，基本就是找最大公约数，看z是否可以被x，y的最大公约数整除，如果可以return true。
    //题目还有个要求：如果可以量出z升水，你最终需要将这些水装在其中的一个或者两个罐子中。也就是说x+y>=z.
    public static boolean canMeasureWater1(int x,int y,int z){
        return z==0||x+y>=z&&z%gcd(x,y)==0;
    }
    private static int gcd(int x,int y){
        return (y==0)?x:gcd(y,x%y);
    }
}
