package jdk5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
	public static void main(String[] args) {
		ExecutorService service=Executors.newCachedThreadPool();
		final CountDownLatch cd1=new CountDownLatch(1);
		final CountDownLatch cd2=new CountDownLatch(5);
		for(int i=0;i<5;i++)
		{
			Runnable run=new Runnable() {
				
				@Override
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName()+"正准备接受起跑信号...");
						cd1.await();
						Thread.sleep((long)(Math.random()*10000));
						System.out.println(Thread.currentThread().getName()+"达到终点");
						cd2.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			};
			service.submit(run);
		}
		
		try {
			Thread.sleep((long)(Math.random()*10000));
			System.out.println(Thread.currentThread().getName()+"起跑！！！！！！！！！！");
			cd1.countDown();
			System.out.println("大家开始跑");
			cd2.await();
			System.out.println(Thread.currentThread().getName()+"已经收到结果");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.shutdown();
		
	}
}	
