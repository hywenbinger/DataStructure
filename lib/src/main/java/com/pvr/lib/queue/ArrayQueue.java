package com.pvr.lib.queue;

/**
 * 顺序队列
 */
public class ArrayQueue {

    private int[] items;
    private int size;//队列大小
    private int head;//队头下标
    private int tail;//队尾下标

    public ArrayQueue(int size){
        items = new int[size];
        this.size = size;
    }

    public boolean enqueue(int data){
        if(tail >= size){
            //入队失败
            return false;
        }
        items[tail] = data;
        ++tail;
        return true;
    }

    /**
     * 出队时，不考虑数据迁移，入队时，当到队尾时，再进行数据迁移，可以优化出队的时间复杂度
     * 1.出队时数据迁移，出队操作的时间复杂度O(n)
     * 2.入队时数据迁移，出队操作的时间复杂度O(1)
     * @return
     */
    public int dequeue(){
        if(tail == 0){
            return -1;
        }
        int value = items[head];
        items[head] = 0;
        ++head;
        return value;
    }

    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(items[i]+"  ");
        }
        System.out.println();
    }

}
