package cn.edu.bjut.filter;

public interface Filter {
	boolean doFilter(Request request, Response response, FilterChain chain);
}
