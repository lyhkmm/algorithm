package com.lyh.algorithm.sort;

import com.lyh.algorithm.sort.utils.NumberUtils;

/**
 *
 * @Author linyuanhuang
 * @Date 2017/12/22 16:10
 */
public class Main {

    /**
     * 测试排序用的主方法
     * @author linyuanhuang
     * @Date 16:25 2017/12/25
     * @return void  
    */
    public static void main(String[] args){
        //数组长度
        int length=30000;
        //最大值
        int max =100000000;
        //是否打印排序后的内容
        boolean display=false;
        //随机获取的排序数组
        int intArrays[]= NumberUtils.getRandomArs(length,max);

/*        //先用希尔排序将数组排序成有序的
        Shell.sortTest(intArrays);
        NumberUtils.display(intArrays,1);*/
        //冒泡排序
        Bubble.run(intArrays,display);
        //冒泡排序
        Bubble.run(intArrays,display);
        //选择排序
        Selection.run(intArrays,display);
        //插入排序
        Insertion.run(intArrays,display);
        //希尔排序
        Shell.run(intArrays,display);
        //归并
        Merge.run(intArrays,display);
        //快速
        Quick.run(intArrays,display);
        //堆排序
        Heap.run(intArrays,display);
        //基数排序
        Radix.run(intArrays,max,display);

    }
}
