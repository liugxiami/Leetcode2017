package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/8.
 * 和前面courseSchedule一模一样的算法，只不过是这次是记录课程顺序。
 */
public class LC210CourseScheduleII {
    private class Course implements Comparable<Course>{
        int val;
        Set<Integer> pre;
        Set<Integer> dep;

        public Course(int v){
            this.val=v;
            this.pre=new HashSet<>();
            this.dep=new HashSet<>();
        }

        @Override
        public int compareTo(Course o){
            return this.pre.size()-o.pre.size();
        }

    }
    public int[] findOrder(int numCourses,int[][] prerequisites){
        if(numCourses<1)return new int[]{}; //返回一个empty array
        int[] result=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]=i;  //将result初始化为课程
        }
        if(prerequisites.length==0||prerequisites[0].length==0) return result;//前面几次提交出错都是因为这些先决判断。

        Course[] courses=new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i]=new Course(i);
        }

        int len=prerequisites.length;
        for (int i = 0; i < len; i++) {
            courses[prerequisites[i][0]].pre.add(prerequisites[i][1]);
            courses[prerequisites[i][1]].dep.add(prerequisites[i][0]);
        }

        PriorityQueue<Course> pq=new PriorityQueue<>();
        for (int i = 0; i < numCourses; i++) {
            pq.offer(courses[i]);
        }

        int index=0;
        while(!pq.isEmpty()&&index<numCourses){
            if(pq.peek().pre.size()!=0)return new int[]{};
            Course curr=pq.poll();
            result[index++]=curr.val;
            for (Integer num:curr.dep) {
                courses[num].pre.remove(curr.val);
                pq.remove(courses[num]);
                pq.offer(courses[num]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC210CourseScheduleII schedule=new LC210CourseScheduleII();
        int[][] pre={{1,0},{2,0},{3,1},{3,2}};
        int[] result=schedule.findOrder(4,pre);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
