package simpleInstance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;

public class ClientTest {
	public static void main(String[] args)
			throws ClassNotFoundException, IOException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException {
//		EnumSingle instance = EnumSingle.INSTANCE;
//		EnumSingle instance1 = EnumSingle.INSTANCE;
//		System.out.println(instance == instance1);
//		ReveseSerializable();
		//Refect();
		CheckTime();
	}

	static final void ReveseSerializable() throws IOException, ClassNotFoundException {
		System.out.println(Simple.getInstance());
		System.out.println(Simple.getInstance());
		FileOutputStream fo = new FileOutputStream("a.txt");
		ObjectOutputStream oo = new ObjectOutputStream(fo);
		oo.writeObject(Simple.getInstance());
		oo.close();
		fo.close();

		ObjectInputStream oi = new ObjectInputStream(new FileInputStream("a.txt"));
		Simple s1 = (Simple) oi.readObject();

		System.out.println(s1);
		oi.close();

	}

	@SuppressWarnings(value = { "all" })
	static void Refect() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = Class.forName("simpleInstance.Simple");
		Constructor<Simple> construct = clazz.getDeclaredConstructor(null);
		System.out.println(Simple.getInstance());
		construct.setAccessible(true);
		Simple s1 = (Simple) construct.newInstance();
		System.out.println(s1);

	}

	static  void CheckTime() throws InterruptedException
	{
		long start=System.currentTimeMillis();
	 CountDownLatch c=new CountDownLatch(10);
		for(int i=1;i<=10;i++)
		{
			new Thread(){
				public void run() 
				{
					for(int k=0;k<1000000;k++)
						Simple.getInstance();
					c.countDown();
				};
			}.start();
		}
		c.await();
		System.out.println(System.currentTimeMillis()-start);
	}
}
