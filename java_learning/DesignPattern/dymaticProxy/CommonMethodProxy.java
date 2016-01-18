package dymaticProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
/* 
 * 	通用的代理方法
 * */
public class CommonMethodProxy {
	//传入被代理的对象，和代理逻辑(代理处理的代码)  target是被代理的对象
	private static Object getProxy(final Object target, final Advice advice) {
		Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//proxy就是代理对象 此处没用到，但是在动态生成代理对象时会用到的
						System.out.println("proxy:"+proxy.getClass().getName());
						advice.beforeMethod(method);
						// target是被代理的对象
						Object ans = method.invoke(target, args);
						advice.afterMethod(method);
						return ans;
					}
				});
		return o;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// target是被代理的对象
		ArrayList<String> target=new ArrayList<>();
		
		//c是产生的代理对象
		Collection<String> c=(Collection<String>) getProxy(target, new MyAdvice());
		c.add("123");
	
		HashSet<Integer> target1=new HashSet<>();
		Set<Integer> set=(Set<Integer>) getProxy(target1, new MyAdvice());
		set.add(123);
		
	}
}
