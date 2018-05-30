package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/5/23.
 */
public class LC414ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums={3,2,2};
        System.out.println(thirdMax1(nums));
    }
    public static int thirdMax(int[] nums){
        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        int third=Integer.MIN_VALUE;
        int count=0; //用来计数个数
        boolean hasFoundMin=false;
        for(Integer curr:nums){
            if(count<3&&curr==Integer.MIN_VALUE&&!hasFoundMin){
                count++;
                hasFoundMin=true;
            }else if(curr==first||curr==second||curr==third)continue; //不考虑第三个数，是为了排除可能的这个最小数就是Integer.MIN_VALUE;

            if(curr>first){ //大于第一个数时，连续更新
                third=second;
                second=first;
                first=curr;
                count++;
            }else{
                if(curr>second){ //大于第二个数时，更新第二第三个数
                    third=second;
                    second=curr;
                    count++;
                }else {
                    if(curr>third){ //大于第三个数时，更新第三个数.
                        third=curr;
                        count++;
                    }
                }
            }
        }

        return count<3?first:third;
    }
    //method2
    public static int thirdMax1(int[] nums){
        long first=Long.MIN_VALUE;
        long second=Long.MIN_VALUE;
        long third=Long.MIN_VALUE;

        for(int curr:nums){
            if(curr>first){
                third=second;
                second=first;
                first=curr;
            }else if(curr<first&&curr>second){
                third=second;
                second=curr;
            }else if(curr<second&&curr>third){
                third=curr;
            }
        }

        return third==Long.MIN_VALUE?(int)first:(int)third;
    }
}
