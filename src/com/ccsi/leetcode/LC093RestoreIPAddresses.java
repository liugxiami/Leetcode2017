package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/17.
 */
public class LC093RestoreIPAddresses {
    public static void main(String[] args) {
        String s="255255350";
        List<String> res=restoreIpAddresses(s);
        res.forEach(x-> System.out.println(x));
    }

    public static List<String> restoreIpAddresses(String s){
        List<String> finalResult=new ArrayList<>();
        if(s==null||s.length()<4||s.length()>12)return finalResult;

        List<List<String>> result=new ArrayList<>();
        helper(result,new ArrayList<>(),s,0);

        for (int i = 0; i < result.size(); i++) {
            List<String> tempList=result.get(i);

            //if(tempList.get(0).equals("0")||tempList.get(3).equals("0")) continue;//需要去除开头和结尾为“0”的情况吗？
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < tempList.size(); j++) {
                sb.append(tempList.get(j));
                if(j!=3)sb.append(".");
            }
            finalResult.add(sb.toString());
        }

        return finalResult;
    }

    private static void helper(List<List<String>> result,ArrayList<String> list,String s,int index){
        if(list.size()>=4&&index!=s.length())return;

        if(list.size()==4&&index==s.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        StringBuilder str=new StringBuilder();
        for (int i = index; i < s.length()&&i<index+3; i++) {
            str.append(s.charAt(i));

            if(isValid(str.toString())){
                list.add(str.toString());
                helper(result,list,s,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    private static boolean isValid(String str){
        if(str==null||str.length()<1||str.length()>3)return false;
        int len=str.length();
        if((len==2||len==3)&&str.charAt(0)=='0')return false;

        int value=0;
        for (int i = 0; i < len; i++) {
            value*=10;
            value+=str.charAt(i)-'0';
        }

        return value>=0&&value<=255;
    }
}
