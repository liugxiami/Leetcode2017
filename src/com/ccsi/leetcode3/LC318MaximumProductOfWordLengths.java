package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/2/6.
 */
public class LC318MaximumProductOfWordLengths {
    public static void main(String[] args) {
        String[] words={"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(maxProduct1(words));
    }
    //method1:最土的方法，用了一个辅助函数来比较是否有相同的字符，这个版本应该通不过测试。
    public static int maxProduct(String[] words){
        if(words==null||words.length<2)return 0;
        int len=words.length;
        int max=0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                if(max>words[i].length()*words[j].length())continue;

                if(!hasCommonLetters(words[i],words[j])){
                    max=Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
    private static boolean hasCommonLetters(String str1,String str2){
        if(str1.length()==0||str2.length()==0)return false;
        int[] bitMap=new int[26];
        for (int i = 0; i < str1.length(); i++) {
            bitMap[str1.charAt(i)-'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            if(bitMap[str2.charAt(i)-'a']!=0)return true;
        }
        return false;
    }
    //method2:用一个mask来做做，因为题目说明只有小写字符，那么也就是只有26位，一个int数有32位，有足够的空间来表示
    //一个word，如果有某个字符c，那么这个int数的c-‘a’位上就用1表示。
    public static int maxProduct1(String[] words){
        if(words==null||words.length<2)return 0;
        int len=words.length;
        int max=0;

        int[] masks=new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                masks[i]|=(1<<(words[i].charAt(j)-'a'));
            }
        }

        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j <len ; j++) {
                if(max>words[i].length()*words[j].length())continue;
                if((masks[i]&masks[j])==0){
                    max=Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}
