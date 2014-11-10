package cc.dozer.callback;

import java.util.List;

/**
 * Created by Dozer on 11/6/14.
 */
public class FilterWithCallBackWrapper implements FilterWithCallback {
	private final List<FilterWithCallback> filters;

	public FilterWithCallBackWrapper(List<FilterWithCallback> filters) {
		this.filters = filters;
	}

	@Override
	public <S> void doFilter(S source, final FilterCallBack<S> func) {
		FilterCallBack<S> todo = func;

		for (FilterWithCallback filter : filters) {
			final FilterCallBack<S> finalTodo = todo;

			todo = new FilterCallBack<S>() {
				@Override public void doFilter(S source) {
					filter.doFilter(source, finalTodo);
				}
			};
		}

		func.doFilter(source);
	}
}
