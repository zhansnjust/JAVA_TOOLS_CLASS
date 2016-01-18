package dymaticProxy_demo;

public class MyProxied implements Proxied {

	@Override
	public void method1() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("method1");
	}

	@Override
	public void method2(String str) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(str);
	}

}
