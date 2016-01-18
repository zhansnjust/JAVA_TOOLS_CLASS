package chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{
	List<Filter>  list=new ArrayList<>();
	int i=0;
	FilterChain add(Filter f)
	{
		list.add(f);
		return this;
	}
	@Override
	public void doFilter(Request req, Response res, Filter filterChain) {
		if(i==list.size())
			return ;
		Filter temp=list.get(i);
		i++;
		temp.doFilter(req, res, this);
	}

}
