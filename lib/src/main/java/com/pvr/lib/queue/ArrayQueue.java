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

    /**
     * 由于到队尾时，可能会进行数据迁移，所以队入队操作性能会有影响
     * 有什么办法可避免入队时数据迁移呢？
     * 循环队列可解决这个问题
     * @param data
     * @return
     */
    public boolean enqueue(int data){
        if(tail == size){
            if(head == 0){
                //队列慢了，对头还是0，入队失败
                return false;
            }
            //数据迁移
            for(int i=head;i<tail;i++){
                items[i-head] = items[i];
            }
            //迁移完数据，重新定位head和tail
            tail -= head;
            head = 0;

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
        //如果head == tail，表示队列为空
        if(head == tail){
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
