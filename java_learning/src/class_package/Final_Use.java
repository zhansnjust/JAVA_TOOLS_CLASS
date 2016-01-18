package class_package;

public class Final_Use {
	public static void main(String[] args) {
		final int a[]=new int[10];
		printArr(a);
		a[1]=1;
		printArr(a);
		//a=new int[11];
		final Peo o=new Peo();
		o.age=11;
		System.out.println(o);
		o.age=123;
		System.out.println(o);
		//不能改变o的指向 
		//o=new Peo(111);
	}
	static void printArr(int a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}
class Peo{
	public int age;
	public Peo() {

	}
	public Peo(int age)
	{
		this.age=age;
	}
	@Override
	public String toString() {
		return "age:"+this.age;
	}
}
