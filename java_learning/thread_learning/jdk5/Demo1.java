package jdk5;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Demo1 implements Callable<Integer> {
	//线程的第三种实现方式
	public static void main(String[] args) {
		Demo1 d=new Demo1();
		FutureTask<Integer> ft=new FutureTask<>(d);
		for(int i=1;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+"--"+i);
			if(i==20)
				new Thread(ft,"有返回值的线程").start();
		}
		try{
			System.out.println("子线程的返回值"+ft.get());
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}

	@Override
	public Integer call() throws Exception {
		int i;
		for(i=1;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+"--"+i);
		}
		return i;
	}
	

}
