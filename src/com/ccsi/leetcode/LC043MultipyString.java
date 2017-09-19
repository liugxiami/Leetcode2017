package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/15.
 */
public class LC043MultipyString {
    public static String multiply(String num1,String num2){
        String result=helper(num1,num2);
//        int index=0;
//        while(index<result.length()&&result.charAt(index)=='0'){
//            index++;
//        }
//
//        result=result.substring(index);
//        result=result.length()==0?"0":result;
        return result;
    }

    private static String helper(String num1,String num2){
        int len=Math.max(num1.length(),num2.length());

        if(len<=4){   //<4就不行
            return String.format("%d",Integer.parseInt(num1)*Integer.parseInt(num2));
        }

        String result="";

        num1=formatString(num1,len);
        num2=formatString(num2,len);

        int len1=len/2;
        int len2=len-len1;

        String A=num1.substring(0,len1);
        String B=num1.substring(len1);
        String C=num2.substring(0,len1);
        String D=num2.substring(len1);

        String AC=helper(A,C);
        String AD=helper(A,D);
        String BC=helper(B,C);
        String BD=helper(B,D);

        String ADBC=bigSum(AD,BC);

        if(BD.length()>len2){
            ADBC=bigSum(ADBC,BD.substring(0,BD.length()-len2));
            BD=BD.substring(BD.length()-len2);
        }

        if(ADBC.length()>len2){
            AC=bigSum(AC,ADBC.substring(0,ADBC.length()-len2));
            ADBC=ADBC.substring(ADBC.length()-len2);
        }

        result=AC+ADBC+BD;
        //  上面这个算法在num1和num2的位数相似的情况下没问题，但如果一个是很长，一个很短，就会出错，因为补上0之后，在某些情况下ADBC和BD
        //  有可能为0，那么它们的length-len2就有问题。

//        int AClen=len2*2;
//        StringBuilder ACtotal=new StringBuilder();
//        ACtotal.append(AC);
//        while(AClen-->0){
//            ACtotal.append(0);
//        }
//
//        int ADBClen=len2;
//        StringBuilder ADBCtotal=new StringBuilder();
//        ADBCtotal.append(ADBC);
//        while(ADBClen-->0){
//            ADBCtotal.append(0);
//        }
//
//        result=bigSum(BD,ADBCtotal.toString());
//        result=bigSum(result,ACtotal.toString());
        return result;

    }

    private static String formatString(String str,int len){
        int delta=len-str.length();
        StringBuilder newStr=new StringBuilder();
        while(delta-->0){
            newStr.append(0);
        }
        newStr.append(str);
        return newStr.toString();
    }

    private static String bigSum(String num1,String num2){
        int len=Math.max(num1.length(),num2.length());
        num1=formatString(num1,len);
        num2=formatString(num2,len);

        StringBuilder str=new StringBuilder();
        int flag=0;
        for (int i = len-1; i >=0; i--) {
            int temp=num1.charAt(i)-'0'+num2.charAt(i)-'0'+flag;
            flag=temp/10;
            temp%=10;
            str.append(temp);
        }
        if(flag==1){
            str.append(1);
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        String num1="1";
        String num2="5566668";
        System.out.println(multiply(num1,num2));
    }
}
