package com.ccsi.leetcode4;

public class LC482LicenseKeyFormatting {
    public static void main(String[] args) {
        String S="------2aa-5g-3-J";
        System.out.println(licenseKeyFormating(S,2));
    }
    public static String licenseKeyFormating(String S,int K){
        S=S.toUpperCase();
        char[] chars=S.toCharArray();
        StringBuilder sb=new StringBuilder();
        int count=0;
        for (int i = S.length()-1; i >=0 ; i--) {
            if(count==K){
                sb.append('-');
                count=0;
            }

            if(chars[i]=='-')continue;
            sb.append(chars[i]);
            count++;

        }
        while(sb.length()!=0&&sb.charAt(sb.length()-1)=='-')sb.deleteCharAt(sb.length()-1);
        return sb.reverse().toString();
    }
}
