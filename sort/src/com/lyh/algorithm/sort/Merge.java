package com.lyh.algorithm.sort;

import com.lyh.algorithm.sort.utils.NumberUtils;

/**
 * 归并排序
 * 归并排序采用了分治策略（divide-and-conquer），就是将原问题分解为一些规模较小的相似子问题，然后递归解决这些子问题，最后合并其结果作为原问题的解。
 * 归并排序将待排序数组A[1..n]分成两个各含n/2个元素的子序列，然后对这个两个子序列进行递归排序，最后将这两个已排序的子序列进行合并，即得到最终排好序的序列。具体排序过程如下图所示：
 * @Author linyuanhuang
 * @Date 2017/12/22 15:51
 */
public class Merge {
    /**
     * 递归到最后的排序
     * @author linyuanhuang
     * @Date 12:01 2017/12/28
     * @return void
    */
    private static void sort(int[] a, int left, int mid, int right) {
        int i = left; //左数组下一个要进行比较的元素的索引
        int j = mid + 1; //右数组下一个要进行比较的元素的索引
        int N = right + 1; //本次归并的元素数目
        int[] tmpArray = new int[N]; //用于暂时存放比较后的元素
        for (int k = left; k <= right; k++) {
            if (i > mid) {  //左数组元素已全比较完
                tmpArray[k] = a[j++];
            } else if (j > right) { //右数组元素已全比较完
                tmpArray[k] = a[i++];
            } else if (a[j] < a[i]) { //右数组元素小于左数组
                tmpArray[k] = a[j++];
            } else {  //右数组元素大于等于左数组
                tmpArray[k] = a[i++];
            }
        }
        //归并完成后，再复制回原数组
        for (int k = left; k < N; k++) {
            a[k] = tmpArray[k];
        }
    }
    /**
     * 归并排序开始入口
     * @author linyuanhuang
     * @Date 11:57 2017/12/28
     * @return void  
    */
    public static void sort(int[] a) {
        int N = a.length;
        merge(a, 0, N - 1);
    }
    /**
     * 递归方法
     * @author linyuanhuang
     * @Date 12:04 2017/12/28
     * @return void
    */
    private static void merge(int[] a, int left, int right) {
        //左索引大于等于右索引直接返回
        if (left >= right) {
            return;
        }
        //一分为二
        int mid = (left + right) / 2;
        //递归一分为二左边的队列
        merge(a, left, mid);
        //递归一分为二右边的队列
        merge(a, mid+1, right);
        //排序
        sort(a, left, mid, right);
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
        System.out.println("归并排序用时："+(endTime-startTime)+"毫秒");
    }
}
