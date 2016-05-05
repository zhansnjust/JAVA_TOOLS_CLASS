package genericType;

import java.util.List;

public class GenericTypeTest {
	public static void main(String[] args) {
		
	}
	
	
	public static void method(List<String> list)
	{
		System.out.println("list<String>");
	}
	//下面的方法不能重载， 因为泛型拆除  编译之后二者一样
//	public static void method(List<Integer> list)
//	{
//	}
}
