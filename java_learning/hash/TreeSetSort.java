import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeSetSort {
	public static void main(String[] args) {
		String s="hkdasflkadzcxklfhalkfadlsjgka;dlsjgasdjfiudashfldlalfdkfjadfjkczdcda";
		TreeMap<Character, Integer> map=new TreeMap<>();
		for(int i=0;i<s.length();i++)
		{
			char tmp=s.charAt(i);
			if(map.containsKey(tmp))
			{
				int count=map.get(tmp);
				map.put(tmp, count+1);
			}
			else
				map.put(tmp, 1);
		}
		System.out.println(map);
		ArrayList<Entry<Character, Integer>> list=new ArrayList<>(map.entrySet());
		Collections.sort(list,new Comparator<Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
		});
		
		System.out.println(list);
	}
	
}
