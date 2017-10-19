package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/18.
 */
public class LC096UniqueBinarySearchTrees {
    public static void main(String[] args) {
        System.out.println(numTrees(1));
    }
    //DP,找规律，n个节点的BST,每一个数都有可能做跟节点，那么用一个循环对其迭代，从1到n，比如1为根节点，那么其左子树是空的，
    //其右子树有n-1个节点；2为根节点时，其左子树有1个节点，右子树有n-2个节点；3为跟节点时，左子树有2个节点，右子树为n-3个节点
    //。。。一直到n，这是去左子树有n-1个节点，右子树为空。
    //当i为根节点时，左子树有i-1个节点，右子树有n-i个节点，其BST的个数就是f（i-1）*f（n-i）；每一个左子树的组合都可以和右子树的
    //每一个组合进行匹配。
    //那么递推公式总结为 f(n)=f(0)*f(n-1)+f(1)*f(n-2)+f(2)*f(n-3)+...+f(n-2)*f(1)+f(n-1)*f(0);
    //初始化，f(0)=1,f(1)=1;
    //找合适的循环递推计算f（n）
    public static int numTrees(int n){
        if(n<1)return 0;
        int[] cache=new int[n+1];
        cache[0]=1;
        cache[1]=1;
        for (int i = 2; i <=n; i++) {
            for (int j = 0; j < i; j++) {
                cache[i]+=cache[j]*cache[i-1-j];
            }
        }
        return cache[n];
    }
}
