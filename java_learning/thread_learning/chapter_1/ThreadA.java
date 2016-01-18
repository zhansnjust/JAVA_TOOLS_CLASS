package chapter_1;

public class ThreadA extends Thread {
	private MyService myService;
	public ThreadA(MyService m) {
		this.myService=m;
	}
	@Override
	public void run() {
		myService.await();
	}
}
