package dymaticProxy_demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler{
	private  Object proxied;
	public MyProxy(Object proxied) {
		this.proxied=proxied;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long start=System.currentTimeMillis();
		System.out.println("before proxy:");
		Object re=method.invoke(proxied, args);
		System.out.println(this.getClass().getSimpleName()+ " has waste:"+(System.currentTimeMillis()-start)+"");
		System.out.println("after proxy:");
		return re;
	}

}
