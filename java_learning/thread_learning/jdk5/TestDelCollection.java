package jdk5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//遍历集合的时，删除集合元素必须用迭代器删除， 否则会出错
public class TestDelCollection {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			int temp = it.next();
			if (temp == 2)
				it.remove();
		}
		System.out.println(list);
		List<String> famous = new ArrayList<String>();
		famous.add("liudehua");
		famous.add("madehua");
		famous.add("liushishi");
		famous.add("tangwei");
		Iterator<String> itt=famous.iterator();
		while(itt.hasNext())
		{
			String temp=itt.next();
			if("madehua".equals(temp))
				itt.remove();
					
		}
		System.out.println(famous);
	}
}
