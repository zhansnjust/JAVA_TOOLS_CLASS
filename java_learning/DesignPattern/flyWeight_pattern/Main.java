package flyWeight_pattern;

public class Main {
	public static void main(String[] args) {
		Chess c1=new ConcreteChess();
		c1.setColor("黑色");
		Chess c2=new ConcreteChess();
		c2.setColor("白色");
		System.out.println(c2);
		System.out.println(c1);
		System.out.println("增加外部状态############");
		c1.disPlay(new Coordinate(5, 10));
		c2.disPlay(new Coordinate(10, 15));
		//可以增加很多位置的棋子，  但是不变的属性只有创建了两个
	}
}	
