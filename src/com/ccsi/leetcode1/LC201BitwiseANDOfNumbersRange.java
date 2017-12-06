package com.ccsi.leetcode1;

import java.util.Arrays;

/**
 * Created by gxliu on 2017/12/5.
 */
public class LC201BitwiseANDOfNumbersRange {
    //method1,用一个数组来存储整数的相应的二进制位值，从m到n的and操作可以看出，只要出现0，那么相应的&结果就是0，那么之后的整数就
    //不用没一位上都看了，只看数组里面是1的index上的相应剩下整数的位是0还是1，如果是1就将数组里面的那个变成0，以后就不用再看这个位了
    //如果全是0了就及时中断，否则就一直看下去。最后看还有哪些是1并变成相应的整数。
    public static int rangeBitWiseAnd(int m,int n){
        if(m==n)return m;
        int[] cache=new int[32];
        Arrays.fill(cache,1);

        for (int i = m ; i <=n ; i++) {
            int count=0; //看看数组里面还有几个1
            for (int j = 0; j < 32; j++) {
                if(cache[j]==1){
                    count++;
                    if(((i>>j)&1)==0){
                        cache[j]=0;
                        count--;
                    }
                }
            }
            if(count==0){
                return 0;
            }
        }
        int result=0;
        for (int i = 0; i < 32; i++) {
            if(cache[i]==1){
                result|=(1<<i);
            }
        }
        return result;
    }
    //method2，其实还有更简单的方法，其实这是有很简单的规律的：最后的数是该数字范围内所有的数的左边共同的部分。这样我们就可以用一个
    //mask来做。
    public static int rangeBitWiseAnd1(int m,int n){
        if(m==n)return m;
        int mask=Integer.MAX_VALUE;
        while((m&mask)!=(n&mask)){
            mask<<=1;
        }
        return m&mask;
    }
    //method3,原理同上，但跟简单一下，都无符号右移，直到相等，并记录移动的次数，等到相同时，再移回去。
    public static int rangeBitWiseAnd2(int m,int n){
        if(m==n)return m;
        int count=0;
        while(m!=n){
            m>>>=1;
            n>>>=1;
            count++;
        }
        m<<=count;
        return m;
    }
    public static void main(String[] args) {
        System.out.println(rangeBitWiseAnd2(1,30));
    }
}
