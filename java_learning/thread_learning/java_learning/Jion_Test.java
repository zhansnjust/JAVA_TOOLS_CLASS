package java_learning;

public class Jion_Test extends Thread {

	public Jion_Test(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i=1;i<100;i++)
		{
			System.out.println(getName()+"--"+i);
		}
	}
	public static void main(String[] args) {
		Jion_Test jt= new Jion_Test("子线程");
		for(int i=1;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+"----"+i);
			if(i==10)
				jt.start();
			if(i==20)
				try {
					jt.join(); //main中调用子线程的join方法，则mian必须在子线程执行结束后才能继续执行
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	}

}
