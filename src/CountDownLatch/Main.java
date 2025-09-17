package CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Main {
    static CountDownLatch countDownLatch=new CountDownLatch(3);
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<3;i++){
            new Thread(()->{
                System.out.println("Thread "+Thread.currentThread().getName()+" running");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("work by thread "+Thread.currentThread().getName()+" done");
                countDownLatch.countDown();

            }).start();
        }

        System.out.println("main THREAD IS DONE, NOW I WILL WAIT FOR OTHER THREAD TO COMPLETE AND THEN MOVE FORWARD");
        countDownLatch.await();
        System.out.println("all threads done and now main thread can also complete");
    }
}
