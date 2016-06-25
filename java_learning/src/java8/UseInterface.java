package java8;

import java.util.concurrent.TimeUnit;

public class UseInterface implements InterA ,InterB {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
				{
					try {
						TimeUnit.SECONDS.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	@Override
	public void spw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void spw(int a) {
		// TODO Auto-generated method stub
		
	}

}
interface InterA{
	public void spw();
}
interface InterB{
	public void spw(int a);
}
