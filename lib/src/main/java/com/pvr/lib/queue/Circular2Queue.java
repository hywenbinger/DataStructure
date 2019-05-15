package com.pvr.lib.queue;

/**
 * 循环列表
 * 尝试优化CircularQueue
 */
public class Circular2Queue {

    private int[] items;
    private int size;//队列大小
    private int head;//队头下标
    private int tail;//队尾下标
    private int count;//队列中元素个数

    public Circular2Queue(int size) {
        items = new int[size];
        this.size = size;
    }

    public boolean enqueue(int data) {
        if(count == size){
            System.out.println("队列满了");
            return false;
        }
        if(tail == size && count != size){
            tail = 0;
        }
        items[tail] = data;
        ++tail;
        ++count;
        System.out.println("head="+head+", tail="+tail+", count="+count);
        return true;
    }

    public int dequeue() {
        if(count == 0){
            System.out.println("队列空了");
            return -1;
        }
        if(head == size && count != size){
            head = 0;
        }
        int value = items[head];
        items[head] = 0;
        ++head;
        --count;
        System.out.println("head="+head+", tail="+tail+", count="+count);
        return value;
    }

    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(items[i]+"  ");
        }
        System.out.println();
    }

}
