package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2018/1/4.
 */
public class LC282ExpressionAddOperators {
    public static void main(String[] args) {
        List<String> res=addOperators("3456237490",9191);
        res.forEach(x-> System.out.println(x));
    }
    public static List<String> addOperators(String num,int target){
        List<String> result=new ArrayList<>();
        if(num==null||num.length()==0)return result;
        helper(result,"",num,target,0,0);
        return result;
    }
    private static void helper(List<String> result,String temp,String Num,int target,long currRes,long preNum){
        if(Num.length()==0&&currRes==target){
            result.add(new String(temp));
            return;
        }
        for (int i = 1; i <= Num.length(); i++) {
            String currStr=Num.substring(0,i);
            if(currStr.length()>1&&currStr.charAt(0)=='0')return; //如果当前这个数的位数大于等于2，并且第一个数是0的话
            long currNum=Long.parseLong(currStr);

            String next=Num.substring(i);
            if(temp.length()==0){//第一个数
                helper(result,currStr,next,target,currNum,currNum);
            }else{
                helper(result,temp+"*"+currStr,next,target,currRes-preNum+currNum*preNum,currNum);
                helper(result,temp+"+"+currStr,next,target,currRes+currNum,currNum);
                helper(result,temp+"-"+currStr,next,target,currRes-currNum,-currNum);
            }
        }
    }
}
