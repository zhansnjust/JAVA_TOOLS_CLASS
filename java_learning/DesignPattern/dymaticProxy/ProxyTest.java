package dymaticProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

public class ProxyTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ReflectiveOperationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazzProxy=Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
		System.out.println(clazzProxy.getName());
		System.out.println("构造方法有：");
		Constructor<?>[] cns=clazzProxy.getConstructors();
		
		for(Constructor<?> c:cns)
		{ 
			String name=c.getName();
			StringBuffer sb=new StringBuffer(name);
			sb.append('(');
			Class<?>[] cparam=c.getParameterTypes();
			for(Class<?> cpname:cparam)
			{
				sb.append(cpname.getName()).append(',');
			}
			sb.append(')');
			System.out.println(sb);
		}
		//生成一个有参构造器
		Constructor<?>  c=clazzProxy.getConstructor(InvocationHandler.class);
		class myInvocationHandler implements InvocationHandler{

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return 100;
			}
			
		}
		//第一种产生实例的方法
		Collection<?> instance1=(Collection<?>) c.newInstance(new myInvocationHandler());
		System.out.println(instance1.size());
		
		//第二种产生实例的方式，使用proxy类的静态方法
		@SuppressWarnings("unchecked")
		Collection<String> instance2=(Collection<String>) Proxy.newProxyInstance(Collection.class.getClassLoader(), 
				new Class[]{Collection.class},
				new InvocationHandler() {
					ArrayList<?> target=new ArrayList<>();
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//打印出代理类的名字，此类是自动生成的，我们不用管。
						System.out.println("excute:"+method.getName());
						//此处invoke一定要传入被代理对象
						return method.invoke(target, args);
					}
				});
		instance2.add("sdS");
		instance2.add("dfaffa");
		//每次调用instance2的方法，都会调用 InvocationHandler里面的invoke方法。!!!!!!
		System.out.println(instance2.size());
			
	}
}

