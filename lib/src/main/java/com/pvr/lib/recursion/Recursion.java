package com.pvr.lib.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归
 */
public class Recursion {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(n + "个台阶的走法有" + step1(n) + "种");
    }

    /**
     * 有n个台阶，每次只可以跨1个台阶或者2个台阶，请问走这n个台阶有多少种走法
     * @param n
     * @return
     */
    public static int step(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return step(n - 1) + step(n - 2);
    }

    private static Map<Integer, Integer> solvedList = new HashMap<>();

    /**
     * 优化上个递归代码，避免重复计算的问题
     * @param n
     * @return
     */
    public static int step1(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (solvedList.containsKey(n)) {
            return solvedList.get(n);
        }
        int value = step1(n - 1) + step1(n - 2);
        solvedList.put(n, value);
        return value;
    }

    /**
     * 用非递归方式优化这个问题
     * @param n
     * @return
     */
    public static int step2(int n){
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; ++i) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }

}
