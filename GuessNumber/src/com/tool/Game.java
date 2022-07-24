package com.tool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Game {

    int num = 0;
    private Set<Integer> numOfSet = new HashSet<Integer>();
    private int a = 0;
    private int b = 0;

    public Game(){
        Set<Integer> set = new HashSet<Integer>();
        set = makeNumber();
        numOfSet = set;
        Iterator<Integer> it = set.iterator();
        int t = 0;
        while (it.hasNext()){
            t = t*10+it.next();
        }
        num = t;
        System.out.println(num);
    }

    public void clear(){
        a=0;
        b=0;
    }

    public boolean mark(int num){
        int numSet1[] = new int[4];
        for (int i=0;i<4;i++) {
            int x = num%10;
            num = num/10;
            numSet1[3-i] = x;
        }
        Iterator<Integer> iterator = numOfSet.iterator();
        int numSet2[] = new int[4];
        for(int i=0;i<4&iterator.hasNext();i++){
            numSet2[i] = iterator.next();
        }
        for(int i=0;i<4;i++){
            if(numSet2[i]==numSet1[i]){
                a++;
            }
        }
        for (int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i != j&numSet1[i]==numSet2[j]){
                    b++;
                }
            }
        }
        if(a==4){
            return true;
        }else {
            return false;
        }
    }

    public Set<Integer> makeNumber(){
        //生成随机数
        Set<Integer> set = new HashSet<Integer>();
        Random random = new Random();
        while (set.size()<4){
            int num = random.nextInt(10);
            if(num == 0){
                continue;
            }else {
                set.add(num);
            }
        }
        return set;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
