package chainOfResponsibility;

public class MainTest {
	public static void main(String[] args) {
		Request req=new Request();
		Response res=new Response();
		FilterChain fChain=new FilterChain();
		fChain.add(new FilterImplement1())
		.add(new FilterImplement2());
		
		fChain.doFilter(req, res, fChain);
		System.out.println(req.request);
		System.out.println(res.response);
	}
}
