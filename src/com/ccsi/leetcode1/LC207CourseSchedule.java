package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/7.
 */
public class LC207CourseSchedule {
    public static void main(String[] args) {
        LC207CourseSchedule schedule=new LC207CourseSchedule();
        int[][] prerequsites={{0,1},{1,2},{2,3},{3,0}};
        System.out.println(schedule.canFinish(4,prerequsites));
    }
    private class Course implements Comparable<Course>{
        int val;
        Set<Integer> pre;  //用set容易查找，删除
        Set<Integer> dep;
        public Course(int v){
            this.val=v;
            this.pre=new HashSet<>(); //size就是进度
            this.dep=new HashSet<>(); //size就是出度
        }

        @Override
        public int compareTo(Course o) {
            return this.pre.size()-o.pre.size(); //在pq里面要用到排序，那进度从小到大排。
        }
    }

    public boolean canFinish(int numCourses,int[][] prerequisites){
        if(numCourses<0)return false;
        if(numCourses<2)return true;
        if(prerequisites==null||prerequisites.length==0||prerequisites[0].length==0)return true;

        Course[] courses=new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i]=new Course(i);   //初始化
        }

        int len=prerequisites.length;
        for (int i = 0; i < len; i++) {
            courses[prerequisites[i][0]].pre.add(prerequisites[i][1]);  //按照prerequisites数组将图（或树）建好
            courses[prerequisites[i][1]].dep.add(prerequisites[i][0]);  //主要就是将依赖关系建好
        }

        PriorityQueue<Course> pq=new PriorityQueue<>();  //将每个course存进pq，按进度大小排序。
        for (int i = 0; i < numCourses; i++) {
            pq.offer(courses[i]);
        }

        while(!pq.isEmpty()){   //查看pq
            if(pq.peek().pre.size()!=0)return false;   //如果pq里面最小的进度不是0，那么必定不能完成
            Course curr=pq.poll();  //否则将第一个进度为0的吐出来，这是可以开始学的课程
            Set<Integer> dependents=curr.dep; //将依赖与这门课的其他的课都找出来
            for(Integer num:dependents){
                courses[num].pre.remove(curr.val); //依赖与当前这门课的pre中去除当前这门课
                pq.remove(courses[num]);   //需要重新更新pq，因为这些课的进度变化了。
                pq.offer(courses[num]);
            }
        }
        return true;  //到pq为空了，说明能完成。
    }
}
