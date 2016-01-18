package string_learning;


public class OrgnalCodeAnalysis {
	private static String str=new String("jj");
	private String str1="jj";
	public static void main(String[] args) {
		String s1="abc";
		String s2="abc";
		System.out.println(s1==s2);
		int a[]={1,2,3,4,5};
		System.arraycopy(a, 3, a, 0, 2);
		for(Integer i:a)
			System.out.println(i);
		replace(str);
		System.out.println(str);
		OrgnalCodeAnalysis oc=new OrgnalCodeAnalysis();
		oc.replace1(oc.str1);
		System.out.println(oc.str1);
	}
	static void replace(String str)
	{
		str="update";
	}
	void replace1(String str)
	{
		str="update";
	}
}
