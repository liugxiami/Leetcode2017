package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/12/12.
 */
public class LC214ShortestPalindrome {
    public static void main(String[] args) {
        String s="aaaaa";
        System.out.println(shortestPalindrome(s));
    }
    public static String shortestPalindrome(String s){
        if(s==null||s.length()<=1)return s;
        int len=s.length();
        String str=""; //这里用“”，而不是null。但必须初始化。
        for (int i = (len-1)/2; i >=0 ; i--) {
            //这里的要考虑palindrome的字符数是奇数还是偶数，也就是最中心是但个字符还是两相同的字符。
            //中心的计算方法是start+(end-start)/2,保证是中点或中点往前偏移一位。
            if(s.charAt(i)==s.charAt(i+1)){ //中轴点与其边上相同的情况下也可能是奇数对称的，比如“aaaaa”。
                String str1=palindrome(s,i,i+1);
                String str2=palindrome(s,i,i);
                if(str1.equals(""))str=str2;
                else if(str2.equals(""))str=str1;
                else {
                    str=str1.length()<str2.length()?str1:str2;
                }

            }else str=palindrome(s,i,i);//但与其不相同的话，就肯定是奇数对称的。和前面相同并偶数的对称的情况可以通过
            //主函数的往前循环来弥补。

            if(!str.equals(""))break;
        }
        return str;
    }
    private static String palindrome(String s,int p,int q){
        StringBuilder res=new StringBuilder();
        while(p>=0&&q<s.length()&&s.charAt(p)==s.charAt(q)){
            p--;
            q++;
        }
        //因为p是s的中点往前移，所以只有可能p到头的情况，q最大也就到结尾，不会移出去。
        //只有当p移出去了，那从传入点往两边是palindrome。
        int len=s.length();
        if(p==-1){
            for (int i = len-1; i >=q ; i--) {
                res.append(s.charAt(i));
            }
            res.append(s);
        }
        return res.toString(); //如果是空的，其返回的是“”，而不是null。记住这一点。
    }
}
