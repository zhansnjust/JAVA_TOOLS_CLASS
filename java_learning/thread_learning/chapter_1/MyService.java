package chapter_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	private Lock lock= new ReentrantLock();
	public Condition condition=lock.newCondition();
	public void await()
	{
		try {
			lock.lock();
			System.out.println("await time is:"+System.currentTimeMillis());
			condition.await();
			System.out.println("aa");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public void signal()
	{
		try{
			lock.lock();
			System.out.println("signal time is:"+System.currentTimeMillis());
			condition.signal();
		}
		finally{
			lock.unlock();
			System.out.println("bb");
		}
	}
}
