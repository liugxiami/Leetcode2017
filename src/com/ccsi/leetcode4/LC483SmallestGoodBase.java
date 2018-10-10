package com.ccsi.leetcode4;

public class LC483SmallestGoodBase {
    public static void main(String[] args) {
        System.out.println(smallestGoodBase("4681"));
    }
    //等比数列求和的变种，需要了解等比数列求和的公式。给定一个数字，求基数最小的等比数列，也就是说，数列要最多，那么最多的可能就是
    //基数为2时，然后以求出的数列个数从最多一个一个往下减，查找是否有合适的基数，方法用二分查找，为了更快，要找出可能的最小及最大基数
    //查找的方法回到等比数列公式，求出可能的最大基数和最小基数，通过二分查找来找到基数。
    public static String smallestGoodBase(String n){
        long num=Long.parseLong(n);
        for (int i = (int)(Math.log(num+1)/Math.log(2)); i >=2 ; i--) {
            long left=(long)Math.pow(num+1,1.0/i); //注意此处的指数必须是实数，及1.0，整除的话结果是不对的。
            long right=(long)Math.pow(num,1.0/(i-1));
            while(left<=right){ //二分查找，是<=
                long mid=left+(right-left)/2;
                long sum=binarySearch(mid,i); //以mid为base，以i为指数的等比数列和
                if(sum==num)return String.valueOf(mid); //正好等于num的话，就将当前基数转换为字符串返回。
                else if(num<sum)right=mid-1;
                else left=mid+1;
            }
        }
        return String.valueOf(num-1);
    }
    private static long binarySearch(long base,int exp){
        long sum=1;
        for (int i = 1; i <= exp; i++) {
            sum=sum*base+1;
        }
        return sum;
    }
}
