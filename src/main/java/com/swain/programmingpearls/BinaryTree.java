package com.swain.programmingpearls;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉排序树实现
 *  节点定义 数据,左节点，右节点
 */
class Node {
    public int data;
    public Node left;
    public Node right;
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    private Node root;
    public BinaryTree() {root = null;}

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] data = {4,8,7,3,2,1,9,5,21};
        binaryTree.buildTree(data);
        System.out.print("二叉树中序遍历：");
        binaryTree.inOrder();
        System.out.print("二叉树先序遍历");
        binaryTree.preOrder();
        System.out.print("二叉树后序遍历");
        binaryTree.postOrder();

        System.out.print("\n层序遍历树：");
        binaryTree.layerTranverse();
    }

    //将数值输入构建二叉树
    public void buildTree(int[] data) {
        for(int i = 0; i < data.length; i++) {
            this.insert(data[i]);
        }
    }
    //新数据的插入
    public void insert(int data) {
        Node newNode = new Node(data);
        if(root == null ) {//空树 赋值root
            root = newNode;
        } else {
            Node current = root; //重根元素开始遍历
            Node parent; // 临时变量
            while(true) { //寻找插入位置
                parent = current;
                if(data < current.data) {
                    current = current.left;
                    if(current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if(current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    //中序遍历树 左-根-右
    public void inOrder(Node localRoot) {
        if(localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.data+" _ ");
            inOrder(localRoot.right);
        }
    }
    public void inOrder() {
        this.inOrder(this.root);
    }
    //先序遍历树 根-左-右
    public void preOrder(Node localRoot) {
        if(localRoot != null) {
            System.out.print(localRoot.data+" _ ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }
    public void preOrder() {
        this.preOrder(this.root);
    }
    //后序遍历树 左-右-根
    public void postOrder(Node localRoot) {
        if(localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data+" _ ");
        }
    }
    public void postOrder() {
        this.postOrder(this.root);
    }

    /**
     * 层序遍历二叉树
     * 先将根节点放入队列中，然后每次都从队列中取出一个节点打印；
     * 若这个节点有子节点，则将它放入队列尾，直到队列为空。
     */
    public void layerTranverse() {
        if(this.root ==null) {
            return ;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(this.root);
        while(!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.data + " ");
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }
    }
}
