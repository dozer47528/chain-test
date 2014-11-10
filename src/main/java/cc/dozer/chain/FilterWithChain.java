package cc.dozer.chain;

import cc.dozer.ChainTest;

/**
 * Created by Dozer on 11/6/14.
 */
public interface FilterWithChain {
	void doFilter(ChainTest source, FilterChainWrapper chain);
}
