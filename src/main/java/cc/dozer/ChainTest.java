package cc.dozer;

import cc.dozer.callback.FilterCallBack;
import cc.dozer.callback.FilterWithCallBackImpl;
import cc.dozer.callback.FilterWithCallBackWrapper;
import cc.dozer.callback.FilterWithCallback;
import cc.dozer.chain.FilterChainWrapper;
import cc.dozer.chain.FilterWithChain;
import cc.dozer.chain.FilterWithChainImpl;
import cc.dozer.lambda.FilterWithLambda;
import cc.dozer.lambda.FilterWithLambdaImpl;
import cc.dozer.lambda.FilterWithLambdaWrapper;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dozer on 11/6/14.
 */
public class ChainTest {
	public void originMethod() {
	}

	private static List<FilterWithChain> oneChainFilter;

	private static List<FilterWithChain> fiveChainFilter;

	private static List<FilterWithLambda> oneLambdaFilter;

	private static List<FilterWithLambda> fiveLambdaFilter;

	private static List<FilterWithCallback> oneCallBackFilter;

	private static List<FilterWithCallback> fiveCallBackFilter;

	static {
		oneChainFilter = new ArrayList<>();
		oneChainFilter.add(new FilterWithChainImpl());

		fiveChainFilter = new ArrayList<>();
		fiveChainFilter.add(new FilterWithChainImpl());
		fiveChainFilter.add(new FilterWithChainImpl());
		fiveChainFilter.add(new FilterWithChainImpl());
		fiveChainFilter.add(new FilterWithChainImpl());
		fiveChainFilter.add(new FilterWithChainImpl());

		oneLambdaFilter = new ArrayList<>();
		oneLambdaFilter.add(new FilterWithLambdaImpl());

		fiveLambdaFilter = new ArrayList<>();
		fiveLambdaFilter.add(new FilterWithLambdaImpl());
		fiveLambdaFilter.add(new FilterWithLambdaImpl());
		fiveLambdaFilter.add(new FilterWithLambdaImpl());
		fiveLambdaFilter.add(new FilterWithLambdaImpl());
		fiveLambdaFilter.add(new FilterWithLambdaImpl());

		oneCallBackFilter = new ArrayList<>();
		oneCallBackFilter.add(new FilterWithCallBackImpl());

		fiveCallBackFilter = new ArrayList<>();
		fiveCallBackFilter.add(new FilterWithCallBackImpl());
		fiveCallBackFilter.add(new FilterWithCallBackImpl());
		fiveCallBackFilter.add(new FilterWithCallBackImpl());
		fiveCallBackFilter.add(new FilterWithCallBackImpl());
		fiveCallBackFilter.add(new FilterWithCallBackImpl());
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Threads(value = 5)
	@Warmup(iterations = 2, time = 1)
	@Measurement(iterations = 5, time = 1)
	@Fork(value = 2)
	public void withOneChain() {
		FilterChainWrapper chain = new FilterChainWrapper(oneChainFilter);
		chain.doFilter(this, chain);
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Threads(value = 5)
	@Warmup(iterations = 2, time = 1)
	@Measurement(iterations = 5, time = 1)
	@Fork(value = 2)
	public void withFiveChain() {
		FilterChainWrapper chain = new FilterChainWrapper(fiveChainFilter);
		chain.doFilter(this, chain);
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Threads(value = 5)
	@Warmup(iterations = 2, time = 1)
	@Measurement(iterations = 5, time = 1)
	@Fork(value = 2)
	public void withOneCallBack() {
		FilterWithCallBackWrapper wrapper = new FilterWithCallBackWrapper(oneCallBackFilter);
		wrapper.doFilter(this, new FilterCallBack<ChainTest>() {
			@Override public void doFilter(ChainTest source) {
				source.originMethod();
			}
		});
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Threads(value = 5)
	@Warmup(iterations = 2, time = 1)
	@Measurement(iterations = 5, time = 1)
	@Fork(value = 2)
	public void withFiveCallBack() {
		FilterWithCallBackWrapper wrapper = new FilterWithCallBackWrapper(fiveCallBackFilter);
		wrapper.doFilter(this, new FilterCallBack<ChainTest>() {
			@Override public void doFilter(ChainTest source) {
				source.originMethod();
			}
		});
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Threads(value = 5)
	@Warmup(iterations = 2, time = 1)
	@Measurement(iterations = 5, time = 1)
	@Fork(value = 2)
	public void withOneLambda() {
		FilterWithLambdaWrapper wrapper = new FilterWithLambdaWrapper(oneLambdaFilter);
		wrapper.doFilter(() -> this.originMethod());
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Threads(value = 5)
	@Warmup(iterations = 2, time = 1)
	@Measurement(iterations = 5, time = 1)
	@Fork(value = 2)
	public void withFiveLambda() {
		FilterWithLambdaWrapper wrapper = new FilterWithLambdaWrapper(fiveLambdaFilter);
		wrapper.doFilter(() -> this.originMethod());
	}
}
