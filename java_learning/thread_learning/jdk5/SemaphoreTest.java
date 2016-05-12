package jdk5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {
		ExecutorService service=Executors.newCachedThreadPool();
		final  Semaphore sp=new Semaphore(3);
		for(int i=0;i<10;i++)
		{
			Runnable runnable=new Runnable() {
				
				@Override
				public void run() {
					try {
						sp.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("线程"+Thread.currentThread().getName()+"进入,当前有"+(3-sp.availablePermits())+"并发");
					try {
						Thread.sleep((long)(Math.random()*1000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("线程"+Thread.currentThread().getName()+"即将离开");
					sp.release();
					System.out.println("线程"+Thread.currentThread().getName()+"已经离开,还有"+(3-sp.availablePermits())+"并发");
				}
			};
			service.submit(runnable);
		}
		service.shutdown();
	}
	
}
