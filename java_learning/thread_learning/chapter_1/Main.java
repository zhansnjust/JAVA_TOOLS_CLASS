package chapter_1;

public class Main {
	public static void main(String[] args) {
		MyService service=new MyService();
		ThreadA thread=new ThreadA(service);
		thread.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.signal();
	}
}
