package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/19.
 */
public class LC010RegularExpressionMatching {
    public static void main(String[] args) {
        String s="aa";
        String p="aa";
        System.out.println(isMatch(s,p));
    }
    //DP
    public static boolean isMatch(String s,String p){
        //pattern为空的情况下，如果string也为空，那么为true，否则为false。
        if(p==null)return s==null;

        //如果string为空，pattern就有好几种情况，一是为空，上面已经判断，另外就是如“a*”，“a*b*”...
        // 有偶数位并且下标为奇数位都是‘*’的情况下可以匹配，否则不行。
        if(s==null){
            int lenP=p.length();
            if(lenP==0)return true;
            else if(lenP%2==0){
                for (int i = 1; i < lenP; i+=2) {
                    if(p.charAt(i)!='*')return false;
                }
                return true;
            }else return false;
        }
        //p的第一位不能为‘*’

        //下面是都不为空的情况下
        //用一个二维数组来记录
        int lenS=s.length();
        int lenP=p.length();

        if(lenP==1){
            if(p.charAt(0)=='*')return false;
            else if(p.charAt(0)=='.'){
                if(lenS==1)return true;
                else return false;
            }
            else if(lenS==1&&p.charAt(0)==s.charAt(0)){
                return true;
            }else return false;
        }

        boolean[][] dp=new boolean[lenS+1][lenP+1];

        //初始化
        dp[0][0]=true;

        //第一行的情况,也就是解决“a*”，“a*b*”...的问题。
        for (int i = 2; i <=lenP ; i++) {
            if(p.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-2];
            }
        }

        //运用合适的循环,有三种情况，一是pattern位上是‘.’或与string上的字符相同的情况，二是pattern上是‘*’的情况，其前一个
        //字符出现0次或多次，还要分此时string上的字符是否与pattern上*号前一个字符是否相同；三是不匹配。
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                char sc=s.charAt(i-1);
                char pc=p.charAt(j-1);
                if(pc=='.'||pc==sc)dp[i][j]=dp[i-1][j-1];
                else if(pc=='*'){
                    dp[i][j]=dp[i][j-2];
                    if(sc==p.charAt(j-2)||p.charAt(j-2)=='.')dp[i][j]=dp[i][j]|dp[i-1][j];
                }else dp[i][j]=false;
            }
        }
        return dp[lenS][lenP];
    }
}
