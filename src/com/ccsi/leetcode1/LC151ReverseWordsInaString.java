package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/22.
 */
public class LC151ReverseWordsInaString {
    public static void main(String[] args) {
        //String s="  the   sky is blue  ";
        String s=" ";
        String res=reverseWords1(s);
        System.out.println(res);
    }
    //method1,该方法是完整的reverse，包括空格个数。这应该是真正的reverseWords，但看别人的解题，似乎只是reveres words
    //不考虑将空格也reverse到结果中去。补充：题目中有Clarification的定义，看一下就知道，这method1不行。
    public static String reverseWords(String s){
        if(s==null||s.length()==0)return s;
        int len=s.length();
        char[] chars=s.toCharArray();   //转变成charArray
        reverse(chars,0,len-1);  //先对整个数组reverse一遍。

        int from=0;
        int to=0;
        int index=0;
        while(true){
            if(index==len)break;
            while(index<len&&chars[index]==' ')index++;  //找到第一非空格字符
            from=index;

            while(index<len&&chars[index]!=' ')index++;  //继续找下一个空格字符
            to=index;

            reverse(chars,from,to-1);    //对从第一非空格字符到下一个空格字符的前一个字符间做reverse
        }
        return new String(chars);  //把数组恢复成string并返回。结束。
    }
    private static void reverse(char[] chars,int start,int end){
        while(start<end){
            char temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
    }
    //method2，利用split，可能会比较慢。
    public static String reverseWords1(String s){
        if(s==null||s.length()==0)return s;
        String[] strings=s.split(" ");
        StringBuilder sb=new StringBuilder("");
        for (int i = strings.length-1; i >=0 ; i--) {
            if(!strings[i].equals("")){  //用equals和==null结果不同。
                if(!sb.toString().equals(""))sb.append(" ");
                sb.append(strings[i]);
            }
        }
        return sb.toString();
    }
    //method3 直接从后往前迭代，巧用stringBuilder两次,一个记录结果，一个记录暂时的string，这是要reverse的。
    public static String reverseWords2(String s){
        if(s==null||s.length()==0)return s;
        int len=s.length();

        StringBuilder result=new StringBuilder("");
        for (int i = len-1; i >=0 ; ) {
            while(i>=0&&s.charAt(i)==' ')i--;
            if(i<0)break;

            if(!result.toString().equals(""))result.append(' ');
            StringBuilder temp=new StringBuilder();
            while(i>=0&&s.charAt(i)!=' '){
                temp.append(s.charAt(i));
                i--;
            }
            temp.reverse();
            result.append(temp);
        }
        return result.toString();
    }
}
