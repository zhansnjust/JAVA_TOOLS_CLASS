package product.customer;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlock {
	private static final LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<>(5);
	public static void main(String[] args) {
		new Thread(new Pro()).start();
		new Thread(new Cus()).start();
	
	}
	static class Pro implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					Object o=new Object();
					list.put(o);
					System.out.println("生产了一个对象.当前个数:"+list.size());
				} catch (InterruptedException e) {
					
				}
			}
		}

	}

	static class Cus implements Runnable {

		@Override
		public void run() {
			while(true)
			{
				try{
					list.take();
					System.out.println("消费了一个对象,当前个数："+list.size());
				}catch(InterruptedException e)
				{
					
				}
			}
		}

	}
}
