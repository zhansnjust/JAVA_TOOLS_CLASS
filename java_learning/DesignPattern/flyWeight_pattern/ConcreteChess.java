package flyWeight_pattern;

public class ConcreteChess implements Chess {
	private String color;
	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void setColor(String color) {
		this.color=color;
	}

	@Override
	public void disPlay(Coordinate c) {
		System.out.println(c.getX()+"-"+c.getY()+"-"+this.color);
	}

}
