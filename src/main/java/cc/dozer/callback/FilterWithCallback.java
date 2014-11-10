package cc.dozer.callback;

/**
 * Created by Dozer on 11/6/14.
 */
public interface FilterWithCallback {
	<S> void doFilter(S source,FilterCallBack<S> func);
}
