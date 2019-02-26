package com.ccsi.leetcode5;

public class LC592FractionAdditionAndSubtraction {
    public static void main(String[] args) {
        System.out.println(fractionAddition("1/3-1/2"));
    }
    public static String fractionAddition(String expression){
        String[] strings=expression.split("(?=[+-])");// The (?=) part is a zero-width positive lookahead.
        // Since [-,+] means - or +, the regex (?=[-,+]) means the next element is either - or +.
        //Thus, expression.split("(?=[-,+])") is to split expression at the positions whose next element is
        // either - or +. For example, when expression = "-1/2+1/2-1/3",
        // expression.split("(?=[-,+])") generates an array of strings ["-1/2","+1/2", "-1/3"].
        int[] numerators=new int[strings.length];
        int[] denominators=new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            numerators[i]=Integer.parseInt(strings[i].split("/")[0]);
            denominators[i]=Integer.parseInt(strings[i].split("/")[1]);
        }
        long numerator=0;
        long denominator=1;
        for (int i = 0; i < strings.length; i++) {
            numerator=numerator*denominators[i]+numerators[i]*denominator;
            denominator*=denominators[i];
            long gcd=gcd(numerator,denominator);
            numerator/=gcd;
            denominator/=gcd;
        }
        int sign=1;
        if(numerator<0){
            sign*=-1;
            numerator=-numerator;
        }
        if(denominator<0){
            sign*=-1;
            denominator=-denominator;
        }
        return (sign==-1?"-":"") + numerator+"/"+denominator;
    }
    private static long gcd(long x,long y){//求最大公约数
        if(y==0)return x;
        return gcd(y,x%y);
    }
}
