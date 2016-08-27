package product.customer;

import java.util.LinkedList;

public class WaitNotify {
	final private LinkedList<Object> queue = new LinkedList<>();
	final int MAX = 10;

	public WaitNotify() {
	}

	void start() {
		new Producter().start();
		new Customer().start();
	}

	public static void main(String[] args) {
		new WaitNotify().start();
	}

	class Producter extends Thread {
		@Override
		public void run() {

			while (true) {
				synchronized (queue) {
					try {
						while (queue.size() == MAX) {
							System.out.println("仓库已经满了");
							queue.wait();
						}
						Object o = new Object();
						if (queue.add(o)) {
							System.out.println("producter create one object");
							Thread.sleep((long) (Math.random() * 3000));
							queue.notify();
						}

					} catch (InterruptedException ie) {
						System.out.println("producer is interrupted!");
					}

				}
			}

		}
	}

	class Customer extends Thread {
		@Override
		public void run() {
				synchronized (queue) {
					while (true) {
					try {
						while (queue.size() == 0) {
							System.out.println("storeHouse is empty , please wait");
							queue.wait();
						}
						queue.removeLast();
						System.out.println("Comsumer get  a Object from storeHouse");
						Thread.sleep((long) (Math.random() * 3000));
						queue.notify();
					} catch (InterruptedException e) {
						System.out.println("customer is interupted");
					}
				}
			}
		}
	}
}
