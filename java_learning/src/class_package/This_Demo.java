package class_package;
//this 在普通方法中指当前对象，所以在普通方法中加不加this效果一样， 在构造方法中指正在初始化的对象。
//本例中，子类构造器调super(), 在父类的构造器中调用show()，即this.show。this指正在初始化的对象即子类，所以 调用的是子类的show方法
public class This_Demo {
	public This_Demo() {
		show();
	}

	void show() {
		System.out.println("夫类的show");
	}
	public static void main(String[] args) {
		new This_Sub();
	}
}

class This_Sub extends This_Demo {
	public This_Sub() {
		super();
	}

	void show() {
		System.out.println("子类的show");
	}
}