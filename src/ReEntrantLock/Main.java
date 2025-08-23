package ReEntrantLock;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ReEntrantLockResource resource=new ReEntrantLockResource();
        Thread t1=new Thread(()->resource.method1());
        Thread t2=new Thread(()->resource.method1());
        Thread t3=new Thread(()->resource.method1());

        t1.start();
        t2.start();
        t3.start();

        System.out.println("main is finished");
    }
}