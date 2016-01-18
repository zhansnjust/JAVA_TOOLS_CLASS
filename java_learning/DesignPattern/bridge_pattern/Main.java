package bridge_pattern;

public class Main {
	public static void main(String[] args) {
		Computer c1=new Desktop(new dell());
		c1.sale();
		
		Computer c2=new Laptop(new Lenovo());
		c2.sale();
	}
}
