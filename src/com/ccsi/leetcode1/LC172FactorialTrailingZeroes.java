package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/29.
 */
public class LC172FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(1808548329));
    }
    //题意：阶乘末尾0的个数
    //思路：0的来源与10，而10可以分解成5*2，其中在阶乘中2的个数远多余5的个数，那么我们数出5的个数就行了。
    //需要注意的是：如25，125并非一个5，而是2个和3个。
    public static int trailingZeroes(int n){
        int count=0;
        for (int i = 1; i <= n; i++) {
            int num=i;
            while(num!=0){
                if(num%5==0){
                    count++;
                    num/=5;
                }else break;
            }
        }
        return count;
    }
    //method2 一个更简单的写法,但不好理解。这样来看：5！（1到5）里面只有一个5；10！（1到10）里面有一个5和一个10（共2个5）；
    //15！（1到15）里面有一个5，一个10和一个15（共3个5）...,如此类推下去，n的阶乘里面就是有（n/5）个5。但是，还有写不止一个5
    // 的情况，比如25，125，他们里面分别有2个5和3个5，那么只是就要特殊处理。如28！里面有28/5==5个5之外，还有另外一个，处理方法
    //就是28/25得到另一个5.再如125时，125/5==25个五，125/25得到另外5个五，125/125再得到另外一个五，共31个5.
    //这个写法通不过测试，输入1808548329输出452137078，应该是452137076。
    public static int trailingZeroes1(int n){
        int den=5;
        int count=0;
        while(n>=den){
            count+=n/den;
            den*=5;
        }
        return count;
    }
    //下面写法就可以。
    public static int trailingZeroes2(int n){
        int count=0;
        while(n>0){
            count+=n/5;
            n/=5;
        }
        return count;
    }
}
