package com.pvr.lib.queue;

/**
 * 队列
 */
public class Queue {

    public static void main(String[] args) {
//        LinkQueue linkQueue = new LinkQueue();
//        linkQueue.enqueue(0);
//        linkQueue.print();
//        linkQueue.enqueue(1);
//        linkQueue.enqueue(2);
//        linkQueue.print();
//        linkQueue.dequeue();
//        linkQueue.dequeue();
//        linkQueue.print();
//        linkQueue.enqueue(3);
//        linkQueue.print();
//        linkQueue.dequeue();
//        linkQueue.print();

        ArrayQueue arrayQueue = new ArrayQueue(7);
        arrayQueue.print();
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.print();
        arrayQueue.dequeue();
        arrayQueue.print();
    }

}