package cc.dozer.lambda;

/**
 * Created by Dozer on 11/6/14.
 */
public class FilterWithLambdaImpl implements FilterWithLambda {
	@Override public void doFilter(FilterFunctionalInterface func) {
		func.doFilter();
	}
}
