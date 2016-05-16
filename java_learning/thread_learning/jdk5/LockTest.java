package jdk5;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	public static void main(String[] args) {
		final Outer o = new Outer();
		for (int i = 1; i < 100; i++) {
			new Thread(new Runnable() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						o.print("111111111111111111111");
					}
				}
			}).start();
			new Thread() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						o.print("222222222222222");
					}
				};
			}.start();

		}
	}

	static class Outer {
		// 如下方法会出现线程安全问题， 解决方法。 用synchronized修饰方法。 或者使用lock
		Lock lock = new ReentrantLock();
		void print(String str) {
			int len = str.length();
			lock.lock();
			try {
				for (int i = 0; i < len; i++) {
					System.out.print(str.charAt(i));
				}
			} finally {
				lock.unlock();
			}
			System.out.println();
		}
	}
}
