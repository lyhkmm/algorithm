package com.lyh.algorithm.sort;

import com.lyh.algorithm.sort.utils.NumberUtils;

/**
 * 冒泡排序
 * 顾名思义，像水里的泡泡一样从小变大。
 * 如有10个待排序的数组，需要循环九趟，每趟找出最大值
 * 如：3，5，2，1，4，7，6，9，8，0
 * 第一趟的第一次比较：比较第一个数（3）和第二个数（5），谁大谁在后面。5 比 3 大 ，所以不需要交换位置 3，5，2，1，4，7，6，9，8
 * 第一趟的第二次比较：比较第二个数（5）和第三个数（2），谁大谁在后面。5 比 2 大 ，所以需要交换5和2的位置 3，2，5，1，4，7，6，9，8
 * 第一趟的第三次比较：... 3，2，1，5，4，7，6，9，8
 * 第一趟比较完后可以得出这10个数字的最大值为 9。
 *
 * 第二趟比较也是从第一个数开始，第一趟我们已经得出最大值9了，所以第二趟比较时不需要再和9进行比较。
 * 第二趟比较完后可以得出这10个数字的第二大的值为8。
 * 以此类推找出第三，第四，第五..的值
 * @Author:linyuanhuang
 * @Date:2017/12/22 10:41
 */
public class Bubble {

    /**
     * 冒泡排序，intArrays为传入的数组
     * @author linyuanhuang
     * @Date 17:01 2017/12/26
     * @return void
    */
    public static void sort(int[] intArrays){
        int length=intArrays.length-1;
        for(int i=0;i<length;i++){
            //每一次循环找出最大值
            for(int j=0;j<length-i;j++){
                if(intArrays[j]>intArrays[j+1]){
                    //如果前面的数比后面的数大就交换它们的位置
                    NumberUtils.exchange(intArrays,j,j+1);
                }
            }
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
        System.out.println("冒泡排序用时："+(endTime-startTime)+"毫秒");
    }
}
