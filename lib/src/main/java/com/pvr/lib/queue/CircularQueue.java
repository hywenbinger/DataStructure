package com.pvr.lib.queue;

/**
 * 循环队列
 * 循环队列关键点是确定队空和队满的判断条件
 *      队空条件：head == tail
 *      队尾条件：(tail + 1) % size == head
 * 下面的入队操作，会导致队列满时，会有一个空间的浪费
 */
public class CircularQueue {

    private int[] items;
    private int size;//队列大小
    private int head;//队头下标
    private int tail;//队尾下标

    public CircularQueue(int size) {
        items = new int[size];
        this.size = size;
    }

    public boolean enqueue(int data) {
        System.out.println("---"+tail);
        if ((tail + 1) % size == head) {
            //队列满了
            return false;
        }
        items[tail] = data;
        tail = (tail + 1) % size;
        System.out.println("------"+tail);
        return true;
    }

    public int dequeue() {
        if (head == tail) {
            //如果head == tail，表示队列为空
            return -1;
        }
        int value = items[head];
        items[head] = 0;
        head = (head + 1) % size;
        return value;
    }

    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(items[i]+"  ");
        }
        System.out.println();
    }

}
