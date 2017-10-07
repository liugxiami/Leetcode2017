package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/4.
 */
public class LC068TextJustification {
    public static void main(String[] args) {
        //String[] words={"This", "is", "an", "example", "of", "text", "justification."};
        //String[] words={"What","must","be","shall","be."};
        String[] words={""};
        List<String> res=fullJustify(words,0);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
    //method 1 超时
    public static List<String> fullJustify(String[] words,int maxWidth){
        List<String> result=new ArrayList<>();
        if(words==null||words.length==0)return result;
        int len=words.length;
        int startIndex=0;
        int currIndex=0;

        while(currIndex<len){
            int currLen=0;
            while(currIndex<len){
                currLen+=words[currIndex].length();
                if(currLen+currIndex-startIndex>maxWidth){
                    currLen-=words[currIndex].length();
                    currIndex-=1;
                    break;
                }

                currIndex++;
            }

            int gaps=currIndex-startIndex;

            if(currIndex==len||gaps==maxWidth-currLen||gaps==0){   //last line
                    StringBuilder str=new StringBuilder();
                    for (int i = startIndex; i <currIndex ; i++) {
                        str.append(words[i]);
                        str.append(' ');
                    }
                    if(currIndex!=len)str.append(words[currIndex]);
                    if(currIndex==len)str.deleteCharAt(str.length()-1);

                    int extra=maxWidth-str.length();
                    while(extra-->0){
                        str.append(" ");
                    }
                    result.add(str.toString());
            }else{ //从第一行到倒数第二行
                int totalSpaces=maxWidth-currLen; //总的空格数

                StringBuilder str=new StringBuilder();
                int avgSpaces=totalSpaces/gaps;
                int extra=totalSpaces%gaps;

                for (int i = startIndex; i <currIndex; i++) {
                    str.append(words[i]);
                    int spaces=avgSpaces;
                    while(spaces-->0)str.append(" ");

                    if(extra>0){
                        str.append(" ");
                        extra--;
                    }
                }
                str.append(words[currIndex]);

                result.add(str.toString());
            }
            currIndex++;
            startIndex=currIndex;
        }
        return result;
    }
}
