package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/28.
 */
public class LC167TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        int[] numbers={2,5,9,13};
        int[] res=twoSum1(numbers,9);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    //method1,binary search O(NlgN)
    public static int[] twoSum(int[] numbers,int target){
        int[] result=new int[2];
        if(numbers==null||numbers.length<2)return result;

        int len=numbers.length;
        for (int i = 0; i < len-1; i++) { //一个循环，注意要给第二个元素保留一个，否则在binary search时会outofboundary. N
            int num2=target-numbers[i];
            int index2=binarySearch(numbers,num2,i+1,len-1);
            if(index2!=-1){
                result[0]=i+1;
                result[1]=index2+1;
                break;
            }
        }
        return result;
    }
    private static int binarySearch(int[] numbers,int target,int start,int end){ //lgN,记住这种写法，很重要。
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(numbers[mid]==target)return mid;
            else if(target<numbers[mid])end=mid-1;
            else start=mid+1;
        }

        if(numbers[start]==target)return start;
        else if(numbers[end]==target)return end;
        else return -1;
    }
    //method2 双指针 O(N)
    public static int[] twoSum1(int[] numbers,int target){
        int[] result=new int[2];
        if(numbers==null||numbers.length<2)return result;
        int p=0,q=numbers.length-1;
        while(p<q){
            int sum=numbers[p]+numbers[q];
            if(target==sum){
                result[0]=p+1;
                result[1]=q+1;
                break;
            }
            else if(target<sum)q--;
            else p++;
        }
        return result;
    }
}
