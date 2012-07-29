package myproject.generics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStack<E> {
	
	private E[] elements;
	private int top;
	
	public MyStack() {
		elements =  (E[]) new Object[10];
	}
	
	public E pop() {
		E e = elements[--top];
		elements[top] = null;
		return e;
	}
	
	public void push(E e) {
		elements[top++] = e;
	}
	
	public boolean isEmpty() {
		return top <= 0;
	}
	
	public static void main(String[] args) {
		MyStack<String> myStringStack = new MyStack<String>();
		myStringStack.push("A");
		myStringStack.push("B");
		myStringStack.push("C");
		myStringStack.push("D");
		myStringStack.push("E");
		
		while (!myStringStack.isEmpty()) {
			System.out.println(myStringStack.pop());
		}
		
		MyStack<Integer> myIntegerStack = new MyStack<Integer>();
		myIntegerStack.push(1);
		myIntegerStack.push(2);
		myIntegerStack.push(3);
		myIntegerStack.push(4);
		
		while (!myIntegerStack.isEmpty()) {
			System.out.println(myIntegerStack.pop());
		}
		
		Map<String, List<Integer>> map = newHashMap();
		map.put("a", Arrays.asList(1));
		map.put("b", Arrays.asList(2));
		map.put("c", Arrays.asList(3));
		map.put("c", Arrays.asList(4));
		
		for(String s : map.keySet()) {
			System.out.println(s + " : " + map.get(s));
		}
		
		
	}

	private static <K, T> Map<K, List<T>> newHashMap() {
		return new HashMap<K, List<T>>();
	}

}
