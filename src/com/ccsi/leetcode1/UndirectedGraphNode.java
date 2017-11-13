package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/12.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x){
        label=x;
        neighbors=new ArrayList<UndirectedGraphNode>();
    }
}
