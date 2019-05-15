package com.pvr.lib.linked;

public class Linked {

    public static void main(String[] args) {

        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertToHead(0);
        linkedList.insertToHead(1);
        linkedList.insertToHead(2);
        linkedList.printAll();
        System.out.println("--------------");
        linkedList.reverse();
        linkedList.printAll();
    }

}

