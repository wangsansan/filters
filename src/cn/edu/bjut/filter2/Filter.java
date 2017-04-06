package cn.edu.bjut.filter2;

public interface Filter {
	boolean doFilter(Request request, Response response, FilterChain chain);
}
