package cc.dozer.chain;

import cc.dozer.ChainTest;

/**
 * Created by Dozer on 11/6/14.
 */
public class FilterWithChainImpl implements FilterWithChain {
	@Override public void doFilter(ChainTest source, FilterChainWrapper chain) {
		chain.doFilter(source, chain);
	}
}
