package PrintOddEvenNumber;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    volatile static boolean curvalEven=true;
    public static void main(String[] args) {

        Lock lock=new ReentrantLock();
        Condition e= lock.newCondition();
        Condition o= lock.newCondition();
        Runnable odd=()->{
            for(int i=1;i<10;i=i+2){
                lock.lock();
                try {
                    while (curvalEven) {
                        try {
                            o.await();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    System.out.println("odd " + i);
                    curvalEven=true;
                    e.signal();
                }finally {
                    lock.unlock();
                }
            }
        };

        Runnable even=()->{
            for(int i=0;i<10;i=i+2){
                lock.lock();
                try {
                    while (!curvalEven) {
                        try {
                            e.await();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    System.out.println("even " + i);
                    curvalEven=false;
                    o.signal();
                }finally {
                    lock.unlock();
                }
            }
        };

        new Thread(even).start();
        new Thread(odd).start();


    }
}
