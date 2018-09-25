package com.ccsi.leetcode4;

public class LC474OnesAndZeroes {
    public static void main(String[] args) {
        //String[] strs={"10", "0", "1"};
        String[] strs={"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxFormDP(strs,5,3));
    }
    //method1 bt
    private static int max=0;
    public static int findMaxForm(String[] strs,int m,int n){
        if(strs==null||strs.length==0)return 0;
        int[][] arrays=new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int zeros=0;
            int ones=0;
            for (int j = 0; j < strs[i].length(); j++) {
                char c=strs[i].charAt(j);
                if(c=='0')zeros++;
                else ones++;
            }
            arrays[i][0]=zeros;
            arrays[i][1]=ones;
        }

        findMax(arrays,m,n,0,0,0,0);
        return max;
    }
    private static void findMax(int[][] arrays,int m,int n,int index,int zeros,int ones,int counts){
        if(index==arrays.length){
            max=Math.max(max,counts);
            return;
        }

        for (int i = index; i < arrays.length; i++) {
            findMax(arrays,m,n,i+1,zeros,ones,counts);
            zeros+=arrays[index][0];
            ones+=arrays[index][1];
            if(zeros<=m&&ones<=n){
                findMax(arrays,m,n,i+1,zeros,ones,counts+1);
            }
            zeros-=arrays[index][0];
            ones-=arrays[index][1];
        }
    }
    /*method2 DP
    DP[i][j]表示当有i个zeros，j个ones时最多能有多少个strings。
    那么找状态方程，迭代到第n个strings，其有zeros个0，ones个1，那么DP[i][j]=MAX(DP[i][j],DP[i-zeros][j-ones]+1).
    */
    public static int findMaxFormDP(String[] strs,int m,int n){
        if(strs==null||strs.length==0)return 0;
        int[][] dp=new int[m+1][n+1];
        for(String str:strs){
            int zeros=0;
            int ones=0;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)=='0')zeros++;
                else ones++;
            }
            for (int i = m; i >=zeros ; i--) {
                for (int j = n; j >=ones ; j--) {
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeros][j-ones]+1);
                }
            }
        }
        return dp[m][n];
    }
}
