package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/27.
 */
public class LC241DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        List<Integer> res=diffWaysToCompute("2*3-4*5");
        res.forEach(x-> System.out.println(x));
    }
    private static Map<String,List<Integer>> map=new HashMap<>();
    public static List<Integer> diffWaysToCompute(String input){
        List<Integer> res=new ArrayList<>();
        if(input==null||input.length()==0)return res;

        return ways(input);
    }
    private static List<Integer> ways(String input){
        if(map.containsKey(input))return map.get(input);
        List<Integer> result=new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char ch=input.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*'){
                List<Integer> left=ways(input.substring(0,i));
                List<Integer> right=ways(input.substring(i+1));

                //笛卡尔乘积，比如left集合有3个元素，right集合有2个元素，最后的结果集就有3*2=6个元素。
                for(Integer l:left){
                    for (Integer r:right) {
                        switch (ch){
                            case '+':
                                result.add(l+r);
                                break;
                            case '-':
                                result.add(l-r);
                                break;
                            case '*':
                                result.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        if(result.size()==0)result.add(Integer.parseInt(input));//递归结束条件
        map.put(input,result);

        return result;
    }
}
