package chapter_1;

public class VolatileTest extends Thread {
	private   boolean flag=true;
	public void setState(boolean flag)
	{
		this.flag=flag;
	}
	@Override
	public void run() {
		while(flag==true)
		{
			System.out.println("......");
		}
		System.out.println("线程停止");
	}
	public static void main(String[] args) throws InterruptedException {
		VolatileTest thread=new VolatileTest();
		thread.start();
		Thread.sleep(3000);
		thread.setState(false);
		Thread.sleep(2000);
		System.out.println(thread.flag);
	}
}
