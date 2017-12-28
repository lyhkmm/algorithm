package com.lyh.algorithm.sort;

import com.lyh.algorithm.sort.utils.NumberUtils;

/**
 * 插入排序
 * 直接插入排序(Straight Insertion Sort)的基本思想是：
 * 把n个待排序的元素看成为一个有序表和一个无序表。开始时有序表中只包含1个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程
 * 其实类似我们摸牌，一开始有一堆牌（待排序的）。由于第一次摸牌时手中没牌，所以不需要排序。第二次摸牌时和手中第一张拍比较，如果它大，就放在它的后面。
 * 每次摸牌都会把牌放在一个前面比自己小（或等于），后面比自己大（或等于）的位置。
 * @Author linyuanhuang
 * @Date 2017/12/22 14:23
 */
public class Insertion {

    /**
     * 直接插入排序算法方法
     * @author linyuanhuang
     * @Date 11:09 2017/12/28
     * @return void
    */
    public static void sort(int intArrays[]){
        int length=intArrays.length;
        int i,j;
        for(i=1;i<length;i++){
            for(j=i-1;j>=0&&intArrays[i]<intArrays[j];j--){
                //intArrays[i]代表要插入的数字，intArrays[j]代表需要比较大小的数字，j递减
                //当intArrays[i]大于intArrays[j]时（intArrays[i]插入的位置，也就是说插在j的后一位）或者intArrays[i]为当前数组的最小值时（此时的j为-1,也就是说intArrays[i]要插在第一位）返回j
            }
            //将intArrays[i]保存住，因为要j以后的数组向后移一位
            int temp=intArrays[i];
            for(int k=i;k>j+1;k--){
                //将i到j范围的数组向后移一位
                intArrays[k]=intArrays[k-1];
            }
            //intArrays[i]插在j的后一位
            intArrays[j+1]=temp;
        }
    }

    /**
     * 执行入口，intArrays：待排序的数组，displaySort：是否显示排序前和排序后的内容。
     * @author linyuanhuang
     * @Date 17:25 2017/12/26
     * @return void
     */
    public static void run(int intArrays[],boolean displaySort){
        int arrays[]= intArrays.clone();
        if(displaySort){
            NumberUtils.display(arrays,1);
        }
        long startTime=System.currentTimeMillis();
        sort(arrays);
        long endTime=System.currentTimeMillis();
        if(displaySort){
            NumberUtils.display(arrays,2);
        }
        System.out.println("插入排序用时："+(endTime-startTime)+"毫秒");
    }
}
