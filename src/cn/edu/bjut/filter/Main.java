package cn.edu.bjut.filter;

public class Main {

	public static void main(String[] args) {
		Request request = new Request();
		Response response = new Response();
		request.setRequestStr("request<scrip>敏感词");
		response.setResponseStr("response");
		FilterChain fc = new FilterChain();
		fc.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());
		fc.doFilter(request, response, fc);
		System.out.println(request.getRequestStr());
		System.out.println(response.getResponseStr());
	}

}
