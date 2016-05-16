package java_learning;
//线程1执行10次，线程2执行100次， 以此执行50次
public class LoopForThread {
	public static void main(String[] args) {
		final Business b = new Business();
		new Thread() {
			@Override
			public void run() {
				for (int i = 1; i < 51; i++) {
					b.sub(i);
				}
			}
		}.start();
		
		for(int i=1;i<51;i++)
			b.main(i);
	}

	static class Business {
		private boolean flag=true;
		synchronized void sub(int i) {
			while(!flag)
			{
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for (int j = 1; j < 11; j++)
				System.out.println("sub sequence of " + j + " loop of " + i);
			flag=false;
			this.notify();
		}

		synchronized void main(int i) {
			while(flag)
			{
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			for (int j = 1; j < 101; j++)
				System.out.println("main sequence of " + j + " loop of " + i);
			flag=true;
			this.notify();
		}
	}

}
