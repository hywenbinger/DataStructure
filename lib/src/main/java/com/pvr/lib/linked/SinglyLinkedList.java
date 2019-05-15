package com.pvr.lib.linked;

public class SinglyLinkedList{

    /**
     * 头结点
     */
    private Node headNode = null;

    /**
     * 根据数值查找Node
     * @param data
     * @return
     */
    public Node findByData(int data){
        Node node = headNode;
        while (node != null && node.data != data){
            node = node.next;
        }
        return node;
    }

    /**
     * 根据位置查找Node
     * @param index
     * @return
     */
    public Node findByIndex(int index){
        Node node = headNode;
        int position = 0;
        while (node != null && position != index){
            node = node.next;
            ++position;
        }
        return node;
    }

    /**
     * 插入到头
     * @param data
     */
    public void insertToHead(int data){
        Node newNode = new Node(data, null);
        if(headNode == null){
            headNode = newNode;
        }else{
            newNode.next = headNode;
            headNode = newNode;
        }
    }

    /**
     * 插入到尾
     * @param data
     */
    public void insertToTail(int data){
        Node newNode = new Node(data, null);
        if(headNode == null){
            headNode = newNode;
        }else{
            Node q = headNode;
            while(q.next != null){
                q = q.next;
            }
            q.next = newNode;
        }
    }

    /**
     * 插入到某个节点的前面
     * @param p
     * @param data
     */
    public void insertToBefore(Node p, int data){
        if(p == null){
            return;
        }
        if(headNode == p){
            insertToHead(data);
            return;
        }
        Node q = headNode;
        while (q != null && q.next != p) {
            q = q.next;
        }
        Node newNode = new Node(data, null);
        newNode.next = p;
        q.next = newNode;
    }

    /**
     * 插入到某个节点的后面
     * @param p
     * @param data
     */
    public void insertToAfter(Node p, int data){
        if(p == null){
            return;
        }
        Node newNode = new Node(data, null);
        newNode.next = p.next;
        p.next = newNode;
    }

    public void printAll() {
        Node p = headNode;
        while (p != null) {
            System.out.println(p.data + "");
            p = p.next;
        }
    }

    /**
     * 反转
     */
    public void reverse(){
        if(headNode == null || headNode.next == null){
            return;
        }
        Node preNode = null;
        Node curNode = headNode;
        while (curNode != null){
            Node nexNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nexNode;
        }
    }

}
