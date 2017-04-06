package cn.edu.bjut.filter3;

public class SensitiveFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.bjut.filter3.Filter#doFilter(cn.edu.bjut.filter3.Request,
	 * cn.edu.bjut.filter3.Response, cn.edu.bjut.filter3.FilterChain)
	 * 将request里面的“敏感”换成“和谐”
	 */
	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		String tempContent1 = request.getContent().replaceAll("敏感", "和谐");
		if (chain.getIndex() == 0)
			response.setAnswer(tempContent1);
		else
			request.setContent(tempContent1);
		chain.doFilter(request, response);
	}

}
