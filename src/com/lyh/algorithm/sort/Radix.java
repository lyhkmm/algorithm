package com.lyh.algorithm.sort;

import com.lyh.algorithm.sort.utils.NumberUtils;

import java.util.Arrays;

/**
 * @Author:linyuanhuang
 * @Date:2017/12/28 15:40
 */
public class Radix {
    public static void sort(int[] intArrays,int max) {
        int n=1;//代表位数对应的数：个位、十位、百位、千位..直到小于max的最大位数
        int k=0;//保存每一位排序后的结果用于下一位的排序输入
        int length=intArrays.length;
        int[][] bucket=new int[10][length];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[] order=new int[length];//用于保存每个桶里有多少个数字
        while(n<max)
        {
            for(int num:intArrays) //将数组array里的每个数字放在相应的桶里
            {
                int digit=(num/n)%10;
                bucket[digit][order[digit]]=num;
                order[digit]++;
            }
            for(int i=0;i<length;i++)//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
            {
                if(order[i]!=0)//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                {
                    for(int j=0;j<order[i];j++)
                    {
                        intArrays[k]=bucket[i][j];
                        k++;
                    }
                }
                order[i]=0;//将桶里计数器置0，用于下一次位排序
            }
            n*=10;//扩大位数，如从个位扩大到十位
            k=0;//将k置0，用于下一轮保存位排序结果
        }
    }
    /**
     * 执行入口，intArrays：待排序的数组，displaySort：是否显示排序前和排序后的内容。
     * @Author linyuanhuang
     * @Date 2017/12/22 15:11
     * @return void
     */
    public static void run(int intArrays[],int max,boolean displaySort){
        //克隆一份数组
        int arrays[]= intArrays.clone();
        // 判断是否需要显示排序前的内容
        if(displaySort){
            NumberUtils.display(arrays,1);
        }
        // 记录开始时间
        long startTime=System.currentTimeMillis();
        sort(arrays,max);
        // 记录结束时间
        long endTime=System.currentTimeMillis();
        // 判断是否需要显示排序前的内容
        if(displaySort){
            NumberUtils.display(arrays,2);
        }
        System.out.println("基数排序用时："+(endTime-startTime)+"毫秒");
    }

}
