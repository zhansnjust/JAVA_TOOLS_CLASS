package classloader;

public class Demo1 {

	public static void main(String[] args) {
		
	}
	void test()
	{
		Car car=new Car(){
			void run() {
				System.out.println("子类的run");
			};
		};
		car.run();
		
	}
}
class Car{
	void run()
	{
		
	}
}
