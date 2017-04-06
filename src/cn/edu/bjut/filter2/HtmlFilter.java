package cn.edu.bjut.filter2;

public class HtmlFilter implements Filter {

	
	@Override
	public boolean doFilter(Request request, Response response,
			FilterChain chain) {
		// TODO Auto-generated method stub
		request.setRequestStr(request.getRequestStr().replaceAll("<", "["));
		request.setRequestStr(request.getRequestStr().replaceAll(">", "]"));
		request.setRequestStr(request.getRequestStr() + "HtmlFilter:doFilter:request");
		chain.doFilter(request, response);
		response.setResponseStr(response.getResponseStr() + "HtmlFilter:doFilter:response");
		return false;
	}

}
