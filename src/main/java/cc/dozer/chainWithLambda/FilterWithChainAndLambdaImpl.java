package cc.dozer.chainWithLambda;

/**
 * Created by Dozer on 11/6/14.
 */
public class FilterWithChainAndLambdaImpl implements FilterWithChainAndLambda {
	@Override public void doFilter(FilterChainFunctionalInterface action, FilterChainAndLambdaWrapper chain) {
		chain.doFilter(action, chain);
	}
}
