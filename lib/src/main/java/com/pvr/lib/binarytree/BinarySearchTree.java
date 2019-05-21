package com.pvr.lib.binarytree;

/**
 * 二叉查找树
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        Node node1 = new Node(16);
        Node node2 = new Node(10);
        Node node3 = new Node(20);
        Node node4 = new Node(9);
        Node node5 = new Node(13);
        Node node6 = new Node(11);
        Node node7 = new Node(14);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node5.right = node7;

//        preOrder(node1);
//        System.out.println();
//        inOrder(node1);
//        System.out.println();
//        postOrder(node1);

//        System.out.println(find(node1, 1)==null?"not found":"found");

//        insert(node1, 19);
//        preOrder(node1);

    }

    /**
     * 查找
     * @param root
     * @param data
     * @return
     */
    public static Node find(Node root, int data){
        Node node = root;
        while (node != null){
            if(data < node.data){
                System.out.println("<<<"+node.data);
                node = node.left;
            }else if(data > node.data){
                System.out.println(">>>"+node.data);
                node = node.right;
            }else{
                System.out.println("==="+node.data);
                return node;
            }
        }
        return null;
    }

    /**
     * 插入
     * @param root
     * @param data
     */
    public static void insert(Node root, int data){
        Node node = root;
        while (node != null){
            if(data < node.data){
                System.out.println("<<<"+node.data);
                if(node.left == null){
                    node.left = new Node(data);
                    return;
                }
                node = node.left;
            }else if(data > node.data){
                System.out.println(">>>"+node.data);
                if(node.right == null){
                    node.right = new Node(data);
                    return;
                }
                node = node.right;
            }
        }
    }

    /**
     * 删除，删除节点分三种情况：
     *      1.如果要删除的节点没有子节点，我们只需要直接将父节点中，指向要删除节点的指针置为null。
     * @param data
     */
    public static void delete(int data){
        // TODO: 5/21/19  
    }

    /**
     * 前序遍历
     * @param node
     */
    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "  ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + "  ");
        inOrder(node.right);
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + "  ");
    }

}
