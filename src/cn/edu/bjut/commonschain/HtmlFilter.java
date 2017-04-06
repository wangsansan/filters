package cn.edu.bjut.commonschain;

public class HtmlFilter implements Filter {

	
	@Override
	public boolean doFilter(Request request, Response response) {
		// TODO Auto-generated method stub
		request.setRequestStr(request.getRequestStr().replaceAll("<", "["));
		request.setRequestStr(request.getRequestStr().replaceAll(">", "]"));
		request.setRequestStr(request.getRequestStr() + ":HtmlFilter:doFilter:request");
		if(request.getRequestStr().contains("hello"))
			return true;
		return false;
	}

	@Override
	public void process(Request request, Response response) {
		// TODO Auto-generated method stub
		response.setResponseStr(response.getResponseStr() + ":HtmlFilter:doFilter:response");
	}

}
