package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/19.
 */
public class LC149MaxPointsOnaLine {
    public static void main(String[] args) {
        Point[] points=new Point[3];
        points[0]=new Point(4,0);
        points[1]=new Point(4,-1);
        points[2]=new Point(4,5);
//        points[3]=new Point(4,4);
//        points[4]=new Point(1,3);
//        points[5]=new Point(3,1);
//        points[6]=new Point(3,2);
        //[[0,0],[94911151,94911150],[94911152,94911151]]
//        points[0]=new Point(0,0);
//        points[1]=new Point(94911151,94911150);
//        points[2]=new Point(94911152,94911151);
        System.out.println(maxPoints(points));
    }
    //method 1
    //思路：对每一个点与其他的点连线求slope，公式是slope=1.0*(points[j].y-points[i].y)/(points[j].x-points[i].x)，
    //如果斜率相同，说明它们在同一个线上，用一个map来记录，key为斜率，value为点的个数。
    //需要注意的是，points[j].x-points[i].x可能为0，也就是竖直或同一个点的情况，这两种情况要先考虑。
    //由于Double精度问题，无法通过leetcode测试。[[0,0],[94911151,94911150],[94911152,94911151]]会被电脑当成同一线上。
    private static Map<Double,Integer> map=new HashMap<>(); //记录某一斜率下有几个点在同一线条上。
    public static int maxPoints(Point[] points){
        if(points==null||points.length==0)return 0;
        int len=points.length;
        if(len<=2)return len;

        int max=Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int vertical=0;
            int duplicate=0;
            map.clear(); //每重新开始一个点，我们要清空map里面的数据。

            for (int j = 0; j < len; j++) {
                if(i==j)continue;  //自己到自己就直接skip。
                if(points[i].x==points[j].x){
                    if(points[i].y==points[j].y){ //两个重复的点
                        duplicate++;
                    }else{                        //竖直的情况
                        vertical++;
                    }
                }else{   //其他情况可以求斜率
                    Double slope=(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x);
                    if(!map.containsKey(slope)){   //map中不存在这个斜率，那么加进去，点是2个。
                        map.put(slope,1);
                    }else{
                        map.put(slope,map.get(slope)+1); //存在的话，那么同一斜率的点的个数+1.
                    }
                }

            }
            //对当前points[i]与其他点的连线，求出最多的点在同一线上的最大值。
            max=Math.max(max,vertical+duplicate+1);

            for(Double key:map.keySet()){
                max=Math.max(max,map.get(key)+duplicate+1);
            }
        }

        return max;
    }

    //method2 用分数来表示
    //总的思路很上面差不多，但是用分数来表示上面的斜率，这个表示方法是用一个map：Map<Integer,Map<Integer,Integer>>,第一个Int放
    //分子，第二个int放分母，第三个int装个数。
    //为了查找是否是同一个slope，需要将分子、分母的最小公约数去掉，否则，如果在分子分母上同时乘以一个数，就变成另外一个slope了。因此
    //要一个求最小公约数的辅助函数。
    private static Map<Integer,Map<Integer,Integer>> cache=new HashMap<>();
    public static int maxPoints1(Point[] points){
        if(points==null||points.length==0)return 0;
        int len=points.length;
        if(len<=2)return len;


        int result=Integer.MIN_VALUE; //外层循环时比较，因为还要考虑到重复点和竖直线的情况。
        for (int i = 0; i < len; i++) {
            int duplicate=0;
            int vertical=0;
            cache.clear();

            int max=Integer.MIN_VALUE; //内层循环：为了不用去cache里面去找最多节点数，在每次计算完之后都来比较一下，记下当前最大的
            for (int j = 0; j < len; j++) {
                if(i==j)continue;
                if(points[i].x==points[j].x){
                    if(points[i].y==points[j].y)duplicate++;
                    else vertical++;
                }else{
                    int dx=points[i].x-points[j].x;
                    int dy=points[i].y-points[j].y;

                    int gcd=generateGDC(dx,dy);
                    if(gcd!=0){
                        dx/=gcd;
                        dy/=gcd;
                    }

                    if(cache.containsKey(dx)){
                        if(cache.get(dx).containsKey(dy)){
                            cache.get(dx).put(dy,cache.get(dx).get(dy)+1);
                        }else{
                            cache.get(dx).put(dy,1);
                        }
                    }else{
                        Map<Integer,Integer> temp=new HashMap<>();
                        temp.put(dy,1);
                        cache.put(dx,temp);
                    }
                    max=Math.max(max,cache.get(dx).get(dy)+1);
                }
            }
            result=Math.max(result,vertical+duplicate+1);
            result=Math.max(result,max+duplicate);
        }
        return result;
    }
    private static int generateGDC(int x,int y){
        if(y==0)return x;
        return generateGDC(y,x%y);
    }
}
