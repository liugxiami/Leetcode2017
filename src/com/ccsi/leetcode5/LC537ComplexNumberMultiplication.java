package com.ccsi.leetcode5;

public class LC537ComplexNumberMultiplication {
    public static void main(String[] args) {
        String a="1+1i";
        String b="1+1i";
        System.out.println(complexNumberMultiply1(a,b));
    }
    //method 1不够简洁，用的是String.split（）；
    public static String complexNumberMultiply(String a,String b){
        int[] firstComplex=decode(a);
        int[] secondComplex=decode(b);
        int a1=firstComplex[0];
        int a2=firstComplex[1];
        int b1=secondComplex[0];
        int b2=secondComplex[1];
        int c=a1*b1-a2*b2;
        int d=a1*b2+a2*b1;
        String result=String.format("%d+%di",c,d);
        return result;
    }
    private static int[] decode(String str){
        String[] strings=str.split("\\+");
        int sign=1;
        int first=0;
        for (int i = 0; i < strings[0].length(); i++) {
            if(i==0&&strings[0].charAt(0)=='-')sign=-1;
            else{
                first=first*10+strings[0].charAt(i)-'0';
            }
        }
        first*=sign;

        sign=1;
        int second=0;
        for (int i = 0; i < strings[1].length()-1; i++) {
            if(i==0&&strings[1].charAt(0)=='-')sign=-1;
            else{
                second=second*10+strings[1].charAt(i)-'0';
            }
        }
        second*=sign;
        int[] result=new int[]{first,second};
        return result;
    }
    //method 2 a.substring(startIndex,endIndex);
    public static String complexNumberMultiply1(String a,String b){
        int a1=Integer.parseInt(a.substring(0,a.indexOf('+')));
        int a2=Integer.parseInt(a.substring(a.indexOf('+')+1,a.length()-1));

        int b1=Integer.parseInt(b.substring(0,b.indexOf('+')));
        int b2=Integer.parseInt(b.substring(b.indexOf('+')+1,b.length()-1));

        return (a1*b1-a2*b2)+"+"+(a1*b2+a2*b1)+"i";
    }
}
