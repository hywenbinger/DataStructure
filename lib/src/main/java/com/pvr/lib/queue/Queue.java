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

//        ArrayQueue arrayQueue = new ArrayQueue(3);
//        arrayQueue.print();
//        arrayQueue.enqueue(1);
//        arrayQueue.enqueue(2);
//        arrayQueue.enqueue(3);
//        arrayQueue.print();
//        arrayQueue.dequeue();
//        arrayQueue.print();
//        arrayQueue.enqueue(4);
//        arrayQueue.print();

//        CircularQueue circularQueue = new CircularQueue(3);
//        circularQueue.enqueue(1);
//        circularQueue.enqueue(2);
//        circularQueue.enqueue(3);
//        circularQueue.print();

        Circular2Queue circular2Queue = new Circular2Queue(3);
        circular2Queue.enqueue(1);
        circular2Queue.enqueue(2);
        circular2Queue.enqueue(3);
        circular2Queue.enqueue(4);//队列满了
        circular2Queue.print();
        circular2Queue.dequeue();
        circular2Queue.dequeue();
        circular2Queue.print();
        circular2Queue.enqueue(1);
        circular2Queue.print();
        circular2Queue.enqueue(2);
        circular2Queue.print();
        circular2Queue.dequeue();
        circular2Queue.print();
        circular2Queue.dequeue();
        circular2Queue.print();
        circular2Queue.dequeue();
        circular2Queue.print();

    }

}