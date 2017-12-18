package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/17.
 */
public class LC224BasicCalculator {
    public static void main(String[] args) {
        String s="(1+(4+15+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }
    public static int calculate(String s){
        if(s==null||s.length()==0)return -1;
        int len=s.length();
        Stack<Integer> nums=new Stack<>(); //这个stack不仅放了数值（已经计算过的结果），还保存了正负号（当前这个数），总是成对
        //进stack。

        int result=0; //到目前为止的结果。碰到符号就将前面的result+当前这个num。如果是碰到’）‘还要多做一点，将当前的result在加上
        //前面暂存在stack里面的result。
        int num=0;    //暂时的每个数，符合之间。
        int sign=1;   //当前这个数是正还是负。
        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if(c>='0'&&c<='9'){ //如果碰到的是数字，那么要取得这个数，方法就是将前面的数乘以10+当前这个数字。
                num=num*10+c-'0';
            }else if(c=='+'){  //如果是’+‘，就将已有的result+当前这个数（注意，符号保存在了sign上），num归0，并将sign调为正好。
                result+=sign*num;
                num=0;
                sign=1;
            }else if(c=='-'){  //如果是’-‘，就将已有的result+当前这个数（注意，符号保存在了sign上），num归0，并将sign调为负好。
                result+=sign*num;
                num=0;
                sign=-1;
            }else if(c=='('){    //将当前这对括号之前的result暂存进stack，并且将这括号之前的正负号也放进stack。
                nums.push(result);
                nums.push(sign);

                result=0;      //并将result重新设置为0，sign为1.
                sign=1;
            }else if(c==')'){  //将result+刚结束的这个num，将num归0，并将这个result加上暂存在stack里面的result加起来。
                result+=sign*num;
                num=0;

                result*=nums.pop(); //'('前面是正还是负
                result+=nums.pop(); //这一对括号之前push进去的result。
            }
        }

        if(num!=0){   //处理尾余，因为最后的字符如果是个数字，那么最后这个num并没有加进result里面去。
            result+=sign*num;
        }
        return result;
    }
}
