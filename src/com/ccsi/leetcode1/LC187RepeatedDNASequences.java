package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/2.
 */
public class LC187RepeatedDNASequences {
    public static void main(String[] args) {
        String s="AAAAAAAAAAA";
        List<String> res=findRepeatedDnaSequences(s);
        res.forEach(x-> System.out.println(x));
    }
    //开始的思路就是用一个map<String，Integer>来做，每往后移动一位，就subString（start，start+10）做key，value为次数，那么从
    //到尾迭代一遍，就能找到哪些是重复的了，如果这个DNA非常长，那么就需要消耗大量的内存，过不了leetcode的test。解决方法是：
    //DNA中只有A,T,C,G,我们可以用0，1，2，3表示，二进制上为00，01，10，11，那么10个字符就只要20bits就足够了，也就是一个integer的
    //数字就可以表示了。那么我们将10个字符hashcode成一个Integer类型的数字，用一个map<Integer,Integer>就可以来记录每个10字符的DNA的
    //出现次数了，这里可以更简单一下，这里是只要有重复就算，那么用两个set来做就好了，一个set来记录出现过的10字符长的字符串，另一个set用
    //来存储重复出现过的，将重复出现过的在解码回字符串就好了。
    public static List<String> findRepeatedDnaSequences(String s){
        List<String> result=new ArrayList<>();
        if(s==null||s.length()<10)return result;
        int len=s.length();

        Map<Character,Integer> mapCtoI=new HashMap<>(); //为方便将sequences转为hashcode
        mapCtoI.put('A',0);
        mapCtoI.put('C',1);
        mapCtoI.put('G',2);
        mapCtoI.put('T',3);

        Map<Integer,Character> mapItoC=new HashMap<>(); //为方便将hashcode转为字符串
        mapItoC.put(0,'A');
        mapItoC.put(1,'C');
        mapItoC.put(2,'G');
        mapItoC.put(3,'T');

        Set<Integer> total=new HashSet<>(); //用来存储出现过的所有的10-letter-long sequences
        Set<Integer> repeat=new HashSet<>(); //用来存储重复出现过的10-letter-long sequences

        int temp=0;
        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if(i<9){     //前10位字符尽管往里添加。
                temp<<=2; //向左移动两位
                temp|=mapCtoI.get(c); //将当前的这个字符对应的数字加进temp里面去。
            }else{        //超过10位之后要开始处理
                temp<<=2;   //这个temp往左移动两位
                temp|=mapCtoI.get(c);//将当前这个字符对应的数字加进temp里面去。一直重复

                int curr=temp&((1<<20)-1); //将temp里面的二进制位后20位的过滤出来，这就是i-10到i位的字符串的hashcode。
                //下面要做点事
                if(!total.contains(curr)){ //如果total里面没出现过，就往里加
                    total.add(curr);
                }else{  //否则这就是重复重现过的
                    if(repeat.contains(curr))continue; //先看在重复出现过的set里面有没有这个字符串，如果有，说明处理过了，跳过。
                    repeat.add(curr);  //否则就加进repeat里面去，接着进行解码
                    StringBuilder sb=new StringBuilder();
                    for (int j = 0; j < 10; j++) {  //解码过程和hashcode过程相反。
                        int num=curr&3;  //先获取最右边两位
                        curr>>=2; //如果往右边移动两位
                        char cc=mapItoC.get(num); //将这获得的最右边两位的数字转成字母，并加进sb里面去
                        sb.append(cc);
                    }
                    result.add(sb.reverse().toString()); //解码完了逆转一下并装成string，加到结果集去。
                }
            }
        }
        return result;
    }
}
