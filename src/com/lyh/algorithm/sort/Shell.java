package com.lyh.algorithm.sort;

import com.lyh.algorithm.sort.utils.NumberUtils;

/**该方法的基本思想是：先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，
 * 然后依次缩减增量再进行排序，待整个序列中的元素基本有序（增量足够小）时，
 * 再对全体元素进行一次直接插入排序。因为直接插入排序在元素基本有序的情况下（接近最好情况），效率是很高的，因此希尔排序在时间效率上比前两种方法有较大提高。
 * @Author linyuanhuang
 * @Date 2017/12/22 15:11
 */
public class Shell {
    public static void sortTest(int[] intArrays) {
        int length = intArrays.length;
        int h = 1;
        int block=3;//分块大小（大于1的值）
        //h为分区后每块有多少个元素
        while (h < length / block) {
            h = block* h + 1; //通过循环算出h的取值，当分区大小为3时，h序列为1, 4, 13, 40, ...
        }
        while (h >= 1) {
            int n, i ,j, k;
            //分割后，产生n个子序列
            for (n = 0; n < h; n++) {
                //分别对每个子序列进行直接插入排序
                for (i = n + h; i < length; i += h) {
                    for (j = i - h; j >= 0 && intArrays[i] > intArrays[j]; j -= h) {

                    }
                    int tmp = intArrays[i];
                    for (k = i; k > j + h; k -= h) {
                        intArrays[k] = intArrays[k-h];
                    }
                    intArrays[j+h] = tmp;
                }
            }
            //直接插入排序完后，减少每块区里的元素。也就是说增大块区的数量，直到最后h=1(每块区里只有一个元素时，排序完成)
            h = h / block;
        }
    }
    public static void sort(int[] intArrays) {
        int length = intArrays.length;
        int h = 1;
        int block=3;//分块大小（大于1的值）
        //h为分区后每块有多少个元素
        while (h < length / block) {
            h = block* h + 1; //通过循环算出h的取值，当分区大小为3时，h序列为1, 4, 13, 40, ...
        }
        while (h >= 1) {
            int n, i ,j, k;
            //分割后，产生n个子序列
            for (n = 0; n < h; n++) {
                //分别对每个子序列进行直接插入排序
                for (i = n + h; i < length; i += h) {
                    for (j = i - h; j >= 0 && intArrays[i] < intArrays[j]; j -= h) {

                    }
                    int tmp = intArrays[i];
                    for (k = i; k > j + h; k -= h) {
                        intArrays[k] = intArrays[k-h];
                    }
                    intArrays[j+h] = tmp;
                }
            }
            //直接插入排序完后，减少每块区里的元素。也就是说增大块区的数量，直到最后h=1(每块区里只有一个元素时，排序完成)
            h = h / block;
        }
    }
    /**
     * 执行入口，intArrays：待排序的数组，displaySort：是否显示排序前和排序后的内容。
     * @Author linyuanhuang
     * @Date 2017/12/22 15:11
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
        System.out.println("希尔排序用时："+(endTime-startTime)+"毫秒");
    }
}
