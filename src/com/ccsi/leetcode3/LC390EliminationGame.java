package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/4/22.
 */
public class LC390EliminationGame {
    public static void main(String[] args) {
        System.out.println(lastRemaining1(9));
    }
    //用两个stack，到来到去，对于两个stack来说，奇数次到都不接收，偶数次到另一个stack要接收，
    //直到最后一个元素。
    public static int lastRemaining(int n){
        Stack<Integer> forward=new Stack<>();
        Stack<Integer> backward=new Stack<>();
        for (int i = n; i >=1 ; i--) {
            backward.push(i);
        }
        int result=-1;
        int count=1;
        while(true){
            boolean isOdd=false;
            if(count%2==1){
                while(!backward.isEmpty()){
                    int temp=backward.pop();
                    if(isOdd){
                        forward.push(temp);
                    }
                    isOdd=!isOdd;
                }
            }else{
                while(!forward.isEmpty()){
                    int temp=forward.pop();
                    if(isOdd){
                        backward.push(temp);
                    }
                    isOdd=!isOdd;
                }
            }
            count++;

            if (forward.size()==1&&backward.isEmpty()){
                result=forward.pop();
                break;
            }
            if (backward.size()==1&&forward.isEmpty()){
                result=backward.pop();
                break;
            }
        }
        return result;
    }
    /*网上有更简单的方法，但不是很好理解，就是找规律
    input
    example1
    1 2 3 4 5 6 7 8  step=1;head=1;remaining=9
      2   4   6   8  step=2;head=2;remaining=4
      2       6      step=4;head=2;remaining=2
              6             head=6;remaining=1
    example2
    1 2 3 4 5 6 7    step=1;head=1;remaining=7
      2   4   6      step=2;head=2;remaining=3
          4                 head=4;remaining=1
     */
    public static int lastRemaining1(int n){
        int head=1;
        int step=1;
        boolean left2right=true;

        int remaining=n;
        while(remaining>1){
            if(left2right||remaining%2==1){//从左往右或者剩余个数是奇数时，更新head
                head+=step;
            }
            //每次循环都要做的事
            step<<=1;   //每次循环，step*2
            remaining>>=1; //remaining减半
            left2right=!left2right; //从左往右与从右往左要更换
        }
        return head;
    }
}
