package cc.dozer.chainWithLambda;

/**
 * Created by Dozer on 11/6/14.
 */
public interface FilterWithChainAndLambda {
	void doFilter(FilterChainFunctionalInterface action, FilterChainAndLambdaWrapper chain);
}
