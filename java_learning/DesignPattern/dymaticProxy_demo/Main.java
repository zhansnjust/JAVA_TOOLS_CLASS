package dymaticProxy_demo;

import java.lang.reflect.Proxy;

public class Main {
	public static void main(String[] args) {
		Proxied proxied=new MyProxied();
		Proxied newProxied=(Proxied) Proxy.newProxyInstance(Proxied.class.getClassLoader(), new Class[]{Proxied.class},
				new MyProxy(proxied));
		newProxied.method1();
		System.out.println("################");
		newProxied.method2("zhansnjust");
	}
}
