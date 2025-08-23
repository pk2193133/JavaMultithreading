package ReEntrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockResource {

    ReentrantLock lock=new ReentrantLock();

    public void method1(){
        try {
            lock.lock();
            System.out.println("inside method1, current thread is " + Thread.currentThread().getName());
            Thread.sleep(3000);
            method2();
        }catch(Exception e){

        }
        finally {
            lock.unlock();
        }
    }

    private void method2() {
        try {
            lock.lock();
            System.out.println("inside method2, current thread is " + Thread.currentThread().getName());
            Thread.sleep(2000);
        }catch(Exception e){

        }
        finally {
            lock.unlock();
        }
    }
}
