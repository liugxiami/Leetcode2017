package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/3.
 */
public class LC065ValidNumber {
    public static void main(String[] args) {
        System.out.println(isNumber("4e+"));
    }
    public static boolean isNumber(String s){
        if(s==null||s.length()==0)return false;
        int len=s.length();
        while(len>0&&s.charAt(0)==' '){
            s=s.substring(1);
            len--;
        }

        while(len>0&&s.charAt(len-1)==' '){
            s=s.substring(0,len-1);
            len--;
        }

        int eIndex=s.indexOf('e');
        if(eIndex!=-1){
            if(eIndex==0||eIndex==len-1)return false;
            String str1=s.substring(0,eIndex);
            String str2=s.substring(eIndex+1);
            return isDigits(str1,true)&& isDigits(str2,false);
        }else return isDigits(s,true);
    }

    private static boolean isDigits(String str, boolean canBeFloat){
        if(str==null||str.length()==0)return false;
        int len=str.length();
        int dotNum=0;

        if(str.charAt(0)=='+'||str.charAt(0)=='-'){
            str=str.substring(1);
            len--;
        }

        for (int i = 0; i < len; i++) {
            char curr=str.charAt(i);
            if(curr=='.'){
                dotNum++;
                if(dotNum>1)return false;
                continue;
            }else if(curr<'0'||curr>'9')return false;
        }

        if(len==0)return false; //"4e+"---false
        if(!canBeFloat&&dotNum==1)return false;
        //if(dotNum==1&&str.charAt('.')==len-1)return false; //检测中3.--true
        if(dotNum==1&&len==1)return false;

        return true;
    }
}
