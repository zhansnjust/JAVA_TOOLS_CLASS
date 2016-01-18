package chainOfResponsibility;

public class FilterImplement1 implements Filter {

	@Override
	public void doFilter(Request req, Response res, Filter filterChain) {
		req.request+="       filter1";
		
		filterChain.doFilter(req, res, filterChain);
		
		res.response+="      filter1";
	}

}
