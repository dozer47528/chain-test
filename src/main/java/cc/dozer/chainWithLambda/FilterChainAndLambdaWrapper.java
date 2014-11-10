package cc.dozer.chainWithLambda;

import java.util.List;

/**
 * Created by Dozer on 11/6/14.
 */
public class FilterChainAndLambdaWrapper implements FilterWithChainAndLambda {

	private final List<FilterWithChainAndLambda> filters;

	public int index = 0;

	public FilterChainAndLambdaWrapper(List<FilterWithChainAndLambda> filters) {
		this.filters = filters;
	}

	@Override public void doFilter(FilterChainFunctionalInterface action, FilterChainAndLambdaWrapper chain) {
		if (index < filters.size()) {
			filters.get(index++).doFilter(action, chain);
		} else {
			action.doFilter();
		}
	}
}
