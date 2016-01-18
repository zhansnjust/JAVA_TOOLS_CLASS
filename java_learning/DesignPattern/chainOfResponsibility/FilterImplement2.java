package chainOfResponsibility;

public class FilterImplement2  implements Filter{

	@Override
	public void doFilter(Request req, Response res, Filter filterChain) {
		// TODO Auto-generated method stub
		req.request+="          filter2";
		filterChain.doFilter(req, res, filterChain);
		res.response+="         filter2";
	}

}
