package com.pvr.lib.stack;

/**
 * 顺序栈
 */
public class ArrayStack{

    private int[] items;
    private int size;//栈的大小
    private int count;//栈中元素个数

    public ArrayStack(int size){
        items = new int[size];
        this.size = size;
        count = 0;
    }

    public boolean push(int data){
        if(count >= size){
            //数组空间不足，入栈失败
            return false;
        }
        items[count] = data;
        ++count;
        return true;
    }

    public int pop(){
        if(count == 0){
            return -1;
        }
        int tmp = items[count-1];
        items[count-1] = 0;
        --count;
        return tmp;
    }

    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(items[i]+"  ");
        }
        System.out.println();
    }

}
