package atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private AtomicInteger  atom=new AtomicInteger(0);
	private int i=0;
	public static void main(String[] args) {
		final Counter c= new Counter();
		List<Thread> list=new ArrayList<>();
		for(int j=0;j<100;j++)
		{
			Thread t=new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i=0;i<10000;i++)
					{
						c.count();
						c.safeCount();
					}
				}
			});
			list.add(t);
		}
		for(Thread tt:list)
			tt.start();
		for(Thread tt:list)
			try {
				tt.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(c.i);
		System.out.println(c.atom.get());
	}
	private void safeCount()
	{
		for(;;)
		{
			int i=atom.get();
			boolean suc=atom.compareAndSet(i, ++i);
			if(suc)
				break;
		}
	}
	private void count()
	{
		i++;
	}
}
