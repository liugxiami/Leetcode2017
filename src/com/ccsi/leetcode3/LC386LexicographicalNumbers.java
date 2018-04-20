package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/4/18.
 */
public class LC386LexicographicalNumbers {
    //自己一开始写的解法，感觉挺好的，递推，但其实不对，这并不是字典顺序，字典顺序是
    // 如1,10,100..，11，110..在2的前面，可以将1到n的数转换成string，然后写一个comparator来
    //排序，但过不了test
    public static List<Integer> lexicalOrder(int n){
        List<Integer> result=new ArrayList<>();
        if(n<1)return result;
        boolean finished=false;
        for (int initial = 1; initial < 10&&!finished; initial++) {
            result.add(initial);
            int index=result.size()-1;
            int curr=initial;
            while(curr<n&&!finished){
                for (int i = 0; i < 10&&!finished; i++) {
                    curr=result.get(index)*10+i;
                    if(curr<=n)result.add(curr);
                    finished=(result.size()==n);
                }
                index++;
            }
        }
        return result;
    }
    public static List<Integer> lexicalOrder1(int n){
        List<Integer> result=new ArrayList<>();
        if(n<1)return result;
        int curr=1;
        for (int i = 0; i < n; i++) {
            result.add(curr);
            if(curr*10<=n){
                curr*=10;
            }else if(curr%10!=9&&curr+1<=n){
                curr++;
            }else{
                while((curr/10)%10==9){
                    curr/=10;
                }
                curr=curr/10+1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> res=lexicalOrder1(139);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
