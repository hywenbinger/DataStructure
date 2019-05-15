package com.pvr.lib.stack;

import com.pvr.lib.linked.Node;

/**
 * 链式栈
 */
public class LinkedStack {

    private Node top = null;

    public void push(int data){
        Node node = new Node(data, null);
        if(top == null){
            top = node;
        }else{
            node.next = top;
            top = node;
        }
    }

    public int pop(){
        if(top == null){
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public void print(){
        Node head = top;
        while (head != null){
            System.out.print(head.data+"  ");
            head = head.next;
        }
        System.out.println();
    }

}
