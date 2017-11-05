package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/1.
 */
public class LC126WordLadderII {
    public static void main(String[] args) {
        String begin="hit";
        String end="cog";
        List<String> wordList=new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        //String begin="cet";
        //String end="ism";
        //List<String> wordList=new ArrayList<>(Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"));
        List<List<String>> res=findLadders2(begin,end,wordList);
        for (int i = 0; i < res.size(); i++) {
            res.get(i).forEach(s-> System.out.print(s+" "));
            System.out.println();
        }
    }
    //method1：DFS recursive+循环，类似于八皇后和数独的哪些题.可以计算出结果，但是超时。
    private static int subListsize=Integer.MAX_VALUE; //用来记录最短的转换次数
    public static List<List<String>> findLadders(String beginWord,String endWord,List<String> wordList){
        List<List<String>> result=new ArrayList<>();
        if(wordList.isEmpty())return result;
        List<String> list=new ArrayList<>();
        list.add(beginWord); //将beginWord先存到list里面去。

        find(result,list,endWord,wordList); //因为list已经存了beginWord，所以在这里可以省一个形参
        return result;
    }
    private static void find(List<List<String>> result,List<String> list,String endWord,List<String> wordList){
        if(canTransform(endWord,list.get(list.size()-1))){  //碰到可以和endWord进行转换的词
            list.add(endWord);  //将endWord加进去
            if(list.size()<subListsize) {    //看看当前的list是否比存在result里面的lists短，如果更短
                subListsize = list.size();   //就更新当前最短长度
                result.clear();              //清空result里面的内容
                result.add(new ArrayList<>(list)); //将新的这个更短的list加进结果集。
            }else if(list.size()==subListsize){
                result.add(new ArrayList<>(list)); //如果和结果集里面的路径长度一样，就直接添加进去。
            }
            list.remove(endWord);  //做完事了，将最后的这个endWord去除。
            return;
        }

        String pre=list.get(list.size()-1);
        for (String curr:wordList) {     //recursive+循环的经典写法
            if(!list.contains(curr)&&canTransform(pre,curr)){ //如果这个string没有被访问，并且可以和list里面的最后
                // 一个单词进行转换，那么就
                list.add(curr);

                find(result,list,endWord,wordList);

                list.remove(list.size()-1);
            }
        }
    }
    private static boolean canTransform(String first,String second){
        if(first.length()!=second.length())return false;
        first=first.toLowerCase();
        second=second.toLowerCase();

        int count=0;
        for (int i = 0; i < first.length(); i++) {
            if(first.charAt(i)!=second.charAt(i))count++;
        }

        return count==1;
    }

    //method2 建图，找BFS找最短路径。超时
    private static Map<String,List<String>> map=new HashMap<>(); //建一个用Map表示的graph，其key为string，value
    //为该string的children，也就是可以由这个string通过一次转换得到的strings。

