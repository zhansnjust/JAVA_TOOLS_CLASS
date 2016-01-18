package chainOfResponsibility;

public interface Filter {
	void doFilter(Request req,Response res,Filter filterChain);
}
