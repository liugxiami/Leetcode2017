package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/29.
 */
public class LC168ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(27));
    }
    public static String convertToTitle(int n){
        StringBuilder result=new StringBuilder();
        if(n<=0)return "";
        while(n>0){
            n--;  //关键处理步骤，否则在26是会有问题（26/26==1，26%26==0，开始没写这一步，只是在下面拿字符是-1，26就变成了AZ）。
            //这个--就是为了解决26进位问题（因为26并不需要进位，一进位就变成2位数了。）
            int rem=n%26;
            result.append((char)('A'+rem));
            n/=26;
        }
        return result.reverse().toString();
    }
}
