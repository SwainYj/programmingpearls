package com.swain.programmingpearls;

/**
 * 两个将排列一共多少可能
 */
public class 象棋chess {
    public static void main (String[] args) {
        象棋chess chess = new 象棋chess();
        chess.impossible2();
    }

    public void impossible() {
        int[] jiang = {1,2,3,4,5,6,7,8,9};
        int[] shuai = {1,2,3,4,5,6,7,8,9};

        int m = 0;
        for (int i = 1; i<=jiang.length; i++) {
            for (int j =1; j<=shuai.length; j++) {
                if (i%3 == j%3) {
                    m++;
                    System.out.println("布局: i: "+i+" , j:"+j);
                }
            }
        }
    }

    public void impossible2() {
        int i = 81;
        while(i-- > 0) {
            if (i / 9 % 3 == i % 9 % 3)
                continue;
            System.out.printf("A= %d, B=%d", i/9+1, i%9+1);
        }
    }
}
