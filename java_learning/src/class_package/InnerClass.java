package class_package;

public class InnerClass {
	static
	{
		System.out.println("父类的static blob");
	}
	public InnerClass() {
		System.out.println("init");
	}
	public static void main(String[] args) {
		new Sbu();
	}
	public static void test(final int a)
	{
		final int b=1;
		@SuppressWarnings("unused")
		class Sub
		{
			int a=2;
			public void test1()
			{
				System.out.println(b);
			}
		}
	}
	 static int c=1;
	static class Sbu extends InnerClass{
		public Sbu() {
			System.out.println("sub init");
		}
		 static void f()
		{
			System.out.println(c);
		}
	}
	int d=1;
	class SS{
		void f()
		{
			System.out.println(c);
			System.out.println(d);
			new Runnable()
			{

				@Override
				public void run() {
					// TODO Auto-generated method stub
					
				}
				
			};
		}
	}
	Runnable runnable = new Runnable() {
		public void run() {
			
		}
	};
	
}
