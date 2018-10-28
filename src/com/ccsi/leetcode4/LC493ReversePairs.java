package com.ccsi.leetcode4;

public class LC493ReversePairs {
    public static void main(String[] args) {
        int[] nums={2,4,3,5,1};
        System.out.println(reversePairsMergeSort(nums));
    }
    //method1,两个循环，O（n！）,肯定不能过test
    public static int reversePairs(int[] nums){
        if(nums==null||nums.length<2)return 0;
        int len=nums.length;
        int counts=0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                if(nums[i]>2*nums[j])counts++;
            }
        }
        return counts;
    }
    //method2 mergesort
    public static int reversePairsMergeSort(int[] nums){
        if(nums==null||nums.length<2)return 0;
        return mergeSort(nums,0,nums.length-1);
    }
    private static int mergeSort(int[] nums,int start,int end){
        if(start>=end)return 0;
        int mid=start+(end-start)/2;
        int counts=mergeSort(nums,start,mid)+mergeSort(nums,mid+1,end);
        //如：4，5，6（left part） 1，2，3（right part）计算counts时，用左边的每一个都去和右边的数比较，如果出现符合要求的，就
        //累加counts，考虑到都是升序排列的数组，那么和右边比较时，知道不符合要求，相减就能算出个数，而不必用counts++。
        for (int i = start,j=mid+1; i <= mid; i++) { //j=mid+1必需声明在这里，如果是在loop里面，则会TLE.
            while(j<=end&&nums[i]/2.0>nums[j])j++; //小技巧，用除以2.0来做，如果后面乘以2，可能造成出现超出integer最大值
            counts+=j-(mid+1);
        }
        //对merge了的数组排序
        sort(nums,start,mid,end);
        return counts;
    }
    //典型的sort函数，需要默记。
    private static void sort(int[] nums,int start,int mid,int end){
        int[] helper=new int[nums.length]; //需要一个辅助数组
        for (int i = start; i <=end ; i++) {
            helper[i]=nums[i];
        }
        //因为mid前后是排好序的，那么用两指针来做排序
        int pointer1=start;//迭代左半段数组
        int pointer2=mid+1;//迭代右半段数组
        for (int index = start; index <=end ; index++) {
            if(pointer1==mid+1)nums[index]=helper[pointer2++];
            else if(pointer2==end+1)nums[index]=helper[pointer1++];
            else if(helper[pointer1]<helper[pointer2])nums[index]=helper[pointer1++];
            else nums[index]=helper[pointer2++];
        }
    }
}
