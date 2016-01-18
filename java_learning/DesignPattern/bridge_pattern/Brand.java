package bridge_pattern;

public interface  Brand {
	void sale();
}
class Lenovo implements Brand
{

	@Override
	public void sale() {
		System.out.println("出售联想电脑");
	}
	
}
class dell implements Brand{

	@Override
	public void sale() {
		System.out.println("出售戴尔电脑");
	}
	
}