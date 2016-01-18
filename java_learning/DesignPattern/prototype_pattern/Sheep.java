package prototype_pattern;

import java.util.Date;

public class Sheep implements Cloneable{
	 String name;
	 Date brith;
	public Sheep(String name,Date brith) {
		this.name=name;
		this.brith=brith;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Sheep [name=" + name + ", brith=" + brith + "]";
	}
	
}
