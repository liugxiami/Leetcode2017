package com.ccsi.leetcode4;

public class LC466CountTheRepetitions {
    public static void main(String[] args) {
        String s1="aaa";
        String s2="aaaaa";
        int n1=20;
        int n2=1;
        System.out.println(getMaxRepetitions1(s1,n1,s2,n2));
    }
    //method1 在S1中找出s2的repeat次数（repeat_count），最后将repeat_count/n2就可以了，但超时。注意前面一直做错，
    //是因为想直接就数S2的repeat次数，或者是在s1中找到s2的repeat次数，有缺陷
    public static int getMaxRepetitions(String s1,int n1,String s2,int n2){
        if(s1==null||s1.length()==0||s2==null||s2.length()==0)return 0;
        int index=0;
        int repeat_count=0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < s1.length(); j++) {
                if(s1.charAt(j)==s2.charAt(index)){
                    index++;
                }
                if(index==s2.length()){
                    index=0;
                    repeat_count++;
                }
            }
        }
        return repeat_count/n2;
    }
    //改进brute force,因为S1和S2都是有s1和s2的重复组成，那么其中必定会有pattern出现，那么这里最重要的就是先找出规律，
    //难点就在找规律，参考了网上的讨论，我们借用两个数组，分别存储s2在s1 block上的index和到目前block前出现过的重复次数
    //之后分别算出出现pattern前的repeat次数，在pattern中出现的次数，已经pattern之后可能出现的次数。代码如下
    public static int getMaxRepetitions1(String s1,int n1,String s2,int n2){
        if(n1==0)return 0;
        int[] indexr=new int[s2.length()+1];//index of s2 at start of each s1 block
        int[] countr=new int[s2.length()+1];//count of repetitions till the present s1 block
        int index=0;
        int repeat_count=0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < s1.length(); j++) { //这对循环可以迭代S1的所有字符，但因为有pattern的出现，因此有
                //可能中途中断，因而加速。
                //找repeat
                if(s1.charAt(j)==s2.charAt(index))index++; //只有相同是s2的index才会自增
                if(index==s2.length()){  //如果到s2的头了，那么归零，并且count自增
                    index=0;
                    repeat_count++;
                }
            }
            indexr[i]=index;
            countr[i]=repeat_count;
            for (int k = 0; k < i; k++) {
                if(indexr[k]==index){
                    int pre_count=countr[k];
                    int pattern_count=(countr[i]-countr[k])*((n1-1-k)/(i-k));//注意这边的括号，先算后面的。
                    int remain_count=countr[k+(n1-1-k)%(i-k)]-countr[k]; //还没理解为什么这么算
                    return (pre_count+pattern_count+remain_count)/n2;
                }
            }
        }
        return countr[n1-1]/n2;
    }
}
