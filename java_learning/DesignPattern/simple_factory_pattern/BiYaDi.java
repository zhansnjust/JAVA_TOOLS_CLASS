package simple_factory_pattern;

public class BiYaDi implements Car {

	@Override
	public void run() {
		System.out.println("比亚迪");
	}
	public static void main(String[] args) {
		for(int i=1;i<7;i++)
		{
			for(int j=1;j<i&&j<7;j++)
			{
				for(int k=1;k<j&&k<7;k++)
				{
					if((i+k+j)==10)
						System.out.println(i+"-"+j+"-"+k);
				}
			}
		}
	}
}
enum a{
	A,B
}