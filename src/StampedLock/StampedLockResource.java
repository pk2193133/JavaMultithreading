package StampedLock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockResource {
    int val=1;
    StampedLock lock=new StampedLock();

    public void read(){
       long stamp= lock.tryOptimisticRead();
       System.out.println("value of val is "+val+ " read by Thread "+Thread.currentThread().getName());

       if(!lock.validate(stamp)){
           long stamp2=lock.readLock();
           try {
               System.out.println("value inside read lock is " + val+ " read by Thread "+Thread.currentThread().getName());
           }finally{
               lock.unlockRead(stamp2);
           }
       }
    }

    public void write(){
        long stamp=lock.writeLock();
        try {
            val = 2;
            System.out.println("value is changed to 2 by thread " + Thread.currentThread().getName());
        }finally {
            lock.unlockWrite(stamp);
        }
    }
}
