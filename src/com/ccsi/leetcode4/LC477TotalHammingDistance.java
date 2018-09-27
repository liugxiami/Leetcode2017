package com.ccsi.leetcode4;

public class LC477TotalHammingDistance {
    public static void main(String[] args) {
        int[] nums={4,14,2};
        System.out.println(totalHammingDistance1(nums));
    }
    //method1，根据466题求hamming distance的方法，我们知道，如果是求两个数的hamming距离，就让这两个数异或，然后看看结果里面
    //有多少个1，求1的个数可以将这个数x和x-1相与，每与一次，count+1，直到x==0，这时的count就是个数。
    //那么最简单的方法就是将给的数组里面的数两两求异或，然后累加hamming距离。但这估计过不了test。
    public static int totalHammingDistance(int[] nums){
        if(nums==null||nums.length<2)return -1;
        int result=0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int num1=nums[i];
                int num2=nums[j];
                result+=hammingDistance(num1,num2);
            }
        }
        return result;
    }
    private static int hammingDistance(int num1,int num2){
        int temp=num1^num2;
        int count=0;
        while(temp>0){
            count++;
            temp=temp&(temp-1);
        }
        return count;
    }
    /*
    找规律，比如
    比如我们看下面这个例子，4，14，2和1：
    4:     0 1 0 0
    14:    1 1 1 0
    2:     0 0 1 0
    1:     0 0 0 1

    我们先看最后一列，有三个0和一个1，那么它们之间相互的汉明距离就是3，即1和其他三个0分别的距离累加，然后在看第三列，累加汉明距离为4，
    因为每个1都会跟两个0产生两个汉明距离，同理第二列也是4，第一列是3。我们仔细观察累计汉明距离和0跟1的个数，我们可以发现其实就是0的个
    数乘以1的个数，发现了这个重要的规律，那么整道题就迎刃而解了，只要统计出每一位的1的个数即可。
     */
    public static int totalHammingDistance1(int[] nums){
        int result=0;
        int len=nums.length;
        for (int i = 0; i < 32; i++) {
            int zeros=0;
            int ones=0;
            for (int j = 0; j < len; j++) {
                if((nums[j]&(1<<i))==0)zeros++;
                else ones++;
            }
            result+=zeros*ones;
        }
        return result;
    }
}
