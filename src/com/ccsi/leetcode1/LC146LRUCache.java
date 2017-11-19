package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/17.
 */
public class LC146LRUCache {
    //利用一个双向链表来做。
    private class Entry {
        int key;
        int value;
        Entry pre;
        Entry next;
        public Entry(int key, int value){
            this.key=key;
            this.value=value;
            this.pre=null;
            this.next=null;
        }
    }

    private Map<Integer,Entry> map;
    private Entry head;
    private Entry tail;
    private int capacity;
    private int count;

    public LC146LRUCache(int capacity){
        this.map=new HashMap<>();
        this.head=null;
        this.tail=null;
        this.capacity=capacity;
        this.count=0;
    }

    public int get(int key){
        if(!map.containsKey(key))return -1;
        Entry temp=map.get(key);
        if(count==1||tail.key==key)return temp.value; //只有一个entry的情况下，或者在链表的末尾，直接返回，不用处理。
        //否则，如果是链表头，由于上面的判断，可以保证这个head.next肯定不为空，
        if(head.key==key){  //在表头的情况下
            head=head.next;
            head.pre=null;
        }else{             //在表中的情况下
            temp.pre.next=temp.next;
            temp.next.pre=temp.pre;
        }

        tail.next=temp;    //将这个被查找的entry接到表尾去
        temp.pre=tail;
        temp.next=null;

        tail=temp;
        return temp.value;
    }

    public void put(int key,int value){
        if(map.containsKey(key)){   //表包含这个key的情况下，也要考虑是1一个entry，表头，表尾，表中的情况。
            Entry temp=map.get(key);
            if(count==1){
                map.remove(key);
                temp.value=value;
                map.put(key,temp);
                return;
            }

            if(tail.key==key){   //表尾
                tail=temp.pre;
                tail.next=null;
            }else if(head.key==key){  //表头
                head=temp.next;
                head.pre=null;
            }else{                    //表中
                temp.pre.next=temp.next;
                temp.next.pre=temp.pre;
            }

            map.remove(key);
            count--;
        }else{                 //不在表里的情况下
            if(count==capacity){   //如果已经是最大长度了，那要将表头取出来，并删除，也要考虑如果只有一个元素的情况
                map.remove(head.key);
                if(count==1){
                    head=null;
                    tail=null;
                }else{
                    head=head.next;
                    head.pre=null;
                }
                count--;
            }
        }

        Entry curr=new Entry(key,value);  //将新entry加到表尾去，同时要考虑这个表是否为空。
        if(head==null){
            head=curr;
            tail=curr;
        }else{
            tail.next=curr;
            curr.pre=tail;
            curr.next=null;
            tail=tail.next;
        }

        count++;
        map.put(key,curr);
    }

    public static void main(String[] args) {
        LC146LRUCache cache=new LC146LRUCache(2);
        cache.put(2,1);
        cache.put(3,2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4,3);
        //cache.put(4,1);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
