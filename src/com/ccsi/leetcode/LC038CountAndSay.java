package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/13.
 */
public class LC038CountAndSay {
    public static String countAndSay(int n){
        if(n<1)return "";
        StringBuilder str=new StringBuilder();
        str.append(1);

        for (int i = 2; i <= n; i++) {
            String string=str.toString();
            int len=string.length();
            str=new StringBuilder();
            int count=1;
            char c=string.charAt(0);

            for (int j = 1; j < len; j++) {
                if(string.charAt(j)==c){
                    count++;
                }else{
                    str.append(count);
                    str.append(c);
                    c=string.charAt(j);
                    count=1;
                }
            }

            str.append(count);
            str.append(c);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
