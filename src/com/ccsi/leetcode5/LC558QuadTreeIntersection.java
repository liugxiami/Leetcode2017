package com.ccsi.leetcode5;

public class LC558QuadTreeIntersection {
    public static QuadTreeNode intersect(QuadTreeNode quadTree1,QuadTreeNode quadTree2){
        if(quadTree1.isLeaf)return quadTree1.val?quadTree1:quadTree2;
        if(quadTree2.isLeaf)return quadTree2.val?quadTree2:quadTree1;

        QuadTreeNode tl=intersect(quadTree1.topLeft,quadTree2.topLeft);
        QuadTreeNode tr=intersect(quadTree1.topRight,quadTree2.topRight);
        QuadTreeNode bl=intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
        QuadTreeNode br=intersect(quadTree1.bottomRight,quadTree2.bottomRight);

        if(tl.isLeaf&&tr.isLeaf&&bl.isLeaf&&br.isLeaf&&
                ((tl.val&&tr.val&&bl.val&&br.val)||(!tl.val&&!tr.val&&!bl.val&&!br.val))){
            return new QuadTreeNode(tl.val,true,null,null,null,null);
        }else return new QuadTreeNode(false,false,tl,tr,bl,br);
    }
}
