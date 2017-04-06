package cn.edu.bjut.filter;

public class SensitiveFilter implements Filter {

	@Override
	public boolean doFilter(Request request, Response response,
			FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replaceAll("敏感", ""));
		chain.doFilter(request, response, chain);
		response.setResponseStr(response.getResponseStr() + ":SensitiveFilter:doFilter:response");
		return false;
	}

}
