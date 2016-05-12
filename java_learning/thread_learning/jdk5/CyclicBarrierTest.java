package jdk5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		ExecutorService service=Executors.newCachedThreadPool();
		//跑一遍  3个线程到某个点再继续  ,几个线程同时到达,才继续执行
		final CyclicBarrier cb=new CyclicBarrier(3);
		for(int i=0;i<3;i++)
		{
			Runnable run=new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep((long)(Math.random()*10000));
						System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合点1,当前已有"+(cb.getNumberWaiting()+1)+"已经到达");
						cb.await();
						Thread.sleep((long)(Math.random()*10000));
						System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合点2,当前已有"+(cb.getNumberWaiting()+1)+"已经到达");
						cb.await();
						Thread.sleep((long)(Math.random()*10000));
						System.out.println("线程"+Thread.currentThread().getName()+"即将到达集合点3,当前已有"+(cb.getNumberWaiting()+1)+"已经到达");
						cb.await();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			};
			service.submit(run);
		}
		service.shutdown();
	}
}
