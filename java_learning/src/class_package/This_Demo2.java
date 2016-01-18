package class_package;
//this 在普通方法中指当前对象，所以在普通方法中加不加this效果一样， 在构造方法中指正在初始化的对象。
//本例中，子类构造器调super(), 在父类的构造器中调用show()，即this.show。this指正在初始化的对象即子类，所以 调用的是子类的show方法
//调用子类的show时，子类的静态name 初始化为Null
public class This_Demo2 {
	private static String name="haha";
	public This_Demo2() {
		System.out.println("当前this指向的对象："+this.getClass().getName());
		show();
	}

	void show() {
		System.out.println(name);
	}
	public static void main(String[] args) {
		new This_Sub2();
	}
}

class This_Sub2 extends This_Demo2 {
	private static String name;
	public This_Sub2	() {
		super();
	}

	void show() {
		System.out.println(name);
	}
}