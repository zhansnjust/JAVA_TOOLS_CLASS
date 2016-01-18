package class_package;

public class MultState {
	public static void main(String[] args) {
		HttpServlet hs=new MyService();
		hs.service();
		if  (hs instanceof MyService) {
			MyService temp=(MyService)hs;
			temp.dePost();
		}
	}
}
class HttpServlet{
	void service()
	{
		System.out.println("httpservlet- service");
		System.out.println("当前this指向的类:"+this.getClass().getName());
		doGet();
	}
	void doGet()
	{
		System.out.println("httpservice-- doget");
	}
}
class MyService extends HttpServlet{
	
	void doGet()
	{
		System.out.println("MyService-- doget");
	}
	void dePost()
	{
		System.out.println("myservice post");
	}
}