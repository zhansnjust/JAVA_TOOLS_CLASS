package prototype_pattern;

import java.util.Date;

public class ShawnClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		Date d1=new Date(15454515l);
		Sheep s=new Sheep("小sheep", d1);
		System.out.println(s);
		Sheep s1=(Sheep) s.clone();
		System.out.println(s1);
		System.out.println("after update");
		d1=new Date();
		System.out.println(s);
		System.out.println(s1);
	}

}
