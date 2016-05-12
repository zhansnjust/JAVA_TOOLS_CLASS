package classloader;

public class Demo1 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
	
		Single s=Single.getInstance();
		System.out.println(s.a);
		System.out.println(s.b);
	}
}
/*  single s=new single() 放在int b下面,a的值会改变
 * 
 *   1。类的连接中先给静态变量默认值
 *   2。初始化中为类的静态变量正确的初始值（我们定义的）
 *  */

class Single{
	private static  Single s=new Single();
	public static int a=0;
	public static int b;
	
	private Single(){
		System.out.println("init");
		a++;
		b++;
	}
	public static Single getInstance()
	{
		return s;
	}
	public static void main(String[] args) {
		System.out.println(a+"--"+b);
		Single s=new Single();
		Single.Inner si=s.new Inner();
		System.out.println(si.a);
		System.out.println(StaticInner.a);
		@SuppressWarnings("unused")
		 class MethodClass
		{
			private int a=1;
			void shouw()
			{
				
			}
		}
	}
	class Inner{
		int a=1;
	}
	static class StaticInner{
		static int a=10;
	}
}