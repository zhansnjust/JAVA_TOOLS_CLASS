package simpleInstance;

public class Simple {
	private static Simple instance;

	private Simple() {

	}

	// DCL双检查锁机制
	public static Simple getInstance() {
		if (instance == null) {
			try {
				Thread.sleep(3000);
				synchronized (Simple.class) {
					if (instance == null)
						instance = new Simple();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	// 内部类的方式
	private static class MyObjectHander {
		private static Simple ins = new Simple();
	}

	public static Simple getInstance1() {
		return MyObjectHander.ins;
	}

	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				System.out.println(Simple.getInstance().hashCode());
				System.out.println(Simple.getInstance1());
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				System.out.println(Simple.getInstance().hashCode());
				System.out.println(Simple.getInstance1());
			}
		}.start();
		;
		new Thread() {
			@Override
			public void run() {
				System.out.println(Simple.getInstance().hashCode());
				System.out.println(Simple.getInstance1());
			}
		}.start();
		;
	}
}
