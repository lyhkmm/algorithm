package com.lyh.algorithm.sort.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 数字工具类
 * @Author:linyuanhuang
 * @Date:2017/12/22 10:43
 */
public class NumberUtils {
    /**
     * 获取Set随机数
     * @Author:linyuanhuang
     * @Date:11:00 2017/12/22
     * @return java.util.Set<java.lang.Integer>
    */
    public static Set<Integer> getRandomSet(int size,int max){
        Set<Integer> set=new HashSet<>();
        Random random=new Random();
        do {
            set.add(random.nextInt(max));
        }while (set.size()<size);
        return set;
    }

    /**
     * 获取不重复的随机int类型数组
     * @Author:linyuanhuang
     * @Date 11:22 2017/12/22
     * @return int[]
    */
    public static int[] getRandomNotRepeatArs(int length,int max){
        Set<Integer> set=getRandomSet(length,max);
        int rs[]=new int[length];
        int n=0;
        for(int i:set){
            rs[n]=i;
            n++;
        }
        return rs;
    }
    /**
     * 获取随机int类型数组
     * @Author:linyuanhuang
     * @Date 11:22 2017/12/22
     * @return int[]
     */
    public static int[] getRandomArs(int length,int max){
        int rs[]=new int[length];
        Random random=new Random();
        for(int i=0;i<length;i++){
            rs[i]=random.nextInt(max);
        }
        return rs ;
    }
    /**
     * 打印内容
     * @Author:linyuanhuang
     * @Date:11:28 2017/12/22
     * @return void
    */
    public static void display(int intArrays[],int type){
        int count=0;
        if(type==2){
            System.out.print("排序后：");
        }else if(type==1){
            System.out.print("排序前：");
        }
        if(intArrays.length<40){
            for(int i:intArrays){
                System.out.print(i+" ");
            }
        }else {
            for(int i:intArrays){
                count++;
                if(count<10){
                    System.out.print(i+" ");
                }else if(count==10){
                    System.out.print("......");
                }else if(count> intArrays.length-10){
                    System.out.print(i+" ");
                }
            }
        }
        System.out.println();
    }

    /**
     * 交换数组中两个数的位置
     * @author linyuanhuang
     * @Date 17:00 2017/12/25
     * @return void
    */
    public static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
