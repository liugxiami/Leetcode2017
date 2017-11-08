package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/7.
 */
public class LC130SurroundedRegions {
    //method1 union-find
    public static void main(String[] args) {
        char[][] board={
                {'x','x','x','x'},
                {'x','o','o','x'},
                {'x','x','o','x'},
                {'x','o','x','x'}
        };
        solve(board);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col]+" ");
            }
            System.out.println();
        }
    }
    private static class Element{
        int value;
        int parent;
        boolean canFlip;

        public Element(int value, int parent) {
            this.value = value;
            this.parent = parent;
            this.canFlip = true;
        }
    }
    private static Map<Integer,Element> elements=new HashMap<>();

    public static void solve(char[][] board){
        if(board==null||board.length==0||board[0].length==0)return;
        makeSet(board);
        int rowNum=board.length;
        int colNum=board[0].length;
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if(row+1<rowNum&&board[row][col]=='o'&&board[row+1][col]=='o'){
                    union(row*colNum+col,(row+1)*colNum+col);
                }
                if(col+1<colNum&&board[row][col]=='o'&&board[row][col+1]=='o'){
                    union(row*colNum+col,row*colNum+col+1);
                }
            }
        }
        Map<Integer,List<Integer>> map=getSet();
        for(Integer num:map.keySet()){
            Element curr=elements.get(num);
            if(curr.canFlip){
                List<Integer> list=map.get(num);
                for(Integer temp:list){
                    int row=temp/colNum;
                    int col=temp%colNum;
                    board[row][col]='x';
                }
            }
        }
    }
    private static Map<Integer,List<Integer>> getSet(){
        Map<Integer,List<Integer>> res=new HashMap<>();
        for(Integer value:elements.keySet()){
            int parent_name=find(value);
            if(res.containsKey(parent_name)){
                res.get(parent_name).add(value);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(value);
                res.put(parent_name,list);
            }
        }
        return res;
    }
    private static void makeSet(char[][] board){
        int rowNum=board.length;
        int colNum=board[0].length;
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                int curr=row*colNum+col;
                Element element=new Element(curr,curr);
                if(row==0||col==0||row==rowNum-1||col==colNum-1){
                    element.canFlip=false;
                }
                elements.put(curr,element);
            }
        }
    }
    private static void union(int num1,int num2){
        int parent1_name=find(num1);
        int parent2_name=find(num2);
        if(parent1_name==parent2_name)return;
        Element parent1=elements.get(parent1_name);
        Element parent2=elements.get(parent2_name);
        parent1.parent=parent2_name;
        if(!parent1.canFlip)parent2.canFlip=false;
        if(!parent2.canFlip)parent1.canFlip=false;
    }

    private static int find(int num){
        Element curr=elements.get(num);
        while(true){
            int parent_name=curr.parent;
            Element parent=elements.get(parent_name);
            if(!curr.canFlip)parent.canFlip=false;

            if(parent_name==curr.value)return parent_name;
            curr=elements.get(parent_name);
        }
    }
}
