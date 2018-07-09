package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/6/27.
 */
public class LC440KthSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        System.out.println(findKthNumber(681692778,351251360));
    }
    //refer #386 the definition of Lexicographical TLE
    public static int findKthNumber(int n,int k){
        if(n<1)return 0;
        long curr=1;
        if(k==1)return (int)curr;
        for (int i = 2; i <=n ; i++) {
            if(curr*10<=n)curr*=10;
            else if(curr%10!=9&&curr+1<=n)curr=curr+1;
            else {
                while((curr/10)%10==9)curr/=10;
                curr=curr/10+1;
            }
            if(i==k)break;
        }
        return (int)curr;
    }
    //转换成十叉树 节点数问题
    public static int findKthNumber1(int n,int k){
        int curr=1;
        k=k-1;
        while(k>0){
            int steps=calSteps(n,curr,curr+1);
            //先看1到2间的节点数，再看2到3之间...
            if(steps<=k){ //如果x节点不在子树里（没到k），那么直接往右看，将k减去里面的节点数就可以了
                curr+=1;
                k-=steps;
            }else{  //说明那个x节点在子树里面，那么往里下走
                curr*=10;
                k-=1;
            }
        }
        return curr;
    }
    //按层来计算节点数，比如1的子节点有10~19，子子节点有100到199，子子子节点有1000到1999...其节点数就是
    //将每层的节点数累积起来。
    private static int calSteps(int n,long left,long right){
        int steps=0;
        while(left<=n){
            steps+=Math.min(n+1,right)-left;
            left*=10;
            right*=10;
        }
        return steps;
    }
}
