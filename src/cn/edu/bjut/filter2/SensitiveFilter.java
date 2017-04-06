package cn.edu.bjut.filter2;

public class SensitiveFilter implements Filter {

	@Override
	public boolean doFilter(Request request, Response response,
			FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replaceAll("敏感", ""));
		request.setRequestStr(request.getRequestStr() + "SensitiveFilter:doFilter:request");
		chain.doFilter(request, response);
		response.setResponseStr(response.getResponseStr() + "SensitiveFilter:doFilter:response");
		return false;
	}

}
