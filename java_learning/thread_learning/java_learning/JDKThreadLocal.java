package java_learning;

import java.util.Random;

public class JDKThreadLocal {
	public static void main(String[] args) {
		for(int i=1;i<5;i++)
		{
			new Thread(new Runnable() {
				public void run() {
					 int data=new Random().nextInt();
					 MyThreadScopeData.getIntances().setName(data+"-");
					 MyThreadScopeData.getIntances().setAge(data);
					 new A().get();
					 new B().get();
				}
			}).start();
		}
	}
	static class A {
		public void get() {
			MyThreadScopeData data=MyThreadScopeData.getIntances();
			System.out.println("A from "+Thread.currentThread().getName()+"  getData  "+data.getName()+" , "+data.getAge());
		}
	}

	static class B {
		public void get() {
			MyThreadScopeData data=MyThreadScopeData.getIntances();
			System.out.println("B from "+Thread.currentThread().getName()+" getData "+data.getName()+","+data.getAge());
		}
	}
}
class MyThreadScopeData
{
	private static ThreadLocal<MyThreadScopeData> threadLocal=new ThreadLocal<>();
	private  MyThreadScopeData() {
	}
	public  static MyThreadScopeData getIntances()
	{
		MyThreadScopeData mData=threadLocal.get();
		if(mData==null)
		{
			mData=new MyThreadScopeData();
			threadLocal.set(mData);
		}
		return mData;
	}
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}