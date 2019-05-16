package com.pvr.lib.sort;

/**
 * 冒泡排序，插入排序，选择排序的时间复杂度都是O(n*n)
 * 归并排序和快速排序的时间复杂度都是O(n*logn)
 */
public class Sort2 {

    public static void main(String[] args) {
        int[] array = {3, 1, 5, 7, 2, 8, 4, 9, 6};
        print(array);
//        mergeSort(array);
        quickSort(array);
        print(array);
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    /**
     * 归并排序
     *
     * 先把数组从中间分成前后两部分，然后对前后两部分分别排序，
     * 再将排好序的两部分合并（两部分元素逐个比较）在一起，这样整个数组就都有序了。
     *
     * 归并排序使用的就是分治思想。
     * 分治，顾名思义，就是分而治之，将一个大问题分解成小的子问题来解决。小的子问题解决了，大问题也就解决了。
     * 用递归来实现归并排序。
     *
     * 最好时间复杂度：O(n*logn)
     * 最坏时间复杂度：O(n*logn)
     * 平均时间复杂度：O(n*logn)
     * 空间复杂度：O(n)，不是原地排序算法
     * 是稳定性排序算法
     * @param array
     */
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        mergeSortInternally(array, 0, array.length - 1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) return;
        // 取p到r之间的中间位置q，防止(p+r)的和超过int类型最大值
        int q = p + (r - p) / 2;
        System.out.println(p+", "+r+", "+q);
        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);
        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    // 申请一个临时数组tmp，大小与A[p…r]相同。
    // 用两个游标i和j，分别指向A[p…q]和A[q+1…r]的第一个元素。
    // 比较这两个元素A[i]和A[j]，如果A[i]<=A[j]，就把A[i]放入到临时数组tmp，并且i后移一位，否则将A[j]放入到数组tmp，j后移一位。
    // 继续上述比较过程，直到其中一个子数组中的所有数据都放入临时数组中。
    // 再把另一个数组中的数据依次加入到临时数组的末尾，这个时候，临时数组中存储的就是两个子数组合并之后的结果了。
    // 最后再把临时数组tmp中的数据拷贝到原数组A[p…r]中。
    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0; // 初始化变量i, j, k
        int[] tmp = new int[r - p + 1]; // 申请一个大小跟a[p...r]一样的临时数组
        //逐个比较[p,q]和[q+1,r]每个元素的大小，放入临时数组中
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++]; // i++等于i:=i+1
            } else {
                tmp[k++] = a[j++];
            }
        }
        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }
        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r - p; ++i) {
            a[p + i] = tmp[i];
        }
    }

    /**
     * 快速排序
     *
     * 快排利用的也是分治思想。
     * 如果要排序数组[p,r]之间的数据，我们选择[p,r]之间的任意一个数据作为pivot（分区点），一般情况下，选择[p,r]区间的最后一个元素。
     * 遍历[p,r]之间的数据，将小于pivot的放到左边，将大于pivot的放到右边，将pivot放到中间。
     * 经过这一步骤之后，数组[p,r]之间的数据就被分成了三个部分，前面的[p,q-1]之间都是小于pivot的，中间是pivot，后面的[q+1,r]之间是大于pivot的。
     * 根据分治、递归的处理思想，继续用递归排序[p,q-1]之间的数据和[q+1,r]之间的数据，直到区间缩小为1，就说明所有的数据都有序了。
     *
     * 最好时间复杂度：O(n*logn)
     * 最坏时间复杂度：O(n*n)（概率非常小，可以通过合理地选择pivot来避免这种情况）
     * 平均时间复杂度：O(n*logn)
     * 空间复杂度：O(1)，是原地排序算法
     * 不是稳定性排序算法
     * @param array
     */
    public static void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSortInternally(array, 0, array.length - 1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;
        int q = partition(a, p, r); // 获取分区点，并进行原地分区（保证是原地排序）
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    // 不考虑空间消耗的话，partition()分区函数可以写得非常简单。
    // 申请两个临时数组X和Y，遍历A[p…r]，将小于pivot的元素都拷贝到临时数组X，将大于pivot的元素都拷贝到临时数组Y，最后再将数组X和数组Y中数据顺序拷贝到A[p…r]。
    // 但是上述简单方法需要很多额外的内存空间，导致快排不是原地排序算法了。
    // 希望快排是原地排序算法，应该怎么做呢？
    //
    // 把[p,r]的最后一个元素作为pivot，通过游标i把A[p…r-1]分成两部分。
    // A[p…i-1]的元素都是小于pivot的，暂且叫它“已处理区间”，A[i…r-1]是“未处理区间”。
    // 每次都从未处理的区间A[i…r-1]中取一个元素A[j]，与pivot对比，如果小于pivot，则将其加入到已处理区间的尾部，也就是A[i]的位置。
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        // 交换a[i]和a[r]
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }

}
