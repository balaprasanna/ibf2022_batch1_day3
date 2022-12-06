public class SimpleThread extends Thread {
        
    public SimpleThread() {}

    @Override
    public void run() {
        System.out.println("Thread started exection + " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        } // wait for some time
        System.out.println("Thread stopped exection + " + Thread.currentThread().getName());
    }
    
}