package string_learning;

import collection_learing.MyArrayList;

public class Test_MyArrayList {

	public static void main(String[] args) {
		String s1 = new String("haha1");
		MyArrayList list = new MyArrayList();
		list.add(s1);
		for (int i = 0; i < list.size; i++)
			System.out.print(list.get(i) + "-");
	}

}
