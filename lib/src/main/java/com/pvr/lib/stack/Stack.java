package com.pvr.lib.stack;

/**
 * 栈
 */
public class Stack {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.print();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.print();
        arrayStack.pop();
        arrayStack.print();
        arrayStack.pop();
        arrayStack.print();

        LinkedStack linkStack = new LinkedStack();
        linkStack.push(1);
        linkStack.push(2);
        linkStack.push(3);
        linkStack.print();
        linkStack.pop();
        linkStack.print();
        linkStack.pop();
        linkStack.print();
    }

}

