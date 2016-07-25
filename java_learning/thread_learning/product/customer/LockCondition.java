package product.customer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {
	 static LinkedList<Object> list=new LinkedList<>();
	final static  private Lock lock=new ReentrantLock();
	final static  private Condition notFull=lock.newCondition();
	final  static private Condition notEmpty=lock.newCondition();
	final static  int MAX=10;
	public LockCondition() {
	}
	public static void main(String[] args) {
		new Product1().start();
		new Customer1().start();
	}
	
	static class Product1 extends Thread{
		@Override
		public void run() {
			while(true)
			{
				lock.lock();
				try
				{
					while(list.size()==MAX)
					{
						System.out.println("仓库已满");
						notFull.await();
					}
					list.add(new Object());
					System.out.println("生产了一个产品,当前产品个数："+list.size());
					Thread.sleep((long) (Math.random() * 3000));
					notEmpty.signal();
				}catch(Exception e)
				{
					System.out.println("生产异常");
				}
				finally{
					lock.unlock();
				}
			}
		}
	}
	
	static class Customer1 extends Thread{
		@Override
		public void run() {
			while(true)
			{
				lock.lock();
				try
				{
					while(list.size()==0)
					{
						System.out.println("仓库为空，没有可以消费的");
						notEmpty.await();
					}
					list.removeFirst();
					System.out.println("消费了一个产品,当前产品个数："+list.size());
					Thread.sleep((long) (Math.random() * 3000));
					notFull.signal();
				}catch(Exception e)
				{
					System.out.println("消费异常");
				}
				finally{
					lock.unlock();
				}
			}
		}
	}
	
}
