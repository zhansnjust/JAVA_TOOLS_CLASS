package chapter_1;

public class Demo1 {
	public static void main(String[] args) {
		MyThread my=new MyThread();
		Thread A=new Thread(my, "A");
		Thread B=new Thread(my, "A");
		Thread C=new Thread(my, "A");
		Thread D=new Thread(my, "A");
		A.start();
		B.start();
		C.start();
		D.start();
	}
}
class MyThread extends Thread{
	private int count=5;
	@Override
	public synchronized void run() {
			count--;
			System.out.println("由"+Thread.currentThread().getName()+"计算,count="+count);
	}
}