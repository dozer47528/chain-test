package cc.dozer.lambda;

import java.util.List;

/**
 * Created by Dozer on 11/6/14.
 */
public class FilterWithLambdaWrapper implements FilterWithLambda {

	private final List<FilterWithLambda> filters;

	public FilterWithLambdaWrapper(List<FilterWithLambda> filters) {
		this.filters = filters;
	}

	@Override public void doFilter(final FilterFunctionalInterface func) {
		FilterFunctionalInterface todo = func;

		for (FilterWithLambda filter : filters) {
			final FilterFunctionalInterface finalTodo = todo;
			todo = () -> filter.doFilter(finalTodo);
		}

		todo.doFilter();
	}
}
