package com.lyh.algorithm.sort;

import com.lyh.algorithm.sort.utils.NumberUtils;

/**
 * 选择排序
 * 选择排序和冒泡排序类似，都是每一趟找出最大值（或最小值）。只不过选择排序不需要交换位置，而是直接从每一趟找出最大值。
 * @Author linyuanhuang
 * @Date 2017/12/22 11:54
 */
public class Selection {
    public static void sort(int intArrays[]){
        int length=intArrays.length;//数组长度
        //循环比较，假如数组长度为10，则循环9次。第一趟循环有10个数，找出这十个数的最小值放在一位。第二次循环找出另外9个数的最小值，放在数字第二位。第三次找出另外8个数最小值，以此类推...
        for(int i=0;i<length-1;i++){
            //用来保存每一趟最小值数组的下标，开始前假设第一个数字为这趟的最小值
            int minIndex=i;
            //找出每一趟的最小值，如果有最小值就将这趟的最小值放在这趟数组第一个位，如果没有最小值就继续执行下一趟
            for(int j=i+1;j<length;j++){
                if(intArrays[j]<intArrays[minIndex]){
                    //如果这一趟有最小值,则保存它的下标。如果这一趟没有最小值，这下标还是这趟的第一个数字
                    minIndex=j;
                }
            }
            //将这趟的第一个数字和这趟的最小值交换位置
            NumberUtils.exchange(intArrays,i,minIndex);
        }

    }

    /**
     * 执行入口，intArrays：待排序的数组，displaySort：是否显示排序前和排序后的内容。
     * @author linyuanhuang
     * @Date 17:25 2017/12/26
     * @return void
     */
    public static void run(int intArrays[],boolean displaySort){
        //克隆一份数组
        int arrays[]= intArrays.clone();
        // 判断是否需要显示排序前的内容
        if(displaySort){
            NumberUtils.display(arrays,1);
        }
        // 记录开始时间
        long startTime=System.currentTimeMillis();
        sort(arrays);
        // 记录结束时间
        long endTime=System.currentTimeMillis();
        // 判断是否需要显示排序前的内容
        if(displaySort){
            NumberUtils.display(arrays,2);
        }
        System.out.println("选择排序用时："+(endTime-startTime)+"毫秒");
    }
}
