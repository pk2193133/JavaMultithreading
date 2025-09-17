package CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {


    public static void main(String[] args) {
        int barrierCount=3;
        CyclicBarrier cyclicBarrier=new CyclicBarrier(barrierCount,()->{
            System.out.println("all threads have reached the common point, hence common function is running");
        });
        Runnable task=()->{
            System.out.println("thread "+Thread.currentThread().getName()+" started working");
            try {
                Thread.sleep(3000);

            System.out.println("thread "+Thread.currentThread().getName()+" before await");
            cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName()+"is moving forward after barrier");
        };


        for(int i=0;i<3;i++){
            new Thread(task,"worker-"+i).start();
        }
    }
}
