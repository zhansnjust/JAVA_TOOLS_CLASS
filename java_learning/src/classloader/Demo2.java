package classloader;

public class Demo2 extends Super{
	static {
		System.out.println("Demo2 static ");
	}
	Apple a=new Apple();
	static Orig o=new Orig();
	public Demo2() {
		System.out.println("demo2");
	}
	{
		System.out.println("demo2 block");
	}
	public static void main(String[] args) {
		new Demo2();
	}
}
class Super{
	static{
		System.out.println("super static");
	}
	
	public Super() {
		System.out.println("super");
	}	
	{
		System.out.println("super block");
	}
}
class Apple{
	public Apple() {
		System.out.println("apple is init");
	}
}
class Orig{
	public Orig() {
		System.out.println("orig is init");
	}
}