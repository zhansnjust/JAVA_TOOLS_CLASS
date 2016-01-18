package prototype_pattern;

import java.util.Date;

public class SheepDeep implements Cloneable{
	String name;
	 Date brith;
	public SheepDeep(String name,Date brith) {
		this.name=name;
		this.brith=brith;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object ob=super.clone();
		SheepDeep sd=(SheepDeep) ob;
		sd.brith=(Date) this.brith.clone();
		return ob;
	}

	@Override
	public String toString() {
		return "Sheep [name=" + name + ", brith=" + brith + "]";
	}
}
