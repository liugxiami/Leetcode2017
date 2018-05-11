package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/5/10.
 */
public class LC400NthDigit {
    /**
     * 这里是找第n个数字(这里的数和数字有区别，数字可以理解为将所有数拼合成一个字符串后的第n为对应的数字（0-9)）
     * 这里首先分析一下位数和规律
     * 个位数：1-9，一共9个,共计9个数字
     * 2位数：10-99,一共90个，共计180个数字
     * 3位数：100-999，一共900个，共计2700个数字
     * 4位数，1000-9999，一共9000个，共计36000个数字
     * 以此类推，
     * 这样我们就可以首先定位到是哪个数，再找到其对应的数字
     * */
    public static void main(String[] args) {
        System.out.println(findNthDigit(2147483647));
    }
    public static int findNthDigit(int n){
        if(n<1)return -1;
        if(n<10)return n;

        int i=1;
        long dev=1;
        long start=1;
        while(n>9*dev*i){
            n-=9*dev*i;
            dev*=10;
            i++;
            start*=10;
        }

        int count=(n-1)/i;
        int remain=(n-1)%i;
        String curr=String.valueOf(start+count);
        return curr.charAt(remain)-'0';
    }
}
