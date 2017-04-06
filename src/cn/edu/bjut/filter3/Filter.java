package cn.edu.bjut.filter3;

public interface Filter {
	
	void doFilter(Request request,Response response,FilterChain chain);
	
}
