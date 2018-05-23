package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/5/22.
 */
public class LC413ArithmeticSlices {
    public static void main(String[] args) {
        int[] A={1,2,3,4,6,7,8,9};
        System.out.println(numberOfArithmeticsSlices3(A));
    }
    public static int numberOfArithmeticsSlices(int[] A){
        if(A.length<3)return 0;
        int result=0;
        int start=0;
        int gap=A[1]-A[0];
        int end=0;
        for (int i = 1; i < A.length; i++) {
            if(A[i]-A[i-1]==gap){
                end=i;
            }else{
                //calculate
                if(start+1<end){
                    result+=helper(end-start+1);
                }
                start=i-1;
                gap=A[i]-A[i-1];
                end=i;
            }
        }
        if(end==A.length-1&&start+1<end){
            result+=helper(end-start+1);
        }
        return result;
    }
    private static int helper(int n){
        int temp=n-2;
        return (1+temp)*temp/2;
    }
    //method2 跟简洁一些
    public static int numberOfArithmeticsSlices2(int[] A){
        if(A.length<3)return 0;
        int result=0;
        int len=2;
        for (int i = 2; i < A.length; i++) {
            if(A[i]-A[i-1]==A[i-1]-A[i-2])len++;
            else{
                if(len>2)result+=helper(len);
                len=2;
            }
        }
        if(len>2)result+=helper(len);
        return result;
    }
    //method3 DP
    public static int numberOfArithmeticsSlices3(int[] A){
        if(A==null||A.length<3)return 0;
        int[] dp=new int[A.length];
        int result=0;
        for (int i = 2; i < A.length; i++) {
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i]=dp[i-1]+1;
            }
            result+=dp[i];
        }
        return result;
    }
}
