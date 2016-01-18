package prototype_pattern;

import java.util.Date;

public class DeepClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date d1=new Date(15454515l);
		SheepDeep s=new SheepDeep("小sheep", d1);
		System.out.println(s);
		SheepDeep s1=(SheepDeep) s.clone();
		System.out.println(s1);
		System.out.println("after update");
		d1=new Date();
		System.out.println(s);
		System.out.println(s1);
	}
}
