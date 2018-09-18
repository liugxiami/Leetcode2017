package com.ccsi.leetcode4;

public class LC470ImplementRand10UsingRand7 extends SolBase {
    public static void main(String[] args) {
        LC470ImplementRand10UsingRand7 r10=new LC470ImplementRand10UsingRand7();
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
    }
    /*
    7*（Rand7() - 1） = {0， 7， 14， 21， 28， 35， 42}，这7个数等概率
    7*（Rand7() - 1） + Rand() - 1表示{0,1,2,3,4,5,6,......40, ... 48}，这49个数等概率
    还要排除40到48这几个数，如果在里面，就会让9的几率变得不公平了。
    注意：其结果是1到10的几率，也就是说0到9的分别加1.
     */
    public int rand10(){
        int result=0;
        while(true){
            result=(rand7()-1)*7+rand7()-1;
            if(result<40)return result%10+1; //不能等于40，result的范围是0到39，这样0到9的几率就相同了
        }
    }
}
