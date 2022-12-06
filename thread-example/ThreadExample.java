/**
 * ThreadExample
 */
public class ThreadExample {

    public static void main(String[] args) {
        
        System.out.println("MAIN THREAD");

        Thread t1 = new SimpleThread();
        t1.start();
        Thread t2 = new SimpleThread();
        t2.start();

        System.out.println("Finished execution");
        System.out.println("Exit");

    }

}