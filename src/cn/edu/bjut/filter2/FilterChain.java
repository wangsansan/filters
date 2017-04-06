package cn.edu.bjut.filter2;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {

	private List<Filter> filters = new ArrayList<>();
	private int index = 0;

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public FilterChain addFilter(Filter filter) {
		filters.add(filter);
		return this;
	}

	public void removeFilter(Filter filter) {
		filters.remove(filter);
	}

	public void doFilter(Request request, Response response) {
		if (index == filters.size())
			return;
		Filter filter = filters.get(index);
		index++;
		boolean flag = filter.doFilter(request, response, this);
		if (flag)
			return;
	}

}
