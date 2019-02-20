package com.ccsi.leetcode5;

import java.util.*;

public class LC587ErectTheFence {
    public static void main(String[] args) {
        Point[] points=new Point[6];
        points[0]=new Point(1,1);
        points[1]=new Point(2,2);
        points[2]=new Point(2,0);
        points[3]=new Point(2,4);
        points[4]=new Point(3,3);
        points[5]=new Point(4,2);
        List<Point> result=outerTrees(points);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i).x+" "+result.get(i).y);
            System.out.println();
        }
    }
    public static List<Point> outerTrees(Point[] points){
        Arrays.sort(points,(p,q)->{return p.x==q.x?q.y-p.y:p.x-q.x;});
        Stack<Point> stack=new Stack<>();
        for (int i = 0; i < points.length; i++) {
            //注意，这是while不是if，因为需要不断判断这三个点是否是同一个方向转。
            while(stack.size()>=2&&coordinate(stack.get(stack.size()-2),stack.peek(),points[i])>0){
                stack.pop();
            }
            stack.push(points[i]);
        }
        stack.pop();//需要将最后一个点先pop掉，后面逆时针走时，第一个进去的就是这最后一个。
        for (int i = points.length-1; i >=0 ; i--) {
            while(stack.size()>=2&&coordinate(stack.get(stack.size()-2),stack.peek(),points[i])>0){
                stack.pop();
            }
            stack.push(points[i]);
        }
        List<Point> result=new ArrayList<>();
        result.addAll(new HashSet<>(stack));
        return result;
    }
    private static int coordinate(Point p,Point q,Point r){
        return (p.y-q.y)*(r.x-q.x)-(r.y-q.y)*(p.x-q.x);
    }
}
