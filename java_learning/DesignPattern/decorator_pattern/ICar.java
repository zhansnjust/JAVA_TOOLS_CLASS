package decorator_pattern;

public interface ICar {
	void move();
}
class car implements ICar{

	@Override
	public void move() {
		System.out.println("地上跑的车");
	}
	
}