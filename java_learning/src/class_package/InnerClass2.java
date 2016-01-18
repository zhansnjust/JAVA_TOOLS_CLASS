package class_package;

import class_package.Sub1.Inner2;

public class InnerClass2 {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		class Main
		{
		}
	}

	void f() {
		Sub1 s1 = new Sub1();
		@SuppressWarnings("unused")
		Sub1.InnerClass ss = s1.new InnerClass();
		@SuppressWarnings("unused")
		Inner2 inne = new Inner2();

	}
}

class Sub1 {
	class InnerClass {
		//成员内部类不能定义static field
		//static int a;
	}

	static class Inner2 {
	}
}