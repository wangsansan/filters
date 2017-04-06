package cn.edu.bjut.commonschain;

public interface Filter {
	boolean doFilter(Request request, Response response);
	void process(Request request, Response response);
}
