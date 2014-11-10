package cc.dozer.chain;

import cc.dozer.ChainTest;

import java.util.List;

/**
 * Created by Dozer on 11/6/14.
 */
public class FilterChainWrapper implements FilterWithChain {

	private final List<FilterWithChain> filters;

	public int index = 0;

	public FilterChainWrapper(List<FilterWithChain> filters) {
		this.filters = filters;
	}

	@Override public void doFilter(ChainTest source, FilterChainWrapper chain) {
		if (index < filters.size()) {
			filters.get(index++).doFilter(source, chain);
		} else {
			source.originMethod();
		}
	}
}
