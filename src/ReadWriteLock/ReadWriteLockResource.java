package ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockResource {
    ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    int val=1;
    public void read(){
        lock.readLock().lock();
        try{
            System.out.println("value is "+ val+ "read by thread "+Thread.currentThread().getName());
            Thread.sleep(2000);
        }
        catch(Exception e){

        }
        finally{
            lock.readLock().unlock();
        }
    }

    public void write(){
        lock.writeLock().lock();
        try{
            val=2;
            System.out.println("value of val is "+val+" by thread "+Thread.currentThread().getName());
        }catch (Exception e){

        }finally{
            lock.writeLock().unlock();
        }
    }
}
