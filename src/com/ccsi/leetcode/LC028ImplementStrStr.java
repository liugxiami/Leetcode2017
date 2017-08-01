package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/31.
 */
public class LC028ImplementStrStr {
    public static void main(String[] args) {
        String haystack="a";
        String needle="a";
        System.out.println(strStr1(haystack,needle));
    }
    public static int strStr(String haystack,String needle){
        if(haystack==null||haystack.length()==0)return -1;
        if(needle==null||needle.length()==0)return -1;
        int hLen=haystack.length();
        int nLen=needle.length();
        if(hLen<nLen)return -1;
        int index=-1;
        int hIndex=0,nIndex=0;
        while(hIndex<hLen&&nIndex<nLen){
            if(haystack.charAt(hIndex)==needle.charAt(nIndex)){
                index=hIndex;
                while(hIndex<hLen&&nIndex<nLen&&haystack.charAt(hIndex)==needle.charAt(nIndex)){
                    hIndex++;
                    nIndex++;
                }
                if(nIndex==nLen)return index;
                else{
                    hIndex=index+1;
                    nIndex=0;
                }
            }else{
                hIndex++;
            }
        }
        return -1;
    }

    public static int strStr1(String haystack,String needle){
        if(haystack==null||needle==null)return -1;
        if(haystack.length()==0&&needle.length()==0)return 0;
        if(haystack.length()==0)return -1;
        if(needle.length()==0)return 0;

        int hLen=haystack.length();
        int nLen=needle.length();

        for (int i = 0; i < hLen - nLen+1; i++) {
            int j=0;
            for (; j < nLen; j++) {
                if(haystack.charAt(i+j)!=needle.charAt(j))break;
            }
            if(j==nLen)return i;
        }
        return -1;
    }
}
