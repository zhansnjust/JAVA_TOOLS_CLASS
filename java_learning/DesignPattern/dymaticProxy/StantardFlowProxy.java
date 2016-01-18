package dymaticProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

public class StantardFlowProxy {
	
	public static  Object getProxy(final Object target) throws Exception
	{
		Object proxy=Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("AOP前");
				Object re= method.invoke(target, args);
				System.out.println("AOP后");
				return re;
			}
		});
		return proxy;
	}
	public static void main(String[] args) throws Exception {
		
		 Class<?>[] inter=ArrayList.class.getInterfaces();
		for(Class<?> oo:inter)
			System.out.println(oo.getName());
		ArrayList<String> target=new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Collection<String> c=(Collection<String>) getProxy(target);
		c.add("123");
	}
}
