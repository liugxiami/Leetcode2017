package com.ccsi.leetcode4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by gxliu on 2018/5/18.
 * 本题是Trapping Rain Water的follow up，I中是循环两遍记录每个位置左右两侧的最高水柱，而II在二维的灌水情境中，
 * 则需要从外围向内包围查找，记录最小的柱高，也就是木桶原理，最矮的柱子决定了灌水的高度。
 *
 *      1.从最外围一圈向内部遍历，记录包围“墙”的最小柱高，可以利用min-heap（PriorityQueue）
 *      2.记录遍历过的点visited[][]
 *      3.对于min-heap的堆顶元素，假设高度h，查找其周围4个方向上未曾访问过的点
 *          。如果比h高，则说明不能装水，但是提高了“围墙”最低高度，因此将其加入min-heap中，设置元素被访问
 *          。如果比h矮，则说明可以向其中灌水，且灌水高度就是h - h'，其中h'是当前访问的柱子高度，同样的，
 *          要将其加入min heap中，（且该元素高度记为灌水后的高度，也就是h，可以设想为一个虚拟的水位高度），
 *          设置元素被访问
 * 此外，为了方便，可以定义一个Cell类，包含其坐标x,y，以及高度h，并定义其Comparator规则（
 *          也可以在初始化PriorityQueue的时候定义）。
 */
public class LC407TrappingRainWaterII {
    public static void main(String[] args) {
        int[][] heights={{1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}};
        LC407TrappingRainWaterII r=new LC407TrappingRainWaterII();

        System.out.println(r.trapTainWater(heights));
    }
    //面向对象，声明一个类来保存坐标及height
    private class Cell{
        int row;
        int col;
        int height;
        public Cell(int r,int c,int h){
            this.row=r;
            this.col=c;
            this.height=h;
        }
    }
    //BFS的特殊利用
    public int trapTainWater(int[][] heightMap){
        if(heightMap==null||heightMap.length==0||heightMap[0].length==0)return 0;
        int rowNum=heightMap.length;
        int colNum=heightMap[0].length;
        int result=0;
        //这里不是用一般的queue，而是mini-heap，小的先弹出
        PriorityQueue<Cell> queue=new PriorityQueue<>(1, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.height-o2.height;
            }
        });
        //需要一个数组来标记是否已经访问过了
        boolean[][] visited=new boolean[rowNum][colNum];
        //四周的肯定不能保存水，相当于围墙，那么将四周入queue
        for (int row = 0; row < rowNum; row++) {
            queue.offer(new Cell(row,0,heightMap[row][0]));
            queue.offer(new Cell(row,colNum-1,heightMap[row][colNum-1]));
            visited[row][0]=true;
            visited[row][colNum-1]=true;
        }

        for (int col = 0; col < colNum; col++) {
            queue.offer(new Cell(0,col,heightMap[0][col]));
            queue.offer(new Cell(rowNum-1,col,heightMap[rowNum-1][col]));
            visited[0][col]=true;
            visited[rowNum-1][col]=true;
        }

        int[] x={0,0,-1,1};
        int[] y={-1,1,0,0};
        //进行BFS
        while(!queue.isEmpty()){
            Cell curr=queue.poll(); //四周的肯定不能保存水，相当于围墙，那么将四周入queue
            for (int i = 0; i < 4; i++) { //对四周进行迭代
                int row=curr.row+x[i];
                int col=curr.col+y[i];
                if(row>=0&&row<rowNum&&col>=0&&col<colNum&&!visited[row][col]){
                    //如果碰到没访问过的，又是里面的，那么就入queue，需要注意的是这个高度取当前高度与新访问的
                    //的高度较高的那个。
                    queue.offer(new Cell(row,col,Math.max(curr.height,heightMap[row][col])));
                    visited[row][col]=true; //入queue之后标记一下
                    int delta=curr.height-heightMap[row][col]; //计算高度查
                    result+=delta>0?delta:0;//如果新的低就加到结果中去，否则就加0.
                }
            }
        }
        return result;
    }
}
