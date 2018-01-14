package com.stream.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


/**
 * https://segmentfault.com/a/1190000010166897
 * Collector<T, A, R>�ӿڵķ�����һ��5��
 * Supplier<A> supplier()
 * BiConsumer<A, T> accumulator()
 * BinaryOperator<A> combiner()
 * Function<A, R> finisher()
 * Set<Characteristics> characteristics()
 * �������з��ͣ�����Ҫ��Ҫ���ܹ�Collector�е���������T, A, R
 * T��stream�ڵ���collect�����ռ�ǰ����������
 * A��A��T���ۼ���������T��ʱ�򣬻��T����һ���ķ�ʽ��ӵ�A�У����仰˵���ǰ�һЩTͨ��һ�ַ�ʽ���A
 * R��R���Կ�����A���ۼ����������յĽ�����ǰ�A���֮����������ͣ����仰˵���ǰ�һЩAͨ��һ�ַ�ʽ���R
 * @author zxz
 *
 */
public class Test02 {

	
	public static void main(String[] args) {
		
		
		List<Map<String, Object>> lists=new ArrayList<>();
		Map<String, Object> map1=new HashMap<>();
		Map<String, Object> map2=new HashMap<>();
		lists.add(map1);
		lists.add(map2);
		map1.put("k1", 1);
		map1.put("k2", 1.0D);
		map2.put("k1", 2);
		map2.put("k2", 2.0D);
		
		//Collector<T, A, R>
		//T��stream�ڵ���collect�����ռ�ǰ����������
		//A��A��T���ۼ���������T��ʱ�򣬻��T����һ���ķ�ʽ��ӵ�A�У����仰˵���ǰ�һЩTͨ��һ�ַ�ʽ���A
		//R��R���Կ�����A���ۼ����������յĽ�����ǰ�A���֮����������ͣ����仰˵���ǰ�һЩAͨ��һ�ַ�ʽ���R
		//Collector<T, ?, List<T>> toList() {
		//		 return new CollectorImpl<>((Supplier<List<T>>) ArrayList::new, List::add,
		//		                            (left, right) -> { left.addAll(right); return left; },
		//		                             CH_ID);
		//(Supplier<List<T>>) ArrayList::new ��ӦSupplier<A> supplier()��һ������
		//List::add ��ӦBiConsumer<A, T> accumulator()�ڶ�������
		//(left, right) -> { left.addAll(right); return left; }��ӦBinaryOperator<A> combiner()����������
		
		Collector<Map<String, Object>, List<Map<String, Object>> , List<Integer>> collector=new Collector<Map<String,Object>, List<Map<String,Object>>, List<Integer>>() {

			@Override
			public Supplier<List<Map<String, Object>>> supplier() {
				return ArrayList::new;
			}

			@Override
			public BiConsumer<List<Map<String, Object>>, Map<String, Object>> accumulator() {
				return (left, right) -> {
					System.out.println("left:"+left);
					System.out.println("left:"+right);
				};
			}

			@Override
			public BinaryOperator<List<Map<String, Object>>> combiner() {
				return (left, right) -> { 
					//left.addAll(right); 
					return left; 
					};
			}

			@Override
			public Function<List<Map<String, Object>>, List<Integer>> finisher() {
				return null;
			}

			@Override
			public Set<Characteristics> characteristics() {
				return null;
			}
		};
		
		List<Integer> l=lists.stream().collect(collector);
		System.out.println(l);
	}
}
