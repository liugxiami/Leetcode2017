package com.ccsi.leetcode4;

public class LC481MagicalString {
    public static void main(String[] args) {
        System.out.println(magicalString(99999));
    }
    public static int magicalString(int n){
        if(n<=0)return 0;
        if(n<=3)return 1;
        int count1s=1;
        int index=2;
        StringBuilder str=new StringBuilder();
        str.append(122);
        while(true){
            char c=str.charAt(str.length()-1)=='1'?'2':'1';
            if(str.charAt(index)=='1'){
                str.append(c);
                if(c=='1')count1s++;
                if(str.length()==n)break;
            }
            else{
                str.append(c);
                if(c=='1')count1s++;
                if(str.length()==n)break;
                str.append(c);
                if(c=='1')count1s++;
                if(str.length()==n)break;
            }
            index++;
        }
        return count1s;
    }
}
