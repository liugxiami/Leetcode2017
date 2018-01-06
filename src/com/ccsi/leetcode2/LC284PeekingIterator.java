package com.ccsi.leetcode2;

import java.util.Iterator;

/**
 * Created by gxliu on 2018/1/5.
 */
public class LC284PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer next;

    public LC284PeekingIterator(Iterator<Integer> iterator){
        this.iterator=iterator;
        if(iterator.hasNext()){
            this.next=iterator.next();
        }
    }
    public Integer peek(){
        return next;
    }

    @Override
    public boolean hasNext() {
        return next!=null;
    }

    @Override
    public Integer next() {
        int res=next;
        next=iterator.hasNext()?iterator.next():null;
        return res;
    }
}
