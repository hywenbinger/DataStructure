package com.pvr.lib.linked;

/**
 * 链表
 */
public class Linked2 {

    public static void main(String[] args) {
//        Node node1 = new Node(1, null);
//        Node node2 = new Node(2, null);
//        Node node3 = new Node(3, null);
//        Node node4 = new Node(4, null);
//        Node node5 = new Node(5, null);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        print(node1);

//        Node node = reverse(node1);
//        print(node);

//        Node node = findMiddleNode(node1);
//        System.out.println("中间节点是："+node.data);

//        System.out.println("是否是环链表："+checkCircle(node1));

//        Node node = deleteLastKth(node1, 2);
//        print(node);

        Node a1 = new Node(1, null);
        Node a2 = new Node(3, null);
        Node a3 = new Node(5, null);
        a1.next = a2;
        a2.next = a3;

        Node b1 = new Node(2, null);
        Node b2 = new Node(4, null);
        Node b3 = new Node(6, null);
        Node b4 = new Node(7, null);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;

        Node node = mergeSortedLists(a1, b1);
        print(node);
    }

    public static void print(Node p) {
        while (p != null) {
            System.out.print(p.data + "——>");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * 反转
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            //链表为空或只有一个节点
            return head;
        }
        Node preNode = null;//前一个节点
        Node curNode = head;//当前节点
        while (curNode != null) {
            Node nextNode = curNode.next;//下一个节点
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    /**
     * 找中间节点
     *
     * @param head
     * @return
     */
    public static Node findMiddleNode(Node head) {
        if (head == null || head.next == null) {
            //链表为空或只有一个节点
            return head;
        }
        Node slow = head;//慢指针，每次移动一次
        Node fast = head;//快指针，每次移动两次
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast.next == null ? slow : slow.next;
    }

    /**
     * 检查是否是环链表
     *
     * @param head
     * @return
     */
    public static boolean checkCircle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;//慢指针，每次移动一次
        Node fast = head;//快指针，每次移动两次
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除倒数第K个结点
     * 思路：两个指针，快指针先走k-1步，然后快慢指针一起走，当快指针走到最后时，慢指针所在的位置就是倒数第K个节点所在的位置
     * @param head
     * @param k
     * @return
     */
    public static Node deleteLastKth(Node head, int k) {
        Node fast = head;
        Node slow = head;
        int i = 0;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }
        if (fast == null) {
            return head;
        }
        Node p = null;
        while (fast != null) {
            fast = fast.next;
            p = slow;
            slow = slow.next;
        }
        if (p == null) {
            head = head.next;
        } else {
            p.next = p.next.next;
        }
        return head;
    }

    /**
     * 两个有序链表排序
     * @param a
     * @param b
     * @return
     */
    public static Node mergeSortedLists(Node a, Node b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        Node p = a;
        Node q = b;
        Node head = null;
        if(p.data < q.data){
            head = p;
            p = p.next;
        }else{
            head = q;
            q = q.next;
        }
        Node r = head;
        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }
        return head;
    }

}

