package ReadWriteLock;

import ReEntrantLock.ReEntrantLockResource;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ReadWriteLockResource resource=new ReadWriteLockResource();
        Thread t1=new Thread(()->resource.read());
        Thread t2=new Thread(()->resource.read());
        Thread t3=new Thread(()->resource.write());
        Thread t4=new Thread(()->resource.read());


        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("main is finished");
    }
}