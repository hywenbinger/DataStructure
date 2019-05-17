package com.pvr.lib.search;

/**
 * 查找
 */
public class Search {

    public static void main(String[] args) {
//        int[] array = {1,2,3,4,5,6,7,8,9};
//        print(array);
//        int value = 7;
//        System.out.println(binarySearch(array, value));

        int[] array = {1,3,4,5,6,8,8,8,11,18};
        int value = 8;
        print(array);
        System.out.println("search1---"+ search1(array, value));
        System.out.println("search2---"+ search2(array, value));
        System.out.println("search3---"+ search3(array, value));
        System.out.println("search4---"+ search4(array, value));
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    /**
     * 简单的二分查找
     *
     * 每次都通过跟区间中的中间元素对比，将待查找的区间缩小为一半，直到找到要查找的元素，或者区间被缩小为0。
     *
     * 时间复杂度：O(logn)
     *
     * 二分查找局限性：
     *      1.二分查找依赖的是顺序表结构，简单点说就是数组。
     *      2.二分查找针对的是有序数据。
     *      3.数据量太小不适合二分查找。但是如果数据之间的比较非常耗时，不管数据量大小，都推荐使用二分查找。
     *      4.数据量太大也不适合二分查找。由于数组必须存储在连续内存中。
     *
     * @param array
     * @param value
     * @return
     */
    public static int binarySearch(int[] array, int value){
        if(array == null || array.length == 0){
            return -1;
        }
        int length = array.length;
        int low = 0;
        int high = length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归方式实现简单的二分查找
     *
     * @param array
     * @param value
     * @return
     */
    public static int binarySearch2(int[] array, int value){
        if(array == null || array.length == 0){
            return -1;
        }
        int length = array.length;
        return binarySearch2Internally(array, 0, length-1, value);
    }

    public static int binarySearch2Internally(int[] array, int low, int high, int value) {
        if (low > high){
            return -1;
        }
        //如果low和high比较大的话，两者之和就有可能会溢出，改进：int mid = low + (high-low) / 2
        //使用位操作（左移一位）加快运算：int mid =  low + ((high - low) >> 1);
        int mid =  low + ((high - low) >> 1);
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] < value) {
            return binarySearch2Internally(array, mid+1, high, value);
        } else {
            return binarySearch2Internally(array, low, mid-1, value);
        }
    }

    /**
     * 查找第一个值等于给定值的元素
     * @param array
     * @param value
     * @return
     */
    public static int search1(int[] array, int value){
        if(array == null || array.length == 0){
            return -1;
        }
        int length = array.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                // 下面代码是重点
                if ((mid == 0) || (array[mid - 1] != value)){
                    // 如果mid等于0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的；
                    // 如果mid不等于0，但array[mid]的前一个元素array[mid-1]不等于value，那也说明array[mid]就是我们要找的第一个值等于给定值的元素。
                    return mid;
                }
                else {
                    // 检查之后发现array[mid]前面的一个元素array[mid-1]也等于value，
                    // 说明此时的array[mid]肯定不是我们要查找的第一个值等于给定值的元素。
                    // 接着就更新high=mid-1，因为要找的元素肯定出现在[low, mid-1]之间。
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    /**
     * 查找最后一个值等于给定值的元素
     * @param array
     * @param value
     * @return
     */
    public static int search2(int[] array, int value){
        if(array == null || array.length == 0){
            return -1;
        }
        int length = array.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                // 下面代码是重点
                if ((mid == length - 1) || (array[mid + 1] != value)){
                    return mid;
                }
                else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param array
     * @param value
     * @return
     */
    public static int search3(int[] array, int value){
        if(array == null || array.length == 0){
            return -1;
        }
        int length = array.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (array[mid] >= value) {
                // 下面代码是重点
                if ((mid == 0) || (array[mid - 1] < value)) {
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param array
     * @param value
     * @return
     */
    public static int search4(int[] array, int value){
        if(array == null || array.length == 0){
            return -1;
        }
        int length = array.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else {
                // 下面代码是重点
                if ((mid == length - 1) || (array[mid + 1] > value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}
