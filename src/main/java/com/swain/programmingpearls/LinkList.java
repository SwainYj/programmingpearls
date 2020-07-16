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
        linkList.addNode(13);
        linkList.addNode(7);
//        linkList.printLink();
//        linkList.deleteNode(2);
//        linkList.printLink();
//        linkList.reverseLink();
//        linkList.printLink();

        NodeOfLink n1 = new NodeOfLink(1);
        NodeOfLink n2 = new NodeOfLink(4);
        NodeOfLink n3 = new NodeOfLink(6);
        NodeOfLink n4 = new NodeOfLink(7);
        NodeOfLink n5 = new NodeOfLink(9);
        NodeOfLink n6 = new NodeOfLink(12);
        NodeOfLink n7 = new NodeOfLink(14);
        NodeOfLink n8 = new NodeOfLink(9);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		n7.next=n8;
		n8.next=n6;
//		linkList.printLink(n1);
        System.out.println(linkList.hasLeap(n1).data);
        System.out.println(linkList.getIntersectEntry(n1).data);
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
    public void printLink(NodeOfLink n1) {
        NodeOfLink temp = n1;
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

    /**
     * 查找链表中是否有环
     */
    public NodeOfLink hasLeap(NodeOfLink n1) {
        NodeOfLink one = n1;
        NodeOfLink two = n1;
        while (one == null || two == null) {
            return null;
        }
        while (null != two.next && null != two.next.next) {
            one = one.next;
            two = two.next.next;
            if (one == two) {
                return two;
            }
        }
        return null;
    }
    /**
     * 获取环入口
     *
     */

    public NodeOfLink getIntersectEntry(NodeOfLink n1) {
        NodeOfLink meet = hasLeap(n1);
        if (meet == null) {
            return null;
        }
        NodeOfLink p = meet;
        NodeOfLink q = n1;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }



}
