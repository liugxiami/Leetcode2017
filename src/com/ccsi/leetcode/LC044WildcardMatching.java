package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/18.
 */
public class LC044WildcardMatching {
    public static void main(String[] args) {
        System.out.println(isMatch1("ho","**ho"));
    }
// 和Regular Expression Matching很像，这里的'?'相当于Regular Expression中的'.'，但'*'的用法不一样。这里'*'与前一个字符没有联系，
// 并且无法消去前一个字符，但可以表示任意一串字符。递推公式的推导和Regular Expression Matching也基本类似。
//
//    p[j-1] == s[i-1] || p[j-1] == '?'：    dp[i][j] = dp[i-1][j-1]
//    p[j-1] == '*'：
//                                          1. 匹配0个字符：dp[i][j] = dp[i][j-1]
//                                          2. 匹配1个字符：dp[i][j] = dp[i-1][j-1]
//                                          3. 匹配多个字符：dp[i][j] = dp[i-1][j]

    public static boolean isMatch(String s,String p){
        if(s==null&&p==null)return true;
        if(s==null||p==null)return false;
        int sLen=s.length();
        int pLen=p.length();

        boolean[][] cache=new boolean[pLen+1][sLen+1];
        cache[0][0]=true;  //注意点一：边界处理

        int start=0;//当前对于每行搜索的时候起始位置的标示，一定不用搜索的位置就是每当Pattern遇到一个非*的地方就可以加1
        for (int row = 1; row <= pLen; row++) {
            if(p.charAt(row-1)=='*'){
                cache[row][0]=cache[row-1][0];  //注意点二：边界处理
                for (int col = 1; col <=sLen ; col++) {
                    cache[row][col]=cache[row-1][col-1]||cache[row-1][col]||cache[row][col-1];
                }
            }else{
                start++;
                for (int col = start; col <=sLen ; col++) {
                    if(p.charAt(row-1)=='?'||p.charAt(row-1)==s.charAt(col-1))cache[row][col]=cache[row-1][col-1];
                }
            }
        }
        return cache[pLen][sLen];
    }

    public static boolean isMatch1(String s,String p){
        if(s==null&&p==null)return true;
        if(s==null||p==null)return false;
        int sLen=s.length();
        int pLen=p.length();

        boolean[] pre=new boolean[sLen+1];
        pre[0]=true;

        int start=0;
        for (int row = 1; row <= pLen; row++) {
            boolean[] curr=new boolean[sLen+1];
            if(p.charAt(row-1)=='*'){
                curr[0]=pre[0];
                for (int col = 1; col <=sLen; col++) {
                    curr[col]=pre[col]||pre[col-1]||curr[col-1];
                }
            }else{
                start++;
                for (int col = start; col <= sLen; col++) {
                    if(p.charAt(row-1)=='?'||p.charAt(row-1)==s.charAt(col-1)){
                        curr[col]=pre[col-1];
                    }
                }
            }

            pre=curr;
        }
        return pre[sLen];
    }
}
