package com.swain.programmingpearls;

import static java.lang.Thread.sleep;

/**
 * windows
 *
 * cpu利用率保持50%
 * 画出平滑曲线
 */
public class CpuCurve {
    public static void main(String[] args) throws InterruptedException {
        int busyTime = 10;
        CpuCurve.curve();

//        while(true){
//            long startTime = System.currentTimeMillis();
//            //busy loop:
//            while((System.currentTimeMillis()-startTime)<=busyTime*2)
//                ;
//            Thread.sleep(busyTime);
//        }

    }

    public static void curve () throws InterruptedException {
        final int SAMPLING_COUNT = 200;
        final double PI = 3.1415926535;
        final int TOTAL_AMPLITUDE = 300;

        int[] busySpan = new int[SAMPLING_COUNT];
        int amplitude = TOTAL_AMPLITUDE/2;
        double radian = 0.0;
        double radianIncrement = 2.0/(double)SAMPLING_COUNT;
        for(int i=0;i<SAMPLING_COUNT;i++){
            busySpan[i] = (int)(amplitude+Math.sin(PI*radian)*amplitude);
            radian += radianIncrement;
        }

        long startTime = 0;
        for(int j=0;;j=(j+1) % SAMPLING_COUNT){
            startTime = System.currentTimeMillis();
            while((System.currentTimeMillis()-startTime)<=busySpan[j])
                ;
            Thread.sleep(TOTAL_AMPLITUDE-busySpan[j]);
        }
    }
}