    public static List<List<String>> findLadders1(String beginWord,String endWord,List<String> wordList){
        List<List<String>> result=new ArrayList<>();
        if(wordList.isEmpty())return result;
        buildMap(beginWord,wordList); //先建图
        result=BFS(beginWord,endWord); //对该图进行BFS找到最短路径
        return result;
    }
    private static void buildMap(String beginWord,List<String> wordList){ //建图，两个循环就好了
        map.put(beginWord,new ArrayList<>());
        for (String str:wordList) {                //这里的途径是先建好框架
            map.put(str,new ArrayList<>());
            if(canTransform(beginWord,str)){
                map.get(beginWord).add(str);
            }
        }
        for (String dad:wordList) {                //将children加进去。
            for (String son:wordList) {
                if(canTransform(dad,son)&&!map.get(dad).contains(son)){ //检查是否会重复加进去，比如beginWord再次出现在wordList
                    map.get(dad).add(son);
                }
            }
        }
    }
    //利用双queue的方法找最短路径。
    private static List<List<String>> BFS(String beginWord,String endWord){
        List<List<String>> result=new ArrayList<>();  //结果集
        List<String> path=new ArrayList<>();          //起始路径，从beginWord开始
        path.add(beginWord);

        Queue<List<String>> pathQ=new LinkedList<>();
        pathQ.offer(path);                             //起始路径进queue

        while(!pathQ.isEmpty()){                        //双queue的经典方法
            Queue<List<String>> next=new LinkedList<>(); //内层queue
            while(!pathQ.isEmpty()){
                List<String> tempPath=pathQ.poll();
                String curr=tempPath.get(tempPath.size()-1);  //路径的最后一个就是最新刚入的节点

                if(curr.equals(endWord)){       //因为endWord在wordList中，所以看看有没有这个endWord，有的话就找到了
                    List<String> list=new ArrayList<>(tempPath); //那么就将这个路径入结果集
                    result.add(list);
                }

                if(map.get(curr).isEmpty())continue;

                for(String child:map.get(curr)){              //看看最新入queue的节点的小孩们
                    if(!tempPath.contains(child)){            //这是个图，有环，所以需要判断一下当前小孩是否在途径中，只看没进路径的
                        List<String> newPath=new ArrayList<>(tempPath); //否则需要继续找，那也得将这个小孩入路径
                        newPath.add(child);
                        next.add(newPath);
                    }
                }
            }
            if(!result.isEmpty())break;     //因为是找最短路径，那么一旦结果集非空了就是找到了，结束。
            pathQ=next;                     //否则找下一层。
        }
        return result;
    }

    //method3 利用BFS来建树，DFS来找最短路径
    private static Map<String, Integer> distance=new HashMap<>();//保存着这个string的最低层高。
    public static List<List<String>> findLadders2(String beginWord,String endWord,List<String> wordList){
        List<List<String>> result=new ArrayList<>();
        if(!wordList.contains(endWord))return result;
        if(wordList.contains(beginWord))wordList.remove(beginWord);
        if(wordList.contains(endWord))wordList.remove(endWord);

        if(wordList.isEmpty())return result;
        //将beginWord和endword加进wordList
        if(!wordList.contains(beginWord))wordList.add(beginWord);
        if(!wordList.contains(endWord))wordList.add(endWord);
        //建树
        buildTreeBFS(beginWord,endWord,wordList);
        List<String> path=new ArrayList<>();
        path.add(endWord);
        DFS(result,path,beginWord,endWord);
        return result;
    }

    private static void DFS(List<List<String>> result,List<String> path,String beginWord,String curr){
        if(curr.equals(beginWord)){
            if(path.size()<subListsize) {    //看看当前的path是否比存在result里面的paths短，如果更短
                subListsize = path.size();   //就更新当前最短长度
                result.clear();              //清空result里面的内容
                Collections.reverse(path);
                result.add(new ArrayList<>(path));//将新的这个更短的path加进结果集。
                Collections.reverse(path);
            }else if(path.size()==subListsize){
                Collections.reverse(path);
                result.add(new ArrayList<>(path)); //如果和结果集里面的路径长度一样，就直接添加进去。
                Collections.reverse(path);
            }
            return;
        }

        List<String> next=map.get(curr);
        for (String str:next) {
            if(distance.containsKey(str)&&distance.get(str)+1==distance.get(curr)){
                path.add(str);
                DFS(result,path,beginWord,str);
                path.remove(path.size()-1);
            }
        }

    }

    private static void buildTreeBFS(String beginWord,String endWord,List<String> wordList){
        for(String str:wordList){
            map.put(str,new ArrayList<>());
        }
        distance.put(beginWord,0);

        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            String curr=queue.poll();
            List<String> children=canTransformFrom(curr,wordList);
            for(String child:children){
                map.get(curr).add(child);
                if(!distance.containsKey(child)){
                    distance.put(child,distance.get(curr)+1);  //distance一直保存的是最低level
                    queue.offer(child);
                }
            }
        }
    }
    private static List<String> canTransformFrom(String str,List<String> wordList){
        List<String> strings=new ArrayList<>();
        for(String temp:wordList){
            if(canTransform(str,temp))strings.add(temp);
        }
        return strings;
    }
}
