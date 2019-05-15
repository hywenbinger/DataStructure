package com.pvr.lib.queue;

import com.pvr.lib.linked.Node;

/**
 * 链式队列
 */
public class LinkedQueue {

    private Node head = null;//队头节点
    private Node tail = null;//队尾节点

    public void enqueue(int data){
        Node node = new Node(data, null);
        if(head == null || tail == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public int dequeue(){
        if(head == null){
            return -1;
        }
        int value = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return value;
    }

    public void print(){
        Node p = head;
        while (p != null){
            System.out.print(p.data+"——>");
            p = p.next;
        }
        System.out.println();
    }

}
