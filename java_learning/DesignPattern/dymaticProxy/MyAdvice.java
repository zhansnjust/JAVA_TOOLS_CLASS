package dymaticProxy;

import java.lang.reflect.Method;

public class MyAdvice implements Advice {
	long beginTime=0;
	@Override
	public void beforeMethod(Method m) {
		beginTime=System.currentTimeMillis();
		System.out.println("start----------------");
	}

	@Override
	public void afterMethod(Method m) {
		long endTime=System.currentTimeMillis();
		System.out.println("over-------------");
		System.out.println(m.getName()+"方法执行了"+(endTime-beginTime)+"毫秒");
	}

}
