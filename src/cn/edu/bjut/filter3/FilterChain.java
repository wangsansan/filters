package cn.edu.bjut.filter3;

import java.util.LinkedList;
import java.util.List;

import javax.swing.text.ChangedCharSetException;

public class FilterChain {

	List<Filter> filters = new LinkedList<>();
	int index = 0;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public FilterChain addFilter(Filter filter) {
		filters.add(filter);
		index++;
		return this;
	}

	public void removeFilter(Filter filter) {
		filters.remove(filter);
		index--;
	}

	void doFilter(Request request, Response response) {
		index--;
		if (index >= 0) {
			Filter filter = filters.get(index);
			filter.doFilter(request, response, this);
		}

	}

	public static void main(String[] args) {
		FilterChain chain = new FilterChain();
		Filter htmlFilter = new HtmlFilter();
		Filter sensitiveFilter = new SensitiveFilter();
		chain.addFilter(htmlFilter).addFilter(sensitiveFilter);
		Request request = new Request();
		String content = "我们的祖国是花园，花园的花朵不敏感，(哇哈哈)，(娃哈哈)";
		request.setContent(content);
		Response response = new Response();
		chain.doFilter(request, response);
		String answer = response.getAnswer();
		System.out.println(answer);
	}

}
