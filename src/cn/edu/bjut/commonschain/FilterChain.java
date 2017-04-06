package cn.edu.bjut.commonschain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
	
	private static FilterChain instance = new FilterChain();
	
	private FilterChain(){
		
	}
	
	public static FilterChain getInstance(){
		return instance;
	}

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
		for(Filter filter:filters){
			boolean flag = filter.doFilter(request, response);
			index++;
			if(flag == true)
				break;
		}
	}
	
	void process(Request request, Response response){
		for(int i = index - 1; i >= 0; i--)
			filters.get(i).process(request, response);
	}
	
	void execute(Request request, Response response){
		doFilter(request,response);
		process(request, response);
	}

}
