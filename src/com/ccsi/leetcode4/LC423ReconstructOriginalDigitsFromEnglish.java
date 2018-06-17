package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/6/17.
 */
public class LC423ReconstructOriginalDigitsFromEnglish {
    public static void main(String[] args) {
        String s="owoztneoerfourfour";
        System.out.println(originalDigits(s));
    }
    public static String originalDigits(String s){
        int[] counts=new int[26];
        int[] nums=new int[10];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)-'a']++;
        }
        nums[0]=counts['z'-'a'];
        nums[2]=counts['w'-'a'];
        nums[4]=counts['u'-'a'];
        nums[6]=counts['x'-'a'];
        nums[8]=counts['g'-'a'];
        nums[1]=counts['o'-'a']-nums[0]-nums[2]-nums[4];
        nums[3]=counts['h'-'a']-nums[8];
        nums[5]=counts['f'-'a']-nums[4];
        nums[7]=counts['s'-'a']-nums[6];
        nums[9]=counts['i'-'a']-nums[5]-nums[6]-nums[8];

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int repeats=nums[i];
            while (repeats-->0)sb.append(i);
        }
        return sb.toString();
    }
}
