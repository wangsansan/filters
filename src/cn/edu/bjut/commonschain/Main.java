package cn.edu.bjut.commonschain;

public class Main {

	public static void main(String[] args) {
		Request request = new Request();
		Response response = new Response();
		request.setRequestStr("request<scrip>敏感词hello");
		response.setResponseStr("response");
		FilterChain fc = FilterChain.getInstance();
		fc.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());
		fc.execute(request, response);
		System.out.println(request.getRequestStr());
		System.out.println(response.getResponseStr());
	}

}
