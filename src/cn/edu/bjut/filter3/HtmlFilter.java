package cn.edu.bjut.filter3;

public class HtmlFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.bjut.filter3.Filter#doFilter(cn.edu.bjut.filter3.Request,
	 * cn.edu.bjut.filter3.Response, cn.edu.bjut.filter3.FilterChain)
	 * 将request里的content中所有的(替换成[，所有的)替换成]
	 */
	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		// TODO Auto-generated method stub
		String content = request.getContent();
		String tempContent = content.replaceAll("[(]", "[");//或者\\(
		String tempContent1 = tempContent.replaceAll("[)]", "]");//\\)
		if (chain.getIndex() == 0)
			response.setAnswer(tempContent1);
		else
			request.setContent(tempContent1);
		chain.doFilter(request, response);
	}

}
