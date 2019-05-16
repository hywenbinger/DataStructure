package com.pvr.lib.sort;

/**
 * 排序
 * 1.原地排序：空间复杂度为O(1)的排序算法
 * 2.稳定性：值相同的元素，排序后，原先的先后顺序不变
 *
 * 冒泡排序和插入排序的时间复杂度都是O(n2)，都是原地排序算法，为什么插入排序要比冒泡排序更受欢迎呢？
 * 因为：冒泡排序的数据交换要比插入排序的数据移动要复杂，冒泡排序需要3个赋值操作，而插入排序只需要1个。
 */
public class Sort1 {

    public static void main(String[] args) {
        int[] array = {3, 1, 5, 7, 2, 8, 4, 9, 6};
        print(array);
//        bubbleSort(array);
//        insertionSort(array);
        selectionSort(array);
        print(array);
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序
     *
     * 每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。
     * 如果不满足就让它俩互换。一次冒泡会让至少一个元素移动到它应该在的位置，重复n次，就完成了n个数据的排序工作
     *
     * 最好时间复杂度：O(n)
     * 最坏时间复杂度：O(n*n)
     * 平均时间复杂度：O(n*n)
     * 空间复杂度：O(1)，是原地排序算法
     * 是稳定性排序算法
     * @param array
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            boolean flag = false; //提前退出冒泡循环的标志位
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true; //表示有数据交换
                }
            }
            if (!flag) {
                break; //没有数据交换，提前退出
            }
        }
    }

    /**
     * 插入排序
     *
     * 将数组中的数据分为两个区间，已排序区间和未排序区间。
     * 初始已排序区间只有一个元素，就是数组的第一个元素。
     * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
     * 重复这个过程，直到未排序区间中元素为空，算法结束。
     *
     * 最好时间复杂度：O(n)
     * 最坏时间复杂度：O(n*n)
     * 平均时间复杂度：O(n*n)
     * 空间复杂度：O(1)，是原地排序算法
     * 是稳定性排序算法
     * @param array
     */
    public static void insertionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int temp = array[i]; //为本次循环待插入有序列表中的数
            int j = i - 1;
            for (; j >= 0 && array[j] > temp; j--) {
                array[j + 1] = array[j]; //元素后移，为插入temp做准备
            }
            array[j + 1] = temp; //插入temp
        }
    }

    /**
     * 希尔排序
     * @param array
     */
    public static void shellSort(int[] array){
        if (array == null || array.length <= 1) {
            return;
        }
        int i, j, r, tmp;
        for(r = array.length / 2; r >= 1; r = r / 2) {
            for(i = r; i < array.length; i++) {
                tmp = array[i];
                j = i - r;
                while(j >= 0 && tmp < array[j]) {
                    array[j+r] = array[j];
                    j -= r;
                }
                array[j+r] = tmp;
            }
        }
    }

    /**
     * 选择排序
     *
     * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
     * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
     *
     * 最好时间复杂度：O(n*n)
     * 最坏时间复杂度：O(n*n)
     * 平均时间复杂度：O(n*n)
     * 空间复杂度：O(1)，是原地排序算法
     * 不是稳定性排序算法
     * @param array
     */
    public static void selectionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i; //最小值的索引
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

}
