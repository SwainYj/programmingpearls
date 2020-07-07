package com.swain.programmingpearls;

/**
 * 链表基础操作
 * 1.链表的增删操作
 * 2.链表反转
 * 3.查找链表的中间位置
 * 4.查找链表中是否有环
 * 5.寻找环的位置
 * author: swain
 */
//存储结点信息
class NodeOfLink {
    NodeOfLink next = null;
    int data;
    public NodeOfLink(int data) {this.data = data; }
}

public class LinkList {
    NodeOfLink head = null;
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.addNode(1);
        linkList.addNode(4);
        linkList.addNode(7);
        linkList.addNode(11);
        linkList.printLink();
        linkList.deleteNode(2);
        linkList.printLink();
        linkList.reverseLink();
        linkList.printLink();
    }

    //添加结点
    public void addNode(int d) {
        NodeOfLink nodeOfLink = new NodeOfLink(d);
        if (head == null) {
            head = nodeOfLink;
            return;
        }
        NodeOfLink temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = nodeOfLink;
        return;
    }

    /**
     * 删除第i个结点
     * @param index
     * @return
     */
    public boolean deleteNode(int index) {
        //判断下标合法性
        if (index < 1 || index > getLength()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 2;
        NodeOfLink preNode = head;
        NodeOfLink curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return true;
    }

    /**
     * 获取链表长度
     * @return
     */
    public int getLength() {
        int length = 0;
        NodeOfLink temp = head;
        while (temp != null) {
            length ++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 打印链表
     */
    public void printLink() {
        NodeOfLink temp = head;
        System.out.print("打印链表：");
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 链表反转
     */
    public void reverseLink() {
        NodeOfLink revPreNode = head;
        NodeOfLink pNode = head;
        NodeOfLink pPrev = null;
        while (pNode != null) {
            NodeOfLink pNext = pNode.next;
            if (pNext == null) {
                revPreNode = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        this.head = revPreNode;
    }



}
