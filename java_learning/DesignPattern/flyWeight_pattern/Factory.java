package flyWeight_pattern;

import java.util.HashMap;
import java.util.Map;

public class Factory {
	private static Map<String, Chess> map=new HashMap<>();
	public static Chess getChess(String color)
	{
		if(map.containsKey(color))
			return map.get(color);
		else
		{
			Chess c=new ConcreteChess();
			c.setColor(color);
			map.put(color, c);
			return c;
		}
	}
}
