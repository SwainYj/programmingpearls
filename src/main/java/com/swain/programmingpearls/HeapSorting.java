package com.swain.programmingpearls;

/**
 * 堆排序实现
 * 完全二叉树有一个性质是，除了最底层，每一层都是满的，这使得堆可以利用数组来表示
 * 对于给定的某个结点的下标 i（从1开始），可以很容易的计算出这个结点的父结点、孩子结点的下标：
 * Parent(i) = floor(i/2)，i 的父节点下标
 * Left(i) = 2i，i 的左子节点下标
 * Right(i) = 2i + 1，i 的右子节点下标
 */
public class HeapSorting {
    public static void main(String[] args) {
        int[] a = new int[] {33, 9, 8, 10, 32,4,5};
        Sort(a, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void MaxHeapify(int[] a, int index, int size) {
        int left = 2 * index;
        int right = 2 * index + 1;
        int largest = index;
        if (left <= size && a[left] > a[index]) {
            largest = left;
        }
        if (right <= size && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != index) {
            int temp = a[largest];
            a[largest] = a[index];
            a[index] = temp;
            MaxHeapify(a, largest, size);
        }
    }

    public static void HeapBuild(int[] a, int size) {
        for (int i = size / 2; i >= 1; i--) {
            MaxHeapify(a, i, size);
        }
    }

    public static void Sort(int[] a, int size) {
        HeapBuild(a, size);//构建堆
        for (int i = size; i >= 2; i--) {
            //对顶元素与最后一个元素交换
            int temp = a[i];
            a[i] = a[1];
            a[1] = temp;
            MaxHeapify(a, 1, i - 1);
        }
    }
}
