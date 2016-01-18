package java_learning;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KillLock {
	public static void main(String[] args) {
		final Lock l1=new ReentrantLock();
		final Lock l2=new ReentrantLock();
		new Thread(new Runnable() {
			public void run() {
				try {
					l1.lock();
					Thread.sleep(100);
					l2.lock();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					l1.unlock();
					l2.unlock();
				}
				
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				try {
					l2.lock();
					l1.lock();
				}finally {
					l1.unlock();
					l2.unlock();
				}
				
			}
		}).start();
	}
}
