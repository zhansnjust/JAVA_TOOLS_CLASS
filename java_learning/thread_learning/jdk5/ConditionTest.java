package jdk5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
	public static void main(String[] args) {
		final Sub sub=new Sub();
		new Thread(new Runnable() {
			public void run() {
				for(int i=1;i<5;i++)
					sub.show(i);
			}
		}).start();
		for(int i=1;i<5;i++)
			sub.print(i);
	}
	static class Sub {
		private boolean flag = true;
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		public void show(int i) {
			lock.lock();
			try {
				while (!flag) {
					try {
						condition.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j < 10; j++) {
					System.out.println("show thread squence of" + j + ",loop of" + i);
				}
				flag = false;
				condition.signal();
			} finally {
				lock.unlock();
			}

		}

		public void print(int i) {
			lock.lock();
			try {
				while (flag) {
					try {
						condition.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				for (int j = 1; j < 10; j++) {
					System.out.println("print  thread squence of" + j + ",loop of" + i);
				}
				flag = true;
				condition.signal();
			} finally {
				lock.unlock();
			}
		}
	}
}
