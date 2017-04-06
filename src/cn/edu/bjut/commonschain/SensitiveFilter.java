package cn.edu.bjut.commonschain;

public class SensitiveFilter implements Filter {

	@Override
	public boolean doFilter(Request request, Response response) {
		request.setRequestStr(request.getRequestStr().replaceAll("敏感", ""));
		request.setRequestStr(request.getRequestStr() + ":SensitiveFilter:doFilter:request");
		return false;
	}

	@Override
	public void process(Request request, Response response) {
		// TODO Auto-generated method stub
		response.setResponseStr(response.getResponseStr() + ":SensitiveFilter:doFilter:response");
	}

}
