package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ForEach {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("hello");
		list.add("java");
		list.add("php");
		list.add("python");
		list.add("c++");
		list.forEach(System.out :: println);
		List<String> ls=list.stream().filter((x)->x.contains("p")).collect(Collectors.toList());
		System.out.println(ls);
		System.out.println(A.b+"***");
	}
}
class A{
	static{
		b=6;
	}
	static int b=9;
}
