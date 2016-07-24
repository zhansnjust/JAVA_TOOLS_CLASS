package simpleInstance;
/*
 * 枚举本身是单例的。 可以避免反射好反序列化的漏洞
 * 
 * 缺点： 无延迟加载。
 * 
 */
public enum EnumSingle {
	//这个元素本身就是单例的。
	INSTANCE;
	
	/**
	 * 可以添加自己需要的方法
	 */
}
