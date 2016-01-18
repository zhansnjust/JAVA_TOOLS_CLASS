package simple_factory_pattern;

public class Factory {
	public static Car getBiYaDi()
	{
		return new BiYaDi();
	}
	public static Car getRemove()
	{
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("测试匿名内部类实现多线程");
			}
		}).start();
		return new Remove();
	}
}
