package cc.dozer.callback;

/**
 * Created by Dozer on 11/6/14.
 */
public class FilterWithCallBackImpl implements FilterWithCallback {
	@Override public <S> void doFilter(S source, FilterCallBack<S> func) {
		func.doFilter(source);
	}
}
