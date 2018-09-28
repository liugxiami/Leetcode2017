package com.ccsi.leetcode4;

import java.util.Random;

public class LC478GenerateRandomPointInACircle {
    private double radius;
    private double x_center;
    private double y_center;
    Random rand;
    public LC478GenerateRandomPointInACircle(double radius,double x_center,double y_center){
        this.radius=radius;
        this.x_center=x_center;
        this.y_center=y_center;
        this.rand=new Random();
    }
    public double[] randPoint(){
        double[] result=new double[2];
        double len=Math.sqrt(rand.nextDouble())*radius;
        double deg=rand.nextDouble()*2*Math.PI;
        result[0]=len*Math.sin(deg)+x_center;
        result[1]=len*Math.cos(deg)+y_center;
        return result;
    }

    public static void main(String[] args) {
        LC478GenerateRandomPointInACircle gen=new LC478GenerateRandomPointInACircle(10,5,-7.5);
        for (int i = 0; i < 10; i++) {
            double[] res=gen.randPoint();
            System.out.println("randPoint:"+res[0]+" and "+res[1]);
        }

    }
}
