package com.ccsi.leetcode5;

public class LC546RemoveBoxes {
    public static void main(String[] args) {
        int[] boxes={1,3,2,2,2,3,4,3,1};
        System.out.println(removeBoxes(boxes));
    }
    //1.dp[i][j][k]=(1+k)*(1+k)+dp[i+1][j][0]remove 第i位情况
    //2.dp[i][j][k]=dp[i+1][m-1]+dp[m][j][k+1] 如果i+1到j有一个数和第i位相等，那么先remove i+1到m-1，让i位接到m位，此时k++
    //k表示m之前有k个相同的数
    public static int removeBoxes(int[] boxes){
        if(boxes==null||boxes.length==0)return 0;
        int len=boxes.length;
        int[][][] dp=new int[len][len][len+1];
        helper(boxes,0,len-1,0,dp);
        return dp[0][len-1][0];
    }
    public static int helper(int[] boxes,int i,int j,int k,int[][][] dp){
        if(i>j)return 0; //如果i比j大了，没有points
        if(dp[i][j][k]>0)return dp[i][j][k]; //已经计算过了，就直接返回
        int res=(1+k)*(1+k)+helper(boxes,i+1,j,0,dp); //直接remove第i位时的points
        for (int m = i+1; m <=j; m++) { //如果在i+1到j有和第i位相同的数，那么留下第i位与第m位组合的情况，k++
            if(boxes[i]==boxes[m]){
                res=Math.max(res,helper(boxes,i+1,m-1,0,dp)+helper(boxes,m,j,k+1,dp)); //递归计算i+1到m-1的子数组
                //已经第m位到j位的情况，此时k增加了一位
            }
        }
        dp[i][j][k]=res;
        return dp[i][j][k];
    }
}
