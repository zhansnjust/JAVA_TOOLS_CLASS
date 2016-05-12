package jdk5;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchagerTest {
	public static void main(String[] args) {
		final Exchanger<String> exchange = new Exchanger<>();
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new Runnable() {

			@Override
			public void run() {
				try {
					String data1 = "一张羊皮";
					System.out.println(Thread.currentThread().getName() + "换出的数据是" + data1);
					String data2 = exchange.exchange(data1);
					Thread.sleep((long) (Math.random() * 10000));
					System.out.println(Thread.currentThread().getName() + "换回来的数据是" + data2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		service.execute(new Runnable() {

			@Override
			public void run() {
				try {
					String data1 = "一袋大米";
					System.out.println(Thread.currentThread().getName() + "换出的数据是" + data1);
					String data2 = exchange.exchange(data1);
					Thread.sleep((long) (Math.random() * 10000));
					System.out.println(Thread.currentThread().getName() + "换回来的数据是" + data2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		service.shutdown();
	}
}
