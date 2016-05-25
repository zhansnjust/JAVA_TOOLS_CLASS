package chapter_1;

import java.util.concurrent.LinkedBlockingQueue;
@SuppressWarnings("all")
public class ProductCustomer {
	
	public static void main(String[] args) {
		 LinkedBlockingQueue sharedQueue = new LinkedBlockingQueue();
	     //Creating Producer and Consumer Thread
	     Thread prodThread = new Thread(new Producer(sharedQueue));
	     Thread consThread = new Thread(new Consumer(sharedQueue));
	 
	     //Starting producer and Consumer thread
	     prodThread.start();
	     consThread.start();
	}

}
@SuppressWarnings("all")
class Producer implements Runnable {
	 
    private final LinkedBlockingQueue sharedQueue;
 
    public Producer(LinkedBlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
 
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
            }
        }
    }
 
}
 
//Consumer Class in Java
@SuppressWarnings("all")
class Consumer implements Runnable{
 
    private final LinkedBlockingQueue sharedQueue;
 
    public Consumer (LinkedBlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
 
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
            }
        }
    }
}
